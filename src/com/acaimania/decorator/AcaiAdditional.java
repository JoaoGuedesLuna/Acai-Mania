package com.acaimania.decorator;

import com.acaimania.model.Acai;

/**
 * Essa classe é um Decorator do modelo Acai.
 *
 * @author João Guedes.
 */
public abstract class AcaiAdditional extends Acai {

    private final Acai ACAI;

    public AcaiAdditional(Acai acai) {
        this.ACAI = acai;
    }

    public Acai getACAI() {
        return this.ACAI;
    }

}