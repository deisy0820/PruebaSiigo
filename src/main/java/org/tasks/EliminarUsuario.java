package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.utils.Endpoints;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarUsuario implements Task {


    private final int id;

    public EliminarUsuario(int id) { this.id = id; }

    public static EliminarUsuario conId(int id) {
        return instrumented(EliminarUsuario.class, id);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Delete.from(Endpoints.USERS + id));

    }
}
