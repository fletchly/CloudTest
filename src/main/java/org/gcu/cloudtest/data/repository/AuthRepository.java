package org.gcu.cloudtest.data.repository;

import org.gcu.cloudtest.data.entity.AuthEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<AuthEntity, String>
{
}
