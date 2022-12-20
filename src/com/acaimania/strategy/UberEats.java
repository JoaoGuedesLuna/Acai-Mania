package com.acaimania.strategy;

/**
 * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
 * Pattern Singleton.
 *
 * @author João Guedes.
 */
public class UberEats implements DeliveryServiceStrategy {

    private static UberEats uberEatsInstance;
    public static final Double DELIVERY_PRICE = 3.75;

    /**
     * Essa classe é uma implementação da estratégia DeliveryServiceStrategy, nela também está sendo usado o Design
     * Pattern Singleton.
     *
     * @author João Guedes.
     */
    private UberEats() {
        super();
    }

    /**
     * Método que retorna uma mesma instância da classe UberEats.
     *
     * @return Retorna uma mesma instância da classe UberEats.
     */
    public static UberEats getInstance() {
        if (UberEats.uberEatsInstance == null) {
            UberEats.uberEatsInstance = new UberEats();
        }
        return UberEats.uberEatsInstance;
    }

    @Override
    public double calculateDeliveryPrice() {
        return UberEats.DELIVERY_PRICE;
    }

}