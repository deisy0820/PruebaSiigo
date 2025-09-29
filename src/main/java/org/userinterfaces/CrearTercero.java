package org.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;
import org.utils.ByShadows;


public class CrearTercero {



    public static final Target TIPO = Target.the("Campo tipo")
    .located(ByShadow.cssSelector("div[class='mdc-select__anchor mdc-ripple-upgraded']","div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > siigo-dropdownlist-web:nth-child(1)"));

    public static final Target TIPO_IDENTIFICACION = Target.the("Select type identification")
            .located(ByShadow.cssSelector("div[class='mdc-select__anchor mdc-ripple-upgraded']","div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > siigo-dropdownlist-web:nth-child(1)"));


    public static Target TIPO_DE_IDENTIFICACION(String label) {
        String dataValueContains = String.format("\"label\":\"%s\"", label);
        return Target.the("List item with label " + label)
                .located(ByShadow.cssSelector(
                        String.format("li.mdc-list-item[data-value*='%s']", dataValueContains),
                        "div:nth-child(1) > div:nth-child(2) > siigo-dropdownlist-web:nth-child(1)"
                ));
    }

    public static Target TIPO_DE_PERSONA(String label) {
        String dataValueContains = String.format("\"label\":\"%s\"", label);
        return Target.the("List item with label " + label)
                .located(ByShadow.cssSelector(
                        String.format("li.mdc-list-item[data-value*='%s']", dataValueContains),
                        "div:nth-child(1) > div:nth-child(1) > siigo-dropdownlist-web:nth-child(1)"
                ));
    }

    public static final Target IDENTIFICACION = Target.the("número de identificación")
            .located(ByShadow.cssSelector(".mdc-text-field__input.input-identification",
                    "siigo-identification-input-web[class='hydrated']"));


    public static final Target NOMBRES = Target.the("nombres")
            .located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(1) > siigo-textfield-web:nth-child(1)"));

    public static final Target APELLIDOS = Target.the("apellidos")
            .located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(2) > siigo-textfield-web:nth-child(1)"));

    public static final Target COMERCIAL = Target.the("campo comercial").located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(3) > div:nth-child(4) > siigo-textfield-web:nth-child(1)"));


    public static final Target DIRECCION = Target.the("dirección")
            .located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(3) > div:nth-child(6) > siigo-textfield-web:nth-child(1)"));

    public static final Target CIUDAD = Target.the("campo ciudad")
            .located(ByShadow.cssSelector(
                    "#divTDAutocompletecity1",
                    "div:nth-child(3) > div:nth-child(5) >  siigo-autocomplete-web:nth-child(1)"
            ));


    public static final Target CAMPO_CIUDAD= Target.the("City input in shadow")
            .located(ByShadow.cssSelector(
                    "#labelAutocompleteSelectItemcity",
                    "div:nth-child(3) > div:nth-child(5) >  siigo-autocomplete-web:nth-child(1)"
            ));



    public static final Target CIUDAD_= Target.the("City input in shadow")

            .located(ByShadow.cssSelector(
                    "input[class='mdc-text-field__input']",
                    "div:nth-child(3) > div:nth-child(5) >  siigo-autocomplete-web:nth-child(1)"
            ));

    public static final Target CONTACTO = Target.the("Icono contacto")
            .located(ByShadows.shadowCss(
                    "div.card.collapsible.closed",  // host que contiene el h3
                    "h3.clickable > i.clickable.arrow.down" // selector del ícono interno
            ));

    public static final Target NOMBRE_CONTACTO = Target.the("nombre contacto")
            .located(ByShadows.shadowCss(
                              "siigo-textfield-web[name='FirstName']", // host del shadow
                "input.mdc-text-field__input"           // input dentro del shadow
            ));


    public static final Target GUARDAR = Target.the("botón guardar")
            .located(By.xpath("//button[contains(text(),'Guardar')]"));

    public static final Target MENSAJE_EXITO = Target.the("mensaje de éxito")
            .located(By.cssSelector("div.toast-message"));
}
