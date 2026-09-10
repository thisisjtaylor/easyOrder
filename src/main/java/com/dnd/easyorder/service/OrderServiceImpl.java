package com.dnd.easyorder.service;

import com.dnd.easyorder.entity.Customer;
import com.dnd.easyorder.entity.Order;
import com.dnd.easyorder.model.*;
import com.dnd.easyorder.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderRepo orderRepo;


    @Override
    public List<OrderHistoryResponse> getOrderHistory(String phone) {

        Customer c = customerService.getCustomerByPhone(phone);

        List<Order> orders =
                orderRepo.findOrderByCustomer(c.getId());

        return orders.stream()
                .map(this::mapOrderToResponse)
                .toList();
    }

    @Override
    public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {
        return null;
    }

    public OrderHistoryResponse mapOrderToResponse(Order order) {

        OrderHistoryResponse response = new OrderHistoryResponse();

        response.setId(order.getId());
        response.setPickupDate(order.getPickupDate());
        response.setStatus(order.getStatus());
        response.setSummaryNotes(order.getSummaryNotes());

        CustomerResponse customerResponse = new CustomerResponse();

        //customerResponse.setId(order.getCustomer().getId());
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
