package org.gcu.cloudtest.controller;

import jakarta.validation.Valid;
import org.gcu.cloudtest.business.OrdersBusinessServiceInterface;
import org.gcu.cloudtest.business.SecurityBusinessService;
import org.gcu.cloudtest.model.LoginModel;
import org.gcu.cloudtest.model.OrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController
{
    private final OrdersBusinessServiceInterface ordersBusinessService;

    private final SecurityBusinessService securityBusinessService;

    public LoginController(OrdersBusinessServiceInterface ordersBusinessService, SecurityBusinessService securityBusinessService)
    {
        this.ordersBusinessService = ordersBusinessService;
        this.securityBusinessService = securityBusinessService;
    }

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

        ordersBusinessService.test();
        securityBusinessService.authenticate(loginModel.getUsername(), loginModel.getPassword());

        List<OrderModel> orders = ordersBusinessService.getOrders();

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        System.out.printf("Form with username of '%s' and password of '%s'%n", loginModel.getUsername(), loginModel.getPassword());
        return "orders";
    }
}
