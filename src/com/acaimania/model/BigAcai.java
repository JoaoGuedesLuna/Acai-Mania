package com.acaimania.model;

/**
 * Essa classe herda da classe Acai, e é uma abstração básica de porção grande de Açaí. O padrão de projeto utilizado
 * para a criação de objetos dessa classe foi o Singleton.
 *
 * @author João Guedes.
 */
public class BigAcai extends Acai {

    private static BigAcai bigAcai;

    private BigAcai() {
        super();
        this.setPrice(12.0);
        this.setQuantity("500 ml");
    }

    public static BigAcai getInstance() {
        if (bigAcai == null) {
            bigAcai = new BigAcai();
        }
        return bigAcai;
    }

    @Override
    public void make() {
        System.out.println("✔ "+ this.getQuantity() + " de Açaí");
    }

}