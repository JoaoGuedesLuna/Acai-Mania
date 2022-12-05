package com.acaimania.model;

/**
 * Essa classe é uma abastração básica de uma porção de Açaí.
 *
 * @author João Guedes.
 */
public abstract class Acai {

    private Double price;
    private String quantity;

    public Double getPrice() {
        return this.price;
    }

    protected void setPrice(Double price) {
        this.price = price;
    }

    public String getQuantity() {
        return this.quantity;
    }

    protected void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Método que lista todos os ingredientes do açaí
     */
    public abstract void list();

}