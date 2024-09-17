package org.gcu.cloudtest.controller;

import jakarta.validation.Valid;
import org.gcu.cloudtest.business.NewUserService;
import org.gcu.cloudtest.business.NewUserServiceInterface;
import org.gcu.cloudtest.data.entity.UserEntity;
import org.gcu.cloudtest.model.NewUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newUser")
public class NewUserController
{
    @Autowired
    NewUserServiceInterface newUserService;

    @GetMapping("")
    public String displayNewUserForm(Model model)
    {
        model.addAttribute("title", "new-user");
        model.addAttribute("newUserModel", new NewUserModel());
        return "new-user";
    }

    @PostMapping("/create")
    public String processNewUserForm(@Valid NewUserModel newUserModel, BindingResult bindingResult)
    {
        newUserService.addUser(newUserModel);
        newUserService.addAuth(newUserModel.getUsername(), "USER");

        return "redirect:/";
    }
}
