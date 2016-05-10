package pl.edu.agh.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.agh.model.*;
import pl.edu.agh.prediction.Calculator;

/**
 * Created by Radek on 11.04.2016.
 */

@Service
@Controller
public class TrajectoryController {

    @Autowired
    LocationsRepo locationsRepo;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    Calculator calculator;
    @Autowired
    GravityRepo gravityRepo;

    private SimpMessagingTemplate template;

    @Autowired
    public TrajectoryController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @RequestMapping("/getLastLocation")
    @ResponseBody
    public UiDto getLastLocation() {
        //TODO find locationEntity with corresponding gravityEntity
        //remember that timestamp are probably not the same and we need to find closest one

        LocationsEntity locationsEntity = locationsRepo.findFirstByTimestampGreaterThan(1.462897740000E12);
        GravityEntity gravityEntity = gravityRepo.findFirstByTimestampGreaterThan(1.462897740000E12);
        int timeToPredictInSeconds = 30;
        System.out.println("Device: " + gravityEntity.getDeviceId());
        System.out.println("Device: " + locationsEntity.getDeviceId());

        Point to = calculator.predict(gravityEntity, locationsEntity, timeToPredictInSeconds);
        System.out.println("From X: " + locationsEntity.getDoubleLatitude() + " From Y: " + locationsEntity.getDoubleLongitude());
        System.out.println("To   X: " + to.getX() + " To   Y: " + to.getY());

        UiDto uiDto = new UiDto();
        uiDto.setFromX(locationsEntity.getDoubleLatitude());
        uiDto.setFromY(locationsEntity.getDoubleLongitude());
        uiDto.setToX(to.getX());
        uiDto.setToY(to.getY());
        uiDto.setTitleForm("From");
        uiDto.setDescriptionFrom("Device: " + locationsEntity.getDeviceId() + "<br>" +
                "Timestamp: " + getDate(locationsEntity).toString() + "<br>" +
                "Speed: " + locationsEntity.getDoubleSpeed() + "<br>" +
                "Azimut: " + gravityEntity.getDoubleValues0() + "<br>" +
                "Type: " + locationsEntity.getProvider());
        uiDto.setTitleTo("To");
        uiDto.setDescriptionTo("Time difference: " + timeToPredictInSeconds);
        return uiDto;
    }

    private DateTime getDate(LocationsEntity from) {
        return new DateTime(Long.valueOf(
                from.getTimestamp().toString().replace(".", "").replace("E", "").substring(0, 13))
        );
    }
}
