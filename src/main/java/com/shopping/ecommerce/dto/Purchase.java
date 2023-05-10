package com.shopping.ecommerce.dto;

import java.util.Set;

import com.shopping.ecommerce.entity.Address;
import com.shopping.ecommerce.entity.Customer;
import com.shopping.ecommerce.entity.Order;
import com.shopping.ecommerce.entity.OrderItem;

import lombok.Data;


@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}

