package org.tasks;

import com.google.gson.Gson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.models.UsuarioModel;
import org.utils.Endpoints;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActualizarUsuario implements Task {

    private final int id;
    private final UsuarioModel user;

    public ActualizarUsuario(int id, UsuarioModel user) {
        this.id = id;
        this.user = user;
    }

    public static ActualizarUsuario conDatos(int id, UsuarioModel user) {
        return instrumented(ActualizarUsuario.class, id, user);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(Endpoints.USERS + id)
                        .with(req -> req
                                .contentType("application/json")
                                .body(new Gson().toJson(user))));// ⚡ Serializa a JSON
    }


}
