package com.dnd.easyorder.dto;

import com.dnd.easyorder.entity.Order;
import com.dnd.easyorder.model.CustomerResponse;
import com.dnd.easyorder.model.OrderHistoryResponse;
import com.dnd.easyorder.model.OrderItemResponse;

import java.util.List;

public class OrderHistoryDTO {

    public OrderHistoryResponse mapOrderToResponse(Order order) {

        OrderHistoryResponse response = new OrderHistoryResponse();

        response.setId(order.getId());
        response.setPickupDate(order.getPickupDate());
        response.setStatus(order.getStatus());
        response.setSummaryNotes(order.getSummaryNotes());

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setName(order.getCustomer().getName());
        customerResponse.setPhone(order.getCustomer().getPhone());

        response.setCustomer(customerResponse);

        List<OrderItemResponse> items = order.getItems()
                .stream()
                .map(item -> {

                    OrderItemResponse itemResponse =
                            new OrderItemResponse();

                    //itemResponse.setId(item.getId());
                    itemResponse.setProductName(
                            item.getProductName()
                    );
                    itemResponse.setQuantity(
                            item.getQuantity()
                    );
                    itemResponse.setUnit(
                            item.getUnit()
                    );
                    itemResponse.setNote(
                            item.getNote()
                    );

                    return itemResponse;
                })
                .toList();

        response.setItems(items);

        return response;
    }
}
