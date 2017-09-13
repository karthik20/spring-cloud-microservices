package com.karthik.springcloudm4secureui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter{

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping("/")
    public String loadHome(){
        return "home";
    }

    @RequestMapping("/reports")
    public String loadReports(final Model model){
        OAuth2AccessToken oAuth2AccessToken = oAuth2ClientContext.getAccessToken();
        System.out.println("Token ::::"+oAuth2AccessToken);

        ResponseEntity<List<TollUsage>> tollUsages = oAuth2RestTemplate
                .exchange("http://localhost:9001/services/tollData", HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<TollUsage>>() {});

        model.addAttribute("tolls", tollUsages.getBody());

        return "reports";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
            .anyRequest()
                .authenticated();
    }
}
