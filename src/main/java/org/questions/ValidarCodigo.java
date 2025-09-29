package org.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ValidarCodigo implements Question<Integer> {

    public static ValidarCodigo fue() {
        return new ValidarCodigo();
    }
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }
}
