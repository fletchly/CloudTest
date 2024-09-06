package org.gcu.cloudtest.controller;

import jakarta.validation.Valid;
import org.gcu.cloudtest.model.LoginModel;
import org.gcu.cloudtest.model.OrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController
{
    @GetMapping("/")
    public String display(Model model)
    {
        model.addAttribute("title", "LoginForm");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("loginModel") @Valid LoginModel loginModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("title", "LoginForm");
            return "login";
        }

        // Activity 2 hard-coded data
        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
        orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 2));
        orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 3));
        orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 4));
        orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 5));

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        System.out.printf("Form with username of '%s' and password of '%s'%n", loginModel.getUsername(), loginModel.getPassword());
        return "orders";
    }
}
