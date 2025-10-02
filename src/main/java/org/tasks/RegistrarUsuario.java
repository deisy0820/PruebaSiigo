package org.tasks;



import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.models.UsuarioModel;
import org.utils.Endpoints;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarUsuario implements Task {
    private final UsuarioModel user;

    public RegistrarUsuario(UsuarioModel user) {
        this.user = user;
    }

    public static RegistrarUsuario con(UsuarioModel user) {
        return instrumented(RegistrarUsuario.class, user);
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(Endpoints.LOGIN)
                        .with(req -> req
                                .contentType(ContentType.JSON)
                                .body(user)
                                .log().all()));
    }
}
