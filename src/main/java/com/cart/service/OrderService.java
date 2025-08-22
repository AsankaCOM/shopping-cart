package com.cart.service;

import com.cart.dto.OrderDTO;
import com.cart.model.CustomerOrder;
import com.cart.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public OrderDTO addOrder(CustomerOrder customerOrder) {
    customerOrder = orderRepository.save(customerOrder);

    return OrderDTO.builder()
        .id(customerOrder.getId())
        .build();
  }
}
