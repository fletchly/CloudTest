package org.gcu.cloudtest.config;

import org.gcu.cloudtest.business.NewUserService;
import org.gcu.cloudtest.business.NewUserServiceInterface;
import org.gcu.cloudtest.business.OrdersBusinessService;
import org.gcu.cloudtest.business.OrdersBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SpringConfig
{
    @Bean(name = "ordersBusinessService")
    public OrdersBusinessServiceInterface getOrdersBusinessService()
    {
        return new OrdersBusinessService();
    }

    @Bean(name = "newUserService")
    public NewUserServiceInterface getNewUsersService()
    {
        return new NewUserService();
    }

    @Bean
    @SessionScope
    public Authentication getAuth()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
