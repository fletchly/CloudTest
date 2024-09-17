package org.gcu.cloudtest.data.repository;

import org.gcu.cloudtest.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, String>
{
}
