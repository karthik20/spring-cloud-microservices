package com.karthik.springcloudm4secureauth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    @RequestMapping("/user")
    public Principal getUser(final Principal user){
        return user;
    }
}
