package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class NineNineFood implements DeliveryServiceStrategy {

    private static NineNineFood nineNineFood;
    public static final Double DELIVERY_PRICE = 4.0;

    private NineNineFood() {
        super();
    }

    public static NineNineFood getInstance() {
        if (NineNineFood.nineNineFood == null) {
            NineNineFood.nineNineFood = new NineNineFood();
        }
        return NineNineFood.nineNineFood;
    }

    @Override
    public double calculateDeliveryPrice() {
        return NineNineFood.DELIVERY_PRICE;
    }

}