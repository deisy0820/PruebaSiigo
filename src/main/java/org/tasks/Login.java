package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.userinterfaces.LoginPage.*;

public class Login implements Task {
    private final String usuario;
    private final String clave;

    public Login(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static Login conCredenciales(String usuario, String clave) {
        return instrumented(Login.class, usuario, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USUARIO, WebElementStateMatchers.isPresent())
                        .forNoMoreThan(60).seconds(),
                Enter.theValue(usuario).into(USUARIO),
                Enter.theValue(clave).into(CLAVE),
                Click.on(CONTINUAR),
                WaitUntil.the(CREAR, WebElementStateMatchers.isPresent())
                        .forNoMoreThan(60).seconds(),
                Click.on(CREAR),
                Click.on(CLIENTES)
        );

    }


}
