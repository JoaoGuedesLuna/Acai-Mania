package com.acaimania.model.decorator;

import com.acaimania.model.Acai;

public class Pacoca extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

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