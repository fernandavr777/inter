package com.inter.definitions;

import java.io.IOException;

import com.inter.steps.LoginUsuarioSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUsuarioDefinitions {


    LoginUsuarioSteps loginUsuarioSteps = new LoginUsuarioSteps();

    @Given("Ingreso al portal clientes")
    public void ingresoAlPortalClientes() {
        loginUsuarioSteps.ingresoAlPortalClientes();
    }

    @When("Realizo el proceso de registro de usuario")
    public void realizoElProcesoDeRegistroDeUsuario() {
        loginUsuarioSteps.realizoElProcesoDeRegistroDeUsuario();
    }

    @Then("Valido el registro exitoso del usuario")
    public void validoElRegistroExitosoDelUsuario() {
        loginUsuarioSteps.validoElRegistroExitosoDelUsuario();
    }

    @When("Inicio sesion en el portal clientes")
    public void inicioSesionEnElPortalClientes() throws IOException {
        loginUsuarioSteps.inicioSesionEnElPortalClientes();
    }

    @Then("valido inicio de sesion en el portal")
    public void validoInicioDeSesionEnElPortal() {
        loginUsuarioSteps.validoInicioDeSesionEnElPortal();
    }

}
