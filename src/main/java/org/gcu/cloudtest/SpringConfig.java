package org.gcu.cloudtest;

import org.gcu.cloudtest.business.OrdersBusinessService;
import org.gcu.cloudtest.business.OrdersBusinessServiceInterface;
import org.gcu.cloudtest.business.SecurityBusinessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SpringConfig
{
    @Bean(name = "ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrdersBusinessServiceInterface getOrdersBusinessService()
    {
        return new OrdersBusinessService();
    }

    @Bean(name = "securityBusinessService")
    @SessionScope
    public SecurityBusinessService getSecurityBusinessService()
    {
        return new SecurityBusinessService();
    }
}
