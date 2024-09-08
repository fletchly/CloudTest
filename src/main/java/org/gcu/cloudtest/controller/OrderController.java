package org.gcu.cloudtest.controller;

import org.gcu.cloudtest.business.OrdersBusinessService;
import org.gcu.cloudtest.business.OrdersBusinessServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController
{
    private final OrdersBusinessServiceInterface ordersBusinessService;

    public OrderController(OrdersBusinessServiceInterface ordersBusinessService)
    {
        this.ordersBusinessService = ordersBusinessService;
    }

    @GetMapping("")
    public String orders(Model model)
    {
        model.addAttribute("orders", ordersBusinessService.getOrders());

        return "orders";
    }
}
