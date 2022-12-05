package com.acaimania.model;

/**
 * Essa classe herda da classe Acai, e é uma abstração básica de uma porção grande de Açaí. O padrão de projeto utilizado
 * para a criação de objetos dessa classe foi o Singleton.
 *
 * @author João Guedes.
 */
public class BigAcai extends Acai {

    private static BigAcai bigAcai;

    private BigAcai() {
        super();
        super.setPrice(12.0);
        super.setQuantity("500 ml");
    }

    /**
     * Método retorna uma mesma instância de um SmallAcai.
     *
     * @return Retorna uma mesma instância de um SmallAcai.
     */
    public static BigAcai getInstance() {
        if (BigAcai.bigAcai == null) {
            BigAcai.bigAcai = new BigAcai();
        }
        return BigAcai.bigAcai;
    }

    @Override
    public void list() {
        System.out.println("✔ "+ super.getQuantity() + " de Açaí");
    }

}