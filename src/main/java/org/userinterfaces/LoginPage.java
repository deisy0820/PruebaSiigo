package org.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USUARIO = Target.the("campo usuario")
            .located(By.id("siigoSignInName")); // cambia el locator según el HTML real

    public static final Target CLAVE = Target.the("campo clave")
            .located(By.id("siigoPassword"));

    public static final Target CONTINUAR = Target.the("boton continuar")
            .located(By.id("siigoNext"));

    public static final Target CREAR = Target.the("buton  Crear").
            located(ByShadow.cssSelector("div[class='wc--siigo dsm-siigo']",
                    "siigo-header-molecule[class='data-siigo-five9 hydrated']",
                    "siigo-button-atom[text='Crear']"));

    public static final Target CLIENTES = Target.the ("opciòn clientes")
            .located (ByShadow.cssSelector("a[data-value='Clientes']",
                    "siigo-header-molecule[class='data-siigo-five9 hydrated']"));

//    public static final Target CLIENTES = Target.the ("opciòn clientes")
//         .located (ByShadow.cssSelector("siigo-button-atom[data-id='header-create-button']",
//                 "siigo-header-create-button-dropdown",
//                 "div.content-create-items div.titles-create[data-value='Clientes']"));
//

    public static final Target CIUDAD= Target.the("City input in shadow")
            .located (ByShadow.cssSelector(
                     "#divTDAutocompletecity1", "div:nth-child (3) > div:nth-child (5) > siigo-autocomplete-web:nth-child (1)"));
}

