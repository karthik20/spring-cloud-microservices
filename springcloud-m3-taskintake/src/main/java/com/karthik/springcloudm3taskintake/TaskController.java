package com.karthik.springcloudm3taskintake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired private TaskProcessor taskProcessor;

    @RequestMapping(path="/task", method = RequestMethod.POST)
    public @ResponseBody String launchTask(@RequestBody String req){
        taskProcessor.publishRequest(req);
        System.out.println("Got the request..");

        return "Success";

    }

}
