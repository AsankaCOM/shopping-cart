package com.cart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CustomerOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String customerName;

  private String email;

  public CustomerOrder(String customerName, String email) {
    this.customerName = customerName;
    this.email = email;
  }
}
