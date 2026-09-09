package com.dnd.easyorder.service;

import com.dnd.easyorder.model.OrderHistoryResponse;

import java.util.List;

public interface OrderService {
    public List<OrderHistoryResponse> getOrderHistory(String phone);
}
