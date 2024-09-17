package org.gcu.cloudtest.config;

import org.gcu.cloudtest.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.sql.DataSource;

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
}
