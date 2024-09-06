package org.gcu.cloudtest.business;

public class SecurityBusinessService
{
    public boolean authenticate(String username, String password)
    {
        System.out.println("Test -> SecurityBusinessService.authenticate()");
        return true;
    }
}
