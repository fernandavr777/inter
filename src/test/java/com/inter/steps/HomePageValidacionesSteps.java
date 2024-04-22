package com.inter.steps;

import com.inter.pageObjects.homePagePortal.HomePage;
import com.inter.pageObjects.misPagosEnCasaEntregados.MisPagosEnCasaEntregadosPage;
import com.inter.pageObjects.pagoEnCasa.MisCuentasBancariasPage;

public class HomePageValidacionesSteps {
    
    HomePage homePage = new HomePage();
    MisCuentasBancariasPage misCuentasBancariasPage = new MisCuentasBancariasPage();
    MisPagosEnCasaEntregadosPage misPagosEnCasaEntregadosPage = new MisPagosEnCasaEntregadosPage();

    public void meEncuentroEnElHomepage() {
       homePage.validarHeaderHomePageDisplayed();
    }

    public void validoElEnlaceDeLaTarjetaPagoEnCasa() {
        homePage.validarEnlacePagoEncasa();
        misCuentasBancariasPage.irAtrasAlHomePage();
    }

    public void validoElEnlaceDeLaTarjetaSigueTusEnvios() {
       homePage.validarEnlaceSigueTUsEnvios();
    }

    public void validoElEnlaceDeLaTarjetaMisPagosEnCasaEntregados() {
        homePage.validarEnlaceMisPagosEnCasaEntregados();
        misPagosEnCasaEntregadosPage.irAtrasAlHomePage();
    }

    public void validoElEnlaceDeLaTarjetaCotizaTuEnvio() {
        homePage.validarEnlaceCotizaTuEnvio();
    }

    public void validaElEnlaceDeLaTarjetaEstamosMuyCercaDeTi() {
        homePage.validarEnlaceEstamosMuyCercaDeTi();
    }

    public void validaElEnlaceDeLaTarjetaSolicitaTuRecogida() {
       homePage.validarEnlaceSolicitaTuRecogida();
    }

}
