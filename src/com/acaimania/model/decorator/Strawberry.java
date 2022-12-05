package com.acaimania.model.decorator;

import com.acaimania.model.Acai;

/**
 * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Morango.
 *
 * @author João Guedes.
 */
public class Strawberry extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

    /**
     * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Morango.
     *
     * @author João Guedes.
     */
    public Strawberry(Acai acai) {
        super(acai);
    }

    @Override
    public void list() {
        super.getACAI().list();
        System.out.println("✔ Morango");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + Strawberry.ADDITIONAL_PRICE;
    }

}