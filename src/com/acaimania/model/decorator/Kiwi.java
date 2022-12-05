package com.acaimania.model.decorator;


import com.acaimania.model.Acai;

public class Kiwi extends Additional {

    public static final Double ADDITIONAL_PRICE = 1.0;

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