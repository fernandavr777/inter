package com.inter.pageObjects.loginUsuario.inicioSesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import com.inter.pageObjects.homePagePortal.HomePage;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class IniciarSesionPage extends PageObject {

    // Validacion header
    public By headerBienvenido = By.xpath("//div[2]/app-iniciar-sesion/app-login/div/div[1]/h1");
    // Enlace a registro usuario
    public By hrefRegistrate = By.xpath("//app-iniciar-sesion/app-login/div/div[1]/a");
    // Formulario Inicio de sesion
    public By formInicioSesion = By.xpath("//app-iniciar-sesion/app-login/div/form");
    public By inputNumCelCorreo = By.xpath("//app-iniciar-sesion/app-login/div/form/div[1]/div/input");
    public By inputContrasena = By.xpath("//app-iniciar-sesion/app-login/div/form/div[2]/div/input");
    public By btnIngresar = By.xpath("//app-iniciar-sesion/app-login/div/form/div[3]/button");
    // Iniciar sesion con redes sociales
    public By btnLoginFacebook = By
            .xpath("//app-iniciar-sesion/app-login/div/div[2]/div[1]/app-redes-sociales/button[1]");
    public By btnLoginGoogle = By
            .xpath("//app-iniciar-sesion/app-login/div/div[2]/div[1]/app-redes-sociales/button[2]");
    // Opciones login usuario
    public By hrefNoRecuerdoRegistro = By.xpath("//app-iniciar-sesion/app-login/div/div[2]/div[2]/div[1]/a");
    public By hrefOlvidoContrasena = By.xpath("//app-iniciar-sesion/app-login/div/div[2]/div[2]/div[2]/a");
    public By hrefRegistrarPQR = By.xpath("//app-iniciar-sesion/app-login/div/div[2]/div[2]/div[3]/a");
    public By hrefPreguntasFrecuentes = By.xpath("//app-iniciar-sesion/app-login/div/div[2]/div[2]/div[4]/a");
    public By herefTyC = By.xpath("//app-iniciar-sesion/app-login/div/div[2]/div[2]/div[5]/a");
    // Validacion campos Obligatorios
    public By inputCelularoCorreoVacio = By.xpath("//app-iniciar-sesion/app-login/div/form/div[1]/small");
    // Por favor ingrese un usuario.
    public By inputCelularoCorreoInvalido = By.xpath("//app-iniciar-sesion/app-login/div/form/div[1]/small");
    // El correo electronico ingresado es inválido.
    public By inputContrasenaVacio = By.xpath("//app-iniciar-sesion/app-login/div/form/div[2]/small");
    // Por favor ingrese una contraseña.
    // Modal Activacion de Cuenta
    public By formModalActivarCuenta = By.xpath("//*[@id='MensajeCuentaNoActivada']/div/div/div/form");
    public By inputCodigoVerificacion = By
            .xpath("//*[@id='MensajeCuentaNoActivada']/div/div/div/form/div[1]/div/input");
    public By btnCancelar = By.xpath("//*[@id='MensajeCuentaNoActivada']/div/div/div/form/div[2]/button[1]");
    public By btnConfirmar = By.xpath("//*[@id='MensajeCuentaNoActivada']/div/div/div/form/div[2]/button[2]");
    public By btnReenviarCod = By.xpath("");

    Utils utils = new Utils();
    HomePage homePage = new HomePage();

    public void ingresarAlPortalClientes() {
        String urlPortalAutogestionQA = "https://portalautogestionqa.interrapidisimo.com/";
        getDriver().get(urlPortalAutogestionQA);
        Serenity.takeScreenshot();
    }

    public void enlaceRegistrate() {
        getDriver().findElement(hrefRegistrate).click();
    }

    public void validarHeaderBienvenido() {
        utils.esperarElementoVisible(headerBienvenido);
        utils.getAssertLocalizadorContiene(headerBienvenido, "Bienvenido a Portal Clientes");
    }

    public void formaularioInicioDeSesion(String NumCelCorreo, String Contrasena) {
        validarHeaderBienvenido();
        getDriver().findElement(inputNumCelCorreo).click();
        getDriver().findElement(inputNumCelCorreo).sendKeys(NumCelCorreo);
        getDriver().findElement(inputContrasena).sendKeys(Contrasena);
        Serenity.takeScreenshot();
        getDriver().findElement(btnIngresar).click();
    }

    public void iniciarSesion(String dataIniciarSesion) throws IOException {
        CSVReader csvReader = utils.dataCsv(dataIniciarSesion);
        String[] list = null;
        Integer contador = 0;
        String csvFile = dataIniciarSesion;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        int totalFilas = 0;
        int fila = 0;
        while ((bufferedReader.readLine()) != null) {
            totalFilas++;
        }
        bufferedReader.close();
        totalFilas = totalFilas - 1;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        fila++;
                        if (fila == totalFilas) {
                            formaularioInicioDeSesion(list[0], list[1]);
                            break;
                        } else {
                            formaularioInicioDeSesion(list[0], list[1]);
                            homePage.validarHeaderHomePage();
                            homePage.cerrarSesion();
                            Serenity.takeScreenshot();
                        }
                    } catch (Exception e) {
                        System.out.println(
                                "Error al iniciar sesion con el usuario ***\n" + e);
                        contador++;
                    }
                } else {
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo CSV ***\n" + e);
        }
    }

}
