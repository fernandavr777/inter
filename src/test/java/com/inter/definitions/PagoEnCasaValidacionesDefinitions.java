package com.inter.definitions;

import com.inter.steps.PagoEnCasaValidacionesSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PagoEnCasaValidacionesDefinitions {

    PagoEnCasaValidacionesSteps pagoEnCasaValidacionesSteps = new PagoEnCasaValidacionesSteps();


    //Pasos para inscribir y definir cuenta bancaria
    @And("Ingreso al modulo de pago en casa")
    public void ingresoAlModuloDePagoEnCasa() {
        pagoEnCasaValidacionesSteps.ingresoAlModuloDePagoEnCasa();
    }
    @And("Inscribo una nueva cuenta")
    public void inscriboUnaNuevaCuenta() {
        pagoEnCasaValidacionesSteps.inscriboUnaNuevaCuenta();
    }
    @And("Confirmo los datos y creo la cuenta bancaria")
    public void confirmoLosDatosYCreoLaCuentaBancaria() {
        pagoEnCasaValidacionesSteps.confirmoLosDatosYCreoLaCuentaBancaria();
    }
    @And("Busco la cuenta bancaria en la tabla")
    public void buscoLaCuentaBancariaEnLaTabla() {
        pagoEnCasaValidacionesSteps.buscoLaCuentaBancariaEnLaTabla();
    }
    @And("Defino la cuenta bancaria")
    public void definoLaCuentaBancaria() {
        pagoEnCasaValidacionesSteps.definoLaCuentaBancaria();
    }
    @And("Veo la informacion de la cuenta y valido los datos")
    public void veoLaInformacionDeLaCuentaYValidoLosDatos() {
        pagoEnCasaValidacionesSteps.veoLaInformacionDeLaCuentaYValidoLosDatos();
    }
    @Then("Valido que la cuenta bancaria este difinida en la tabla")
    public void validoQueLaCuentaBancariaEsteDifinidaEnLaTabla() {
        pagoEnCasaValidacionesSteps.validoQueLaCuentaBancariaEsteDifinidaEnLaTabla();
    }

    //Pasos para definir cuenta bancaria
    @And("Busco la cuenta bancaria para definirla en la tabla")
    public void buscoLaCuentBancariaParaDefinirlaEnLaTabla() {
        pagoEnCasaValidacionesSteps.buscoLaCuentBancariaParaDefinirlaEnLaTabla();
    }
    @And("Defino la cuenta bancaria ya inscrita")
    public void definoLaCuentaBancariaYaInscrita() {
        pagoEnCasaValidacionesSteps.definoLaCuentaBancariaYaInscrita();
    }
    @And("Veo la informacion de la cuenta y valido algunos datos")
    public void veoLaInformacionDeLaCuentaYValidoAlgunosDatos() {
        pagoEnCasaValidacionesSteps.veoLaInformacionDeLaCuentaYValidoAlgunosDatos();
    }
    @Then("Valido que la cuenta bancaria inscrita este definida en la tabla")
    public void validoQueLaCuentaBancariaInscritaEsteDefinidaEnLaTabla() {
        pagoEnCasaValidacionesSteps.validoQueLaCuentaBancariaInscritaEsteDefinidaEnLaTabla();
    }

    //Pasos para editar cuenta bancaria
    @And("Busco la cuenta bancaria")
    public void buscoLaCuentaBancaria() {
        pagoEnCasaValidacionesSteps.buscoLaCuentaBancaria();
    }
    @And("Edito la cuenta bancaria y valido los datos actualizados en la pagina de confirmacion")
    public void editoLaCuentaBancariaYValidoLosDatosActualizadosEnLaPaginaDeConfirmacion() {
        pagoEnCasaValidacionesSteps.editoLaCuentaBancariaYValidoLosDatosActualizadosEnLaPaginaDeConfirmacion();
    }
    @Then("Valido que la cuenta bancaria editada se encuentra en la tabla")
    public void validoQueLacuentaBancariaEditadaSeEncuentraEnLaTabla() {
       pagoEnCasaValidacionesSteps.validoQueLacuentaBancariaEditadaSeEncuentraEnLaTabla();
    }

    //Pasos para eliminar cuenta bancaria
    @Then("Busco la cuenta bancaria para eliminar")
    public void buscoLaCuentaBancariaParaEliminar() {
       pagoEnCasaValidacionesSteps.buscoLaCuentaBancariaParaEliminar();
    }
    @Then("Elimino la cuenta bancaria")
    public void eliminoLaCuentaBancaria() {
       pagoEnCasaValidacionesSteps.eliminoLaCuentaBancaria();
    }
    @Then("Valido que la cuenta bancaria no se encuentra en la tabla")
    public void validoQueLaCuentaBancariaNoSeEncuentraEnLaTabla(){
       pagoEnCasaValidacionesSteps.validoQueLaCuentaBancariaNoSeEncuentraEnLaTabla();
    }







}
