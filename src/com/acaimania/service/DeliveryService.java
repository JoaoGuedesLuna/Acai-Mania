package com.acaimania.service;

import com.acaimania.strategy.DeliveryServiceStrategy;

public class DeliveryService {
    private final DeliveryServiceStrategy deliveryServiceStrategy;

    public DeliveryService(DeliveryServiceStrategy deliveryServiceStrategy) {
        this.deliveryServiceStrategy = deliveryServiceStrategy;
    }

    public double calculateDeliveryPrice() {
        return deliveryServiceStrategy.calculateDeliveryPrice();
    }

}