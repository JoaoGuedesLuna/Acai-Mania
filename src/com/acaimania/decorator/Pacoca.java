package com.acaimania.decorator;

import com.acaimania.model.Acai;

public class Pacoca extends AcaiAdditional {

    public static final Double PRICE = 1.0;

    public Pacoca(Acai acai) {
        super(acai);
    }

    @Override
    public void make() {
        super.getACAI().make();
        System.out.println("✔ Paçoca");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + PRICE;
    }

}