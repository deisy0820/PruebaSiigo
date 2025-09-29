package org.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.models.Tercero;
import org.models.UsuarioModel;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.userinterfaces.CrearTercero.*;
import static org.userinterfaces.CrearTercero.CIUDAD;


public class CrearTercero implements Task {


    private final Tercero tercero;

    public CrearTercero(Tercero tercero) {
        this.tercero = tercero;
    }


    public static CrearTercero conDatos(Tercero tercero) {
        return Tasks.instrumented(CrearTercero.class, tercero);
    }

        @Override
        public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(

                    WaitUntil.the(TIPO, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(60).seconds(),
                    Click.on(TIPO),
                    Click.on(TIPO_DE_PERSONA(tercero.gettipo())),
                    Click.on(TIPO_IDENTIFICACION),
                    Click.on(TIPO_DE_IDENTIFICACION(tercero.getTipoIdentificacion())),
                    Enter.theValue(tercero.getIdentificacion()).into(IDENTIFICACION),
                    Enter.theValue(tercero.getNombres()).into(NOMBRES),
                    Enter.theValue(tercero.getApellidos()).into(APELLIDOS),
                    Enter.theValue("jose").into(COMERCIAL),
                    Enter.theValue(tercero.getDireccion()).into(DIRECCION),
                    Click.on(CAMPO_CIUDAD),
                    Enter.theValue(tercero.getCiudad()).into(CIUDAD),
                    Click.on(CIUDAD_),
                    Click.on(CONTACTO),
                    Enter.keyValues("juan").into(NOMBRE_CONTACTO),
                    Click.on(GUARDAR)
            );
        }
    }