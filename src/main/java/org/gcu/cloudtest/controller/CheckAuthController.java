package org.gcu.cloudtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckAuthController
{
    @Autowired
    Authentication authentication;

    @GetMapping("/checkAuth")
    public String checkAuth(Model model)
    {
        model.addAttribute("name", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());

        return "user";
    }
}
