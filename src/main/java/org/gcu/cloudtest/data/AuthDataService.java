package org.gcu.cloudtest.data;

import org.gcu.cloudtest.data.entity.AuthEntity;
import org.gcu.cloudtest.data.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthDataService implements DataAccessInterface<AuthEntity>
{

    @Autowired
    private AuthRepository authRepository;

    @Override
    public List<AuthEntity> findAll()
    {
        return List.of();
    }

    @Override
    public AuthEntity findById(Long id)
    {
        return null;
    }

    @Override
    public boolean create(AuthEntity authEntity)
    {
        try
        {
            authRepository.save(authEntity);
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(AuthEntity authEntity)
    {
        return false;
    }

    @Override
    public boolean delete(AuthEntity authEntity)
    {
        return false;
    }
}
