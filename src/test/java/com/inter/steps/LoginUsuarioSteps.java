package com.inter.steps;

import java.io.IOException;

import com.inter.pageObjects.homePagePortal.HomePage;
import com.inter.pageObjects.loginUsuario.inicioSesion.IniciarSesionPage;
import com.inter.pageObjects.loginUsuario.registroUsuario.RegistroUsuarioPage;

import net.thucydides.core.annotations.Step;

public class LoginUsuarioSteps {
    
    IniciarSesionPage iniciarSesionPage = new IniciarSesionPage();
    RegistroUsuarioPage registroUsuarioPage = new RegistroUsuarioPage();
    HomePage homePage = new HomePage();
    String dataRegistroUsuario = "data\\dataRegistroUsuario.csv";
    String dataIniciarSesion = "data\\dataIniciarSesion.csv";

    @Step
    public void ingresoAlPortalClientes() {
        iniciarSesionPage.ingresarAlPortalClientes();
    }

    @Step
    public void realizoElProcesoDeRegistroDeUsuario() {
        registroUsuarioPage.registroDeUsuario(dataRegistroUsuario);
    }

    @Step
    public void validoElRegistroExitosoDelUsuario() {

    }
    
    public void inicioSesionEnElPortalClientes() throws IOException {
        iniciarSesionPage.iniciarSesion(dataIniciarSesion);
    }

    @Step
    public void validoInicioDeSesionEnElPortal() {
        homePage.validarHeaderHomePage();
    } 

}
