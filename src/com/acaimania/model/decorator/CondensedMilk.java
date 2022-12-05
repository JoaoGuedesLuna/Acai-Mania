package com.acaimania.model.decorator;

import com.acaimania.model.Acai;

/**
 * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Leite Condensado.
 *
 * @author João Guedes.
 */
public class CondensedMilk extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

    /**
     * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Leite Condensado.
     *
     * @author João Guedes.
     */
    public CondensedMilk(Acai acai) {
        super(acai);
    }

    @Override
    public void list() {
        super.getACAI().list();
        System.out.println("✔ Leite Condesado");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + CondensedMilk.ADDITIONAL_PRICE;
    }

}