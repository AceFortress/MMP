package pl.edu.agh.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.agh.model.LocationsRepo;

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
    public String startReadingLocationFromDatabase() throws InterruptedException, JsonProcessingException {
        while (true) {
            Thread.sleep(1000);
            this.template.convertAndSend("/topic/response", mapper.writeValueAsString(locationsRepo.findAll()));
            //return mapper.writeValueAsString(locationsRepo.findAll());
        }
    }
}
