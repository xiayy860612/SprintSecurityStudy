package com.s2u2m.demo.oauth2.resource.endpoint;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "Index";
    }

    @GetMapping("/me")
    public Authentication getLoginName() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
