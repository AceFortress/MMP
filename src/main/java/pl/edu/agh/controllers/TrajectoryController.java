package pl.edu.agh.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
}
