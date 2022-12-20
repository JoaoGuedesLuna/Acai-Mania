package com.acaimania.service;

import com.acaimania.strategy.DeliveryServiceStrategy;

/**
 * Essa é uma classe de serviço (Service) para regras de negócio relacionadas ao delivery.
 *
 * @author João Guedes.
 */
public class DeliveryService {
    private final DeliveryServiceStrategy deliveryServiceStrategy;

    /**
     * Essa é uma classe de serviço (Service) para regras de negócio relacionadas ao delivery.
     *
     * @param deliveryServiceStrategy Tipo de estratégia de delivery que será utilizada.
     */
    public DeliveryService(DeliveryServiceStrategy deliveryServiceStrategy) {
        this.deliveryServiceStrategy = deliveryServiceStrategy;
    }

    /**
     * Esse método retorna o valor de entrega do serviço prestado conforme as regras de negócio.
     *
     * @return Retorna o valor de entrega do serviço prestado conforme as regras de negócio.
     */
    public double calculateDeliveryPrice() {
        return deliveryServiceStrategy.calculateDeliveryPrice();
    }

}