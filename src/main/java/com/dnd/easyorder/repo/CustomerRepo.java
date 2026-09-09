package com.dnd.easyorder.repo;

import com.dnd.easyorder.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findCustomerByPhone(String phone);
}
