package com.acaimania.model.decorator;

import com.acaimania.model.Acai;

public class Muesli extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

    public Muesli(Acai acai) {
        super(acai);
    }

    @Override
    public void list() {
        super.getACAI().list();
        System.out.println("✔ Granola");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + Muesli.ADDITIONAL_PRICE;
    }

}