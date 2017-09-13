package com.karthik.springcloudconfigm2client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RateController {
    @Value("${rate}")
    String rate;
    @Value("${lanecount}")
    String laneCount;
    @Value("${tollstart}")
    String tollStart;
    @Value("${encrypt_conn}")
    String connectionString;

    @RequestMapping("/rate")
    public String getRate(Model model){
        model.addAttribute("rate", rate);
        model.addAttribute("lanes", laneCount);
        model.addAttribute("tollStart", tollStart);
        model.addAttribute("connection", connectionString);
        return "rateview";
    }
}
