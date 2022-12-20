package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class IFood implements DeliveryServiceStrategy {

    private static IFood iFoodInstance;
    public static final Double DELIVERY_PRICE = 3.0;

    /**
     * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
     * Pattern Singleton.
     *
     * @author João Guedes.
     */
    private IFood() {
        super();
    }

    /**
     * Método que retorna uma mesma instância da classe IFood.
     *
     * @return Retorna uma mesma instância da classe IFood.
     */
    public static IFood getInstance() {
        if (IFood.iFoodInstance == null) {
            IFood.iFoodInstance = new IFood();
        }
        return IFood.iFoodInstance;
    }

    @Override
    public double calculateDeliveryPrice() {
        return IFood.DELIVERY_PRICE;
    }

}