package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class IFood implements DeliveryServiceStrategy {

    private static IFood iFood;
    public static final Double DELIVERYPRICE = 3.0;

    private IFood() {
        super();
    }

    public static IFood getInstance() {
        if (iFood == null) {
            iFood = new IFood();
        }
        return iFood;
    }

    @Override
    public double calculateDeliveryPrice() {
        return DELIVERYPRICE;
    }

}