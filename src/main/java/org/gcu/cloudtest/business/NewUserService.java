package org.gcu.cloudtest.business;

import org.gcu.cloudtest.data.AuthDataService;
import org.gcu.cloudtest.data.UserDataService;
import org.gcu.cloudtest.data.entity.AuthEntity;
import org.gcu.cloudtest.data.entity.UserEntity;
import org.gcu.cloudtest.model.NewUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class NewUserService implements NewUserServiceInterface
{
    @Autowired
    UserDataService userDataService;

    @Autowired
    AuthDataService authDataService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(NewUserModel newUserModel)
    {
        UserEntity entity = new UserEntity(
                newUserModel.getUsername(),
                passwordEncoder.encode(newUserModel.getPassword()),
                1,
                newUserModel.getFirstName(),
                newUserModel.getLastName(),
                newUserModel.getEmail()
        );

        return userDataService.create(entity);
    }

    @Override
    public boolean addAuth(String username, String role)
    {
        AuthEntity entity = new AuthEntity(username, role);

        return authDataService.create(entity);
    }
}
