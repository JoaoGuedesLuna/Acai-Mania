package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class NineNineFood implements DeliveryServiceStrategy {

    private static NineNineFood nineNineFood;
    public static final Double DELIVERYPRICE = 4.0;

    private NineNineFood() {
        super();
    }

    public static NineNineFood getInstance() {
        if (nineNineFood == null) {
            nineNineFood = new NineNineFood();
        }
        return nineNineFood;
    }

    @Override
    public double calculateDeliveryPrice() {
        return DELIVERYPRICE;
    }

}