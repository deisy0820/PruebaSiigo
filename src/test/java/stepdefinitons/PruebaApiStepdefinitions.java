package stepdefinitons;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.models.UsuarioModel;

import org.questions.ValidarCampo;
import org.questions.ValidarCodigo;
import org.tasks.ActualizarUsuario;
import org.tasks.ConsultarUsuario;
import org.tasks.EliminarUsuario;
import org.tasks.RegistrarUsuario;
import org.utils.Endpoints;


import io.restassured.response.Response;


import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class PruebaApiStepdefinitions {

    Actor usuario = Actor.named("Tester");
    private Response response;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        usuario = OnStage.theActorCalled("Tester");
    }
    @Given("que el usuario obtiene la url base de la api")
    public void queElUsuarioObtieneLaUrlBaseDeLaApi() {
        usuario.can(CallAnApi.at(Endpoints.BASE_URL));
    }

    @When("realiza un registro con email {string} y password {string}")
    public void realizaUnRegistroConEmailYPassword(String email, String password) {
        usuario.attemptsTo(
                RegistrarUsuario.con(new UsuarioModel(email, password, null, null))
        );
        response = lastResponse();
        System.out.println(response.getBody().asString());
    }

    @When("consulta el usuario por id {int}")
    public void consultaElUsuarioPorId(Integer id) {
        usuario.attemptsTo(
                ConsultarUsuario.conId(id)
        );
        response = lastResponse();
        System.out.println(response.getBody().asString());
    }

    @When("actualiza el usuario con nombre {string} y trabajo {string}")
    public void actualizaElUsuarioConNombreYTrabajo(String name, String job) {
        usuario.attemptsTo(
                ActualizarUsuario.conDatos(2, new UsuarioModel(null,null, name, job))
        );
        response = lastResponse();

        System.out.println(response.getBody().asString());
    }

    @When("elimina el usuario con id {int}")
    public void eliminaElUsuarioConId(Integer id) {
        usuario.attemptsTo(
                EliminarUsuario.conId(id)
        );
        response = lastResponse();
        System.out.println(response.getBody().asString());
    }

    @Then("debería recibir un código de respuesta {int}")
    public void deberíaRecibirUnCódigoDeRespuesta(Integer estadoCodigo) {
        usuario.should(
                seeThat("El código de respuesta", ValidarCodigo.fue(), equalTo(estadoCodigo))
        );


    }

    @Then("la respuesta debería contener los campos")
    public void laRespuestaDeberíaContenerLosCampos(io.cucumber.datatable.DataTable dataTable) {

        List<String> campos = dataTable.asList();
        for (String campo : campos) {
            usuario.should(
                    seeThat("El campo " + campo, ValidarCampo.value(campo), notNullValue()));
        }
    }


    @Then("debería recibir un código de respuesta para  la consulta {int}")
    public void deberíaRecibirUnCódigoDeRespuestaParaLaConsulta(Integer estadoCodigo) {
        usuario.should(
                seeThat("El código de respuesta", ValidarCodigo.fue(), equalTo(estadoCodigo))
        );

    }
    @Then("debería recibir un código de respuesta para la actualizacion {int}")
    public void deberíaRecibirUnCódigoDeRespuestaParaLaActualizacion(Integer estadoCodigo) {


        usuario.should(
                seeThat("El código de respuesta", ValidarCodigo.fue(), equalTo(estadoCodigo))
        );

    }
    @Then("debería recibir un código de respuesta para la eliminacion  {int}")
    public void deberíaRecibirUnCódigoDeRespuestaParaLaEliminacion(Integer estadoCodigo) {
        usuario.should(
                seeThat("El código de respuesta", ValidarCodigo.fue(), equalTo(estadoCodigo))
        );

    }
}
