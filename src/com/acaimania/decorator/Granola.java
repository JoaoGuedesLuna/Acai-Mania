package com.acaimania.decorator;

import com.acaimania.model.Acai;

public class Granola extends AcaiAdditional {

    public static final Double PRICE = 1.0;

    public Granola(Acai acai) {
        super(acai);
    }

    @Override
    public void make() {
        super.getACAI().make();
        System.out.println("✔ Granola");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + PRICE;
    }

}