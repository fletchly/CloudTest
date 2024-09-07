package org.gcu.cloudtest.business;

import org.gcu.cloudtest.data.OrderDataService;
import org.gcu.cloudtest.data.entity.OrderEntity;
import org.gcu.cloudtest.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class OrdersBusinessService implements OrdersBusinessServiceInterface
{
    @Autowired
    OrderDataService orderDataService;

    @Override
    public void test()
    {
        System.out.println("Test -> OrdersBusinessService.test()");
    }

    @Override
    public List<OrderModel> getOrders()
    {
        List<OrderEntity> ordersEntity = orderDataService.findAll();
        List<OrderModel> ordersDomain = new ArrayList<>();
        for (OrderEntity orderEntity : ordersEntity)
        {
            ordersDomain.add(new OrderModel(
                    orderEntity.getId(),
                    orderEntity.getOrderNo(),
                    orderEntity.getProductName(),
                    orderEntity.getPrice(),
                    orderEntity.getQuantity()));
        }
        return ordersDomain;
    }

    @Override
    public void init()
    {
        System.out.println("init -> OrdersBusinessService.init()");
    }

    @Override
    public void destroy()
    {
        System.out.println("destroy -> OrdersBusinessService.destroy()");
    }
}
