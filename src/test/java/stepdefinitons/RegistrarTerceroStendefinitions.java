package stepdefinitons;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.models.Tercero;
import org.openqa.selenium.WebDriver;
import org.questions.MensajeExito;
import org.tasks.AbrirPaginaWeb;
import org.tasks.CrearTercero;
import org.tasks.Login;
import org.userinterfaces.AbrirPaginaWebPage;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class RegistrarTerceroStendefinitions {
    Actor usuario = Actor.named("Deisy");

    @Managed(driver = "chrome")
    WebDriver suNavegador;

    private AbrirPaginaWebPage abrirPagina;

    @Before
    public void configurar() {
        usuario = Actor.named("usuario");
        usuario.can(BrowseTheWeb.with(suNavegador));
       // suNavegador.manage().window().maximize();
    }

    @Given("que el usuario inicia sesión en la aplicación")
    public void queElUsuarioIniciaSesionEnLaAplicacion() {
        usuario.attemptsTo(AbrirPaginaWeb.at(abrirPagina),
        Login.conCredenciales("retoautomationsiigo2@yopmail.com","J1h4{zMTV3"));

    }

    @When("crea un tercero con los siguientes datos")
    public void creaUnTerceroConLosSiguientesDatos(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        Tercero tercero = new Tercero(
                datos.get("Tipo"),
                datos.get("TipoIdentificación"),
                datos.get("Identificación"),
                datos.get("Nombres"),
                datos.get("Apellidos"),
                datos.get("Ciudad"),
                datos.get("Dirección")


        );



        usuario.attemptsTo(
                CrearTercero.conDatos(tercero)
        );
    }

    @Then("el tercero debería quedar registrado correctamente")
    public void elTerceroDeberíaQuedarRegistradoCorrectamente() {

        String mensaje = usuario.asksFor(MensajeExito.delToast("div.toast-message"));
        System.out.println("Mensaje capturado: " + mensaje);
        usuario.should(
                seeThat("El mensaje de éxito es correcto",
                        MensajeExito.delToast("div.toast-message"),
                        equalTo("Tercero guardado exitosamente"))
        );
    }
}
