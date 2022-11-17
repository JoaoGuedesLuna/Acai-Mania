package com.acaimania.model;

/**
 * Essa classe herda da classe Acai, e é uma abstração básica de porção pequena de Açaí. O padrão de projeto utilizado
 * para a criação de objetos dessa classe foi o Singleton.
 *
 * @author João Guedes.
 */
public class SmallAcai extends Acai {

    private static SmallAcai smallAcai;

    private SmallAcai() {
        super();
        this.setPrice(6.5);
        this.setQuantity("250 ml");
    }

    public static SmallAcai getInstance() {
        if (smallAcai == null) {
            smallAcai = new SmallAcai();
        }
        return smallAcai;
    }

    @Override
    public void make() {
        System.out.println("✔ "+ this.getQuantity() + " de Açaí");
    }

}