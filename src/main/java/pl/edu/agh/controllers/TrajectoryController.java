package pl.edu.agh.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.agh.model.LocationsEntity;
import pl.edu.agh.model.LocationsRepo;
import pl.edu.agh.model.UiDto;

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
        List<LocationsEntity> locations = locationsRepo.findAll();
        LocationsEntity from = locations.get(locations.size() - 60);
        LocationsEntity to = locations.get(locations.size() - 50);
        UiDto uiDto = new UiDto();
        uiDto.setFromX(from.getDoubleLatitude());
        uiDto.setFromY(from.getDoubleLongitude());
        uiDto.setToX(to.getDoubleLatitude());
        uiDto.setToY(to.getDoubleLongitude());
        uiDto.setTitleForm("From");
        uiDto.setDescriptionFrom("Device: " + from.getDeviceId() + "<br>" +
                "Timestamp: " + getDate(from).toString() + "<br>" +
                "Speed: " + from.getDoubleSpeed() + "<br>" +
                "Type: " + from.getProvider());
        uiDto.setTitleTo("To");
        uiDto.setDescriptionTo("Device: " + to.getDeviceId() + "<br>" +
                "Timestamp: " + getDate(to).minus(getDate(from).getMillis()) + "<br>" +
                "Speed: " + to.getDoubleSpeed());
        return uiDto;
    }

    private DateTime getDate(LocationsEntity from) {
        return new DateTime(Long.valueOf(
                from.getTimestamp().toString().replace(".", "").replace("E", "").substring(0, 13))
        );
    }
}
