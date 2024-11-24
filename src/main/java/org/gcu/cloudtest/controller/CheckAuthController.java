package org.gcu.cloudtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckAuthController
{
    @Autowired
    Authentication authentication;

    @GetMapping("/checkAuth")
    public ResponseEntity<?> checkAuth(Model model)
    {
        return ResponseEntity.ok().body(authentication.getPrincipal());
    }
}
