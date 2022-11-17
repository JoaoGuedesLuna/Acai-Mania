package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class YourSelfFood implements DeliveryServiceStrategy {

    private static YourSelfFood yourSelfFood;
    public static final Double DELIVERYPRICE = 3.0;

    private YourSelfFood() {
        super();
    }

    public static YourSelfFood getInstance() {
        if (yourSelfFood == null) {
            yourSelfFood = new YourSelfFood();
        }
        return yourSelfFood;
    }

    @Override
    public double calculateDeliveryPrice() {
        return DELIVERYPRICE;
    }

}