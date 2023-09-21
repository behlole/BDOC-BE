package com.behlole.authentication.controllers;

import com.behlole.authentication.config.AuthenticationConfig;
import com.behlole.authentication.mappings.CMSResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {
    @Autowired
    AuthenticationConfig authenticationConfig;

    @GetMapping
    public Map<String, Object> getCustomers() {
        Map<String, Object> jsonObject = new HashMap<>();
        List cmsResponseBody = authenticationConfig.restTemplate().getForObject(
                "http://CMS/api/v1/cms",
                List.class
        );
        jsonObject.put("cms", cmsResponseBody);
        return jsonObject;
    }
}
