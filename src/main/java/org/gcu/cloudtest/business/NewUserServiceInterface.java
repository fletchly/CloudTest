package org.gcu.cloudtest.business;

import org.gcu.cloudtest.model.NewUserModel;

public interface NewUserServiceInterface
{
    boolean addUser(NewUserModel newUserModel);

    boolean addAuth(String username, String role);
}
