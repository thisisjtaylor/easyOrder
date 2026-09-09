package com.dnd.easyorder.service;

import com.dnd.easyorder.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    public Customer getCustomerByPhone(String phone);
}
