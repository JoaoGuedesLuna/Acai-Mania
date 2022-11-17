package com.acaimania.decorator;

import com.acaimania.model.Acai;

public class Morango extends AcaiAdditional {

    public static final Double PRICE = 1.0;

    public Morango(Acai acai) {
        super(acai);
    }

    @Override
    public void make() {
        super.getACAI().make();
        System.out.println("✔ Morango");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + PRICE;
    }

}