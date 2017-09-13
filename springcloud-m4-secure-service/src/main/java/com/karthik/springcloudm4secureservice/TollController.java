package com.karthik.springcloudm4secureservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@EnableResourceServer
public class TollController {

    @Autowired
    private ResourceServerProperties resourceServerProperties;

    @Bean
    public ResourceServerTokenServices myUserInfoTokenServices(){
        return new CustomUserInfoTokenServices(resourceServerProperties.getUserInfoUri(), resourceServerProperties.getClientId());
    }

    @PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPS')")
    @RequestMapping("/tollData")
    public List<TollUsage> getTollData(){
        TollUsage tollUsage = new TollUsage("1234", "Bedok", "SGH1234","2016-12-09");
        TollUsage tollUsage1 = new TollUsage("2345", "Bedok", "SGH2345","2016-12-10");
        TollUsage tollUsage2 = new TollUsage("3456", "Bedok", "SGH3456","2016-12-11");

        List<TollUsage> tollUsages = Arrays.asList(tollUsage, tollUsage1, tollUsage2);
        return  tollUsages;
    }

}
