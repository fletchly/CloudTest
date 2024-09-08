package org.gcu.cloudtest.business;

import org.gcu.cloudtest.model.OrderModel;

import java.util.List;

public interface OrdersBusinessServiceInterface
{
    public List<OrderModel> getOrders();
}
