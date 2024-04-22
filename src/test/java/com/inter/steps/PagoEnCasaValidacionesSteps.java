package com.inter.steps;

import com.inter.pageObjects.homePagePortal.HomePage;
import com.inter.pageObjects.pagoEnCasa.ConfirmarDatosPage;
import com.inter.pageObjects.pagoEnCasa.MisCuentasBancariasPage;

public class PagoEnCasaValidacionesSteps {

    HomePage homePage = new HomePage();
    MisCuentasBancariasPage misCuentasBancariasPage = new MisCuentasBancariasPage();
    ConfirmarDatosPage confirmarDatosPage = new ConfirmarDatosPage();
    String dataUsuarioSinCuentaBancaria = "data\\dataUsuarioSinCuentaBancaria.csv";
    String dataIniciarSesion = "data\\dataIniciarSesion.csv";
    String dataDefinirCuenta = "data\\dataDefinirCuentaBancaria.csv";
    String dataEdicionDeCuentaBancaria = "data\\dataEdicionDeCuentaBancaria.csv";
    String dataEliminarCuentaBancaria = "data\\dataEliminarCuentaBancaria.csv";

    //Pasos Inscribir y definir cuenta bancaria
    public void ingresoAlModuloDePagoEnCasa() {
        homePage.validarEnlacePagoEncasa();
    }
    public void inscriboUnaNuevaCuenta() {
        misCuentasBancariasPage.inscribirNuevaCuentaBancaria(dataUsuarioSinCuentaBancaria);
    }
    public void confirmoLosDatosYCreoLaCuentaBancaria() {
        confirmarDatosPage.validarDatosCuentaBancaria(dataUsuarioSinCuentaBancaria, dataIniciarSesion, "Inscribir cuenta");
    }
    public void buscoLaCuentaBancariaEnLaTabla() {
        misCuentasBancariasPage.buscarCuentaEnLaTabla();
    }
    public void definoLaCuentaBancaria() {
        misCuentasBancariasPage.definirCuentaBancaria();
    }
    public void veoLaInformacionDeLaCuentaYValidoLosDatos() {
        confirmarDatosPage.validarDatosCuentaBancaria(dataUsuarioSinCuentaBancaria, dataIniciarSesion, "Inscribir cuenta");
    }
    public void validoQueLaCuentaBancariaEsteDifinidaEnLaTabla() {
        misCuentasBancariasPage.validarCuentaBancariaDefinidaEnTabla();
    }

    //Pasos para definir cuenta bancaria
    public void buscoLaCuentBancariaParaDefinirlaEnLaTabla() {
        misCuentasBancariasPage.buscarCuentaEnLaTablaCuentaYaInscrita(dataDefinirCuenta, "Buscar cuenta");
    }
    public void definoLaCuentaBancariaYaInscrita() {
        misCuentasBancariasPage.definirCuentaBancariaSinIncripcion(dataDefinirCuenta);
    }
    //------ajustar por valido los datos del titular de la cuenta bancaria
    public void veoLaInformacionDeLaCuentaYValidoAlgunosDatos() {
        confirmarDatosPage.validarDatosCuentaBancaria(dataDefinirCuenta, dataIniciarSesion, "Definir cuenta");
    }
    public void validoQueLaCuentaBancariaInscritaEsteDefinidaEnLaTabla() {
        misCuentasBancariasPage.validarCuentaBancariaDefinidaEnTablaSinIncrispcion(dataDefinirCuenta);
    }

    //Pasos para editar cuenta bancaria
    //-------Depurar codigo para buscar y definir cuenta
    public void buscoLaCuentaBancaria() {
        misCuentasBancariasPage.buscarCuentaEnLaTablaCuentaYaInscrita(dataEdicionDeCuentaBancaria, "Buscar cuenta");
    }
    public void editoLaCuentaBancariaYValidoLosDatosActualizadosEnLaPaginaDeConfirmacion() {
        misCuentasBancariasPage.editarCuentaBancariaYConfirmarDatos(dataEdicionDeCuentaBancaria, dataIniciarSesion);
    }
    public void validoQueLacuentaBancariaEditadaSeEncuentraEnLaTabla() {
        misCuentasBancariasPage.buscarCuentaEnLaTablaCuentaYaInscrita(dataEdicionDeCuentaBancaria, "Buscar cuenta editada");
    }

    //Pasos para eliminar cuenta bancaria
    public void buscoLaCuentaBancariaParaEliminar() {
        misCuentasBancariasPage.buscarCuentaEnLaTablaCuentaYaInscrita(dataEliminarCuentaBancaria, "Buscar cuenta");
    }
    public void eliminoLaCuentaBancaria() {
        misCuentasBancariasPage.eliminarCuentaBancaria(dataEliminarCuentaBancaria);
    }
    public void validoQueLaCuentaBancariaNoSeEncuentraEnLaTabla() {
        misCuentasBancariasPage.buscarCuentaEnLaTablaCuentaYaInscrita(dataEliminarCuentaBancaria, "Buscar cuenta eliminada");
    }

}
