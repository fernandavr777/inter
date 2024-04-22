package com.inter.definitions;

import com.inter.steps.MisPagosEnCasaEntregadosValidacionesSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MisPagosEnCasaEntregadosValidacionesDefinitions {

    MisPagosEnCasaEntregadosValidacionesSteps misPagosEnCasaEntregadosValidacionesSteps = new MisPagosEnCasaEntregadosValidacionesSteps();

    @When("Ingreso al modulo de pago en casa entregados")
    public void ingresoAlModuloDePagoEnCasaEntregados() {
        misPagosEnCasaEntregadosValidacionesSteps.ingresoAlModuloDePagoEnCasaEntregados();
    }

    @When("Filtro por rango de fecha y estado")
    public void filtroPorRangoDeFechaYEstado() {
        misPagosEnCasaEntregadosValidacionesSteps.filtroPorRangoDeFechaYEstado();
    }

    @And("Valido el filtro de fecha y estado")
    public void validoElFiltroDeFechaYEstado() {
        misPagosEnCasaEntregadosValidacionesSteps.validoElFiltroDeFechaYEstado();
    }

    @When("Filtro buscar por -numero -estado")
    public void filtroBuscarPorNumeroEstado() {
        misPagosEnCasaEntregadosValidacionesSteps.filtroBuscarPorNumeroEstado();
    }

    @Then("Valido el filtro buscar por -numero -estado")
    public void validoElFiltroBuscarPorNumeroEstado() {
        misPagosEnCasaEntregadosValidacionesSteps.validoElFiltroBuscarPorNumeroEstado();
    }

    @And("Filtro -buscar por -numero -fecha -estado")
    public void filtroBuscarPorNumeroFechaEstado() {
        misPagosEnCasaEntregadosValidacionesSteps.filtroBuscarPorNumeroFechaEstado();
    }

    @Then("valido el filtro -buscar por -numero -fecha -estado")
    public void validoElFiltroBuscarPorNumeroFechaEstado() {
        misPagosEnCasaEntregadosValidacionesSteps.validoElFiltroBuscarPorNumeroFechaEstado();
    }

}
