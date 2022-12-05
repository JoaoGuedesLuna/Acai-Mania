package com.acaimania.model;

/**
 * Essa classe herda da classe Acai, e é uma abstração básica de uma porção pequena de Açaí. O padrão de projeto utilizado
 * para a criação de objetos dessa classe foi o Singleton.
 *
 * @author João Guedes.
 */
public class SmallAcai extends Acai {

    private static SmallAcai smallAcai;

    private SmallAcai() {
        super();
        super.setPrice(6.5);
        super.setQuantity("250 ml");
    }

    /**
     * Método que retorna uma mesma instância de um SmallAcai.
     *
     * @return Retorna uma mesma instância de um SmallAcai.
     */
    public static SmallAcai getInstance() {
        if ( SmallAcai.smallAcai == null) {
            SmallAcai.smallAcai = new SmallAcai();
        }
        return  SmallAcai.smallAcai;
    }

    @Override
    public void list() {
        System.out.println("✔ "+ super.getQuantity() + " de Açaí");
    }

}