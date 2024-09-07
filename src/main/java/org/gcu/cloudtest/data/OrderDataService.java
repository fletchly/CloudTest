package org.gcu.cloudtest.data;

import org.gcu.cloudtest.data.entity.OrderEntity;
import org.gcu.cloudtest.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>
{
    @Autowired
    OrdersRepository ordersRepository;

    public OrderDataService(OrdersRepository ordersRepository)
    {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<OrderEntity> findAll()
    {
        List<OrderEntity> orders = new ArrayList<>();

        try
        {
            Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
            ordersIterable.forEach(orders::add);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public OrderEntity findById(Long id)
    {
        return null;
    }

    @Override
    public boolean create(OrderEntity orderEntity)
    {
        try
        {
            ordersRepository.save(orderEntity);
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(OrderEntity orderEntity)
    {
        return true;
    }

    @Override
    public boolean delete(OrderEntity orderEntity)
    {
        return true;
    }
}
