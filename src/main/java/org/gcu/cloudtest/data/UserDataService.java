package org.gcu.cloudtest.data;

import org.gcu.cloudtest.data.entity.UserEntity;
import org.gcu.cloudtest.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>
{
    @Autowired
    UsersRepository usersRepository;

    public UserDataService(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserEntity> findAll()
    {
        return List.of();
    }

    @Override
    public UserEntity findById(Long id)
    {
        return null;
    }

    @Override
    public boolean create(UserEntity userEntity)
    {
        try
        {
            usersRepository.save(userEntity);
        } catch (Exception e)
        {
            System.out.println("There was an error: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserEntity userEntity)
    {
        return false;
    }

    @Override
    public boolean delete(UserEntity userEntity)
    {
        return false;
    }
}
