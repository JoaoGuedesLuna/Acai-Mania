package com.acaimania.model.decorator;

import com.acaimania.model.Acai;

/**
 * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Kiwi.
 *
 * @author João Guedes.
 */
public class Kiwi extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

    /**
     * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Kiwi.
     *
     * @author João Guedes.
     */
    public Kiwi(Acai acai) {
        super(acai);
    }

    @Override
    public void list() {
        super.getACAI().list();
        System.out.println("✔ Kiwi");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + Kiwi.ADDITIONAL_PRICE;
    }

}