package org.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.userinterfaces.AbrirPaginaWebPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPaginaWeb implements Task {
    private PageObject page;
    public AbrirPaginaWeb(PageObject page) {
        this.page = page;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(page));
    }
    public static AbrirPaginaWeb at(AbrirPaginaWebPage page)
    {
        return instrumented(AbrirPaginaWeb.class, page) ;
    }

}