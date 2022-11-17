package com.acaimania.decorator;


import com.acaimania.model.Acai;

public class Kiwi extends AcaiAdditional {

    public static final Double PRICE = 1.0;

    public Kiwi(Acai acai) {
        super(acai);
    }

    @Override
    public void make() {
        super.getACAI().make();
        System.out.println("✔ Kiwi");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + PRICE;
    }

}