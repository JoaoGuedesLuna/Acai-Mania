package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class IFood implements DeliveryServiceStrategy {

    private static IFood iFood;
    public static final Double DELIVERY_PRICE = 3.0;

    private IFood() {
        super();
    }

    public static IFood getInstance() {
        if (IFood.iFood == null) {
            IFood.iFood = new IFood();
        }
        return IFood.iFood;
    }

    @Override
    public double calculateDeliveryPrice() {
        return IFood.DELIVERY_PRICE;
    }

}