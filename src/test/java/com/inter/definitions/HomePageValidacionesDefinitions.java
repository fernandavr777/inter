package com.inter.definitions;

import com.inter.steps.HomePageValidacionesSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class HomePageValidacionesDefinitions {

    HomePageValidacionesSteps homePageValidacionesSteps = new HomePageValidacionesSteps();

    @And("Me Encuentro en el homepage")
    public void meEncuentroEnElHomepage() {
       homePageValidacionesSteps.meEncuentroEnElHomepage();
    }

    @Then("Valido el enlace de la tarjeta -pago en casa-")
    public void validoElEnlaceDeLaTarjetaPagoEnCasa() {
        homePageValidacionesSteps.validoElEnlaceDeLaTarjetaPagoEnCasa();
    }

    @Then("Valido el enlace de la tarjeta -sigue tus envios-")
    public void validoElEnlaceDeLaTarjetaSigueTusEnvios() {
       homePageValidacionesSteps.validoElEnlaceDeLaTarjetaSigueTusEnvios();
    }

    @Then("Valido el enlace de la tarjeta -mis pagos en casa entregados-")
    public void validoElEnlaceDeLaTarjetaMisPagosEnCasaEntregados() {
        homePageValidacionesSteps.validoElEnlaceDeLaTarjetaMisPagosEnCasaEntregados();
    }

    @Then("Valido el enlace de la tarjeta -cotiza tu envio-")
    public void validoElEnlaceDeLaTarjetaCotizaTuEnvio() {
        homePageValidacionesSteps.validoElEnlaceDeLaTarjetaCotizaTuEnvio();
    }

    @Then("Valida el enlace de la tarjeta -estamos muy cerca de ti-")
    public void validaElEnlaceDeLaTarjetaEstamosMuyCercaDeTi() {
        homePageValidacionesSteps.validaElEnlaceDeLaTarjetaEstamosMuyCercaDeTi();
    }

    @Then("Valida el enlace de la tarjeta -solicita tu recogida-")
    public void validaElEnlaceDeLaTarjetaSolicitaTuRecogida() {
       homePageValidacionesSteps.validaElEnlaceDeLaTarjetaSolicitaTuRecogida();
    }

}
