package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class YourSelfFood implements DeliveryServiceStrategy {

    private static YourSelfFood yourSelfFoodInstance;
    public static final Double DELIVERY_PRICE = 3.0;

    /**
     * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
     * Pattern Singleton.
     *
     * @author João Guedes.
     */
    private YourSelfFood() {
        super();
    }

    /**
     * Método que retorna uma mesma instância da classe YourSelfsFood.
     *
     * @return Retorna uma mesma instância da classe YourSelfFood.
     */
    public static YourSelfFood getInstance() {
        if (YourSelfFood.yourSelfFoodInstance == null) {
            YourSelfFood.yourSelfFoodInstance = new YourSelfFood();
        }
        return YourSelfFood.yourSelfFoodInstance;
    }

    @Override
    public double calculateDeliveryPrice() {
        return YourSelfFood.DELIVERY_PRICE;
    }

}