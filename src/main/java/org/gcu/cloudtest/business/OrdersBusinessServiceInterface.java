package org.gcu.cloudtest.business;

import org.gcu.cloudtest.model.OrderModel;

import java.util.List;

public interface OrdersBusinessServiceInterface
{
    public void test();

    public List<OrderModel> getOrders();

    public void init();

    public void destroy();
}
