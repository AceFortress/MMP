package pl.edu.agh.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.agh.model.*;
import pl.edu.agh.prediction.Calculator;

import java.util.List;

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

    @RequestMapping("/start")
    @ResponseBody
    @MessageMapping("/request")
    @SendTo("/topic/response")
    public String startReadingLocationFromDatabase() throws InterruptedException, JsonProcessingException {
        while (true) {
            Thread.sleep(10000);
            List<LocationsEntity> locations = locationsRepo.findAll();
            this.template.convertAndSend("/topic/response", mapper.writeValueAsString(locations.get(locations.size() - 1)));
            //return mapper.writeValueAsString(locationsRepo.findAll());
        }
    }

    @RequestMapping("/getLastLocation")
    @ResponseBody
    public UiDto getLastLocation() {
        //TODO find locationEntity with corresponding gravityEntity
        //remember that timestamp are probably not the same and we need to find closest one
        LocationsEntity locationsEntity = new LocationsEntity();
        GravityEntity gravityEntity = new GravityEntity();
        //

        Point to = calculator.predict(gravityEntity, locationsEntity, 10);
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
        uiDto.setDescriptionTo("Time diffrence: " + 10);
        return uiDto;
    }

    private DateTime getDate(LocationsEntity from) {
        return new DateTime(Long.valueOf(
                from.getTimestamp().toString().replace(".", "").replace("E", "").substring(0, 13))
        );
    }
}
