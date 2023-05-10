package com.shopping.ecommerce.service;

import com.shopping.ecommerce.dto.Purchase;
import com.shopping.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
