package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class NineNineFood implements DeliveryServiceStrategy {

    private static NineNineFood nineNineFoodInstance;
    public static final Double DELIVERY_PRICE = 4.0;

    /**
     * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
     * Pattern Singleton.
     *
     * @author João Guedes.
     */
    private NineNineFood() {
        super();
    }

    /**
     * Método que retorna uma mesma instância da classe NineNineFood.
     *
     * @return Retorna uma mesma instância da classe NineNineFood.
     */
    public static NineNineFood getInstance() {
        if (NineNineFood.nineNineFoodInstance == null) {
            NineNineFood.nineNineFoodInstance = new NineNineFood();
        }
        return NineNineFood.nineNineFoodInstance;
    }

    @Override
    public double calculateDeliveryPrice() {
        return NineNineFood.DELIVERY_PRICE;
    }

}