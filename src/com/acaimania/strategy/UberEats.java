package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class UberEats implements DeliveryServiceStrategy {

    private static UberEats uberEats;
    public static final Double DELIVERY_PRICE = 3.75;

    private UberEats() {
        super();
    }

    public static UberEats getInstance() {
        if (UberEats.uberEats == null) {
            UberEats.uberEats = new UberEats();
        }
        return UberEats.uberEats;
    }

    @Override
    public double calculateDeliveryPrice() {
        return UberEats.DELIVERY_PRICE;
    }

}