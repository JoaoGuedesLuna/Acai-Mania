package com.acaimania.decorator;

import com.acaimania.model.Acai;

public class LeiteEmPo extends AcaiAdditional {

    public static final Double PRICE = 1.0;

    public LeiteEmPo(Acai acai) {
        super(acai);
    }

    @Override
    public void make() {
        super.getACAI().make();
        System.out.println("✔ Leite em Pó");
    }

    @Override
    public Double getPrice() {
        return super.getACAI().getPrice() + PRICE;
    }

}