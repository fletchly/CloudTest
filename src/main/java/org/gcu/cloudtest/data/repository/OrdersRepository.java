package org.gcu.cloudtest.data.repository;

import org.gcu.cloudtest.data.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrderEntity, Long>
{
}
