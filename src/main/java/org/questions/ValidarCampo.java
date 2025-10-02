package org.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ValidarCampo implements Question<String> {
    private final String campo;


    public ValidarCampo(String campo) {
        this.campo = campo;
    }

    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().jsonPath().getString(campo);
    }

    public static ValidarCampo value(String field) {
        return new ValidarCampo(field);
    }

}
