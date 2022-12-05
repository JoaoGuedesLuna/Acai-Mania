package com.acaimania.model.decorator;

import com.acaimania.model.Acai;

/**
 * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Leite em Pó.
 *
 * @author João Guedes.
 */
public class MilkPowder extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

    /**
     * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Leite em Pó.
     *
     * @author João Guedes.
     */
    public MilkPowder(Acai acai) {
        super(acai);
    }

    @Override
    public void list() {
        super.getACAI().list();
        System.out.println("✔ Leite em Pó");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + MilkPowder.ADDITIONAL_PRICE;
    }

}