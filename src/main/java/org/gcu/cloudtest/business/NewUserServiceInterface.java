package org.gcu.cloudtest.business;

import org.gcu.cloudtest.model.NewUserModel;

public interface NewUserServiceInterface
{
    public boolean addUser(NewUserModel newUserModel);

    public boolean addAuth(String username, String role);
}
