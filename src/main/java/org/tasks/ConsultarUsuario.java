package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.utils.Endpoints;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarUsuario implements Task {

    private final int id;

    public ConsultarUsuario(int id)
    {
        this.id = id;
    }

    public static ConsultarUsuario conId(int id) {
        return instrumented(ConsultarUsuario.class, id);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Endpoints.USERS + id));


    }
}
