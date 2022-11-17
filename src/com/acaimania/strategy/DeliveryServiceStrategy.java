package com.acaimania.strategy;

/**
 * Essa interface é uma abstração de um delivery de produto. Essa interface está sendo usada conforme o Design Pattern
 * Strategy.
 *
 * @author João Guedes.
 */
public interface DeliveryServiceStrategy {

    double calculateDeliveryPrice();

}