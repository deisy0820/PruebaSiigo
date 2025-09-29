package org.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class MensajeExito implements Question<String> {

    private final String selector;

    // Constructor: le pasamos el selector del toast
    public MensajeExito(String selector) {
        this.selector = selector;
    }

    public static MensajeExito delToast(String selector) {
        return new MensajeExito(selector);
    }

    @Override
    public String answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // Capturamos el texto usando JS
        String mensaje = (String) ((JavascriptExecutor) driver).executeScript(
                "let el = document.querySelector(arguments[0]); " +
                        "return el ? el.innerText : '';",
                selector
        );

        return mensaje;
    }
    }