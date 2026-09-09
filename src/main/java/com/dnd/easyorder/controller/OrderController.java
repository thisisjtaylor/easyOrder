package com.dnd.easyorder.controller;

import com.dnd.easyorder.model.OrderHistoryResponse;
import com.dnd.easyorder.service.CustomerService;
import com.dnd.easyorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/order-service")
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderHistory")
    public ResponseEntity<List<OrderHistoryResponse>> getOrderHistory(@RequestParam String phone) {

        try {

            List<OrderHistoryResponse> orders =
                    orderService.getOrderHistory(phone);

            return ResponseEntity.ok(orders);

        } catch (Exception e) {

            return ResponseEntity
                    .internalServerError()
                    .build();
        }
    }
}
