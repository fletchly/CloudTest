package org.gcu.cloudtest.business;

import org.gcu.cloudtest.model.OrderModel;

import java.util.List;

public interface OrdersBusinessServiceInterface
{
    List<OrderModel> getOrders();
}
