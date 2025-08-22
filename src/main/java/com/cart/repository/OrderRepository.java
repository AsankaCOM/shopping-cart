package com.cart.repository;

import com.cart.model.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {
}