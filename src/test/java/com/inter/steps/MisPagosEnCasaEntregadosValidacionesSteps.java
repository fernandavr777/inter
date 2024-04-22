package com.inter.steps;

import com.inter.pageObjects.homePagePortal.HomePage;
import com.inter.pageObjects.misPagosEnCasaEntregados.MisPagosEnCasaEntregadosPage;

public class MisPagosEnCasaEntregadosValidacionesSteps {

    HomePage homePage = new HomePage();
    MisPagosEnCasaEntregadosPage misPagosEnCasaEntregadosPage = new MisPagosEnCasaEntregadosPage();

    String dataFiltrosMisPagosEnCasaEntregados = "data\\dataFiltrosMisPagosEnCasaEntregados.csv";

    public void ingresoAlModuloDePagoEnCasaEntregados() {
        homePage.validarEnlaceMisPagosEnCasaEntregados();
    }

    public void filtroPorRangoDeFechaYEstado() {
        misPagosEnCasaEntregadosPage.filtrarPorFechayEstado(dataFiltrosMisPagosEnCasaEntregados);
    }

    public void validoElFiltroDeFechaYEstado() {
        misPagosEnCasaEntregadosPage.validarFiltroFechayEstado(dataFiltrosMisPagosEnCasaEntregados);
    }

    public void filtroBuscarPorNumeroEstado() {
        misPagosEnCasaEntregadosPage.filtroBuscarPorNumeroEstado(dataFiltrosMisPagosEnCasaEntregados);
    }

    public void validoElFiltroBuscarPorNumeroEstado() {
        misPagosEnCasaEntregadosPage.validarFiltroBuscarPorNumeroEstado(dataFiltrosMisPagosEnCasaEntregados);
    }

    public void filtroBuscarPorNumeroFechaEstado() {
        misPagosEnCasaEntregadosPage.filtroBuscarPorNumeroFechaEstado(dataFiltrosMisPagosEnCasaEntregados);
    }

    public void validoElFiltroBuscarPorNumeroFechaEstado() {
        misPagosEnCasaEntregadosPage.validarFiltroBuscarPorNumeroFechaEstado(dataFiltrosMisPagosEnCasaEntregados);
    }

}
