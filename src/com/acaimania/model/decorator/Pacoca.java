package com.acaimania.model.decorator;

import com.acaimania.model.Acai;

/**
 * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Paçoca.
 *
 * @author João Guedes
 */
public class Pacoca extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

    /**
     * Essa classe é uma implementação da classe Decorator Additional. Ela representa o adicional Paçoca.
     *
     * @author João Guedes
     */
    public Pacoca(Acai acai) {
        super(acai);
    }

    @Override
    public void list() {
        super.getACAI().list();
        System.out.println("✔ Paçoca");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + Pacoca.ADDITIONAL_PRICE;
    }

}