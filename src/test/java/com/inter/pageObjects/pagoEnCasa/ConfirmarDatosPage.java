package com.inter.pageObjects.pagoEnCasa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.inter.pageObjects.yopMail.HomeYopMailPage;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class ConfirmarDatosPage extends PageObject {

    // Campos confirmacion de datos
    public By txtValidarNumDocumento = By
            .xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[1]/div/p[1]");
    public By txtValidarNombreCompleto = By
            .xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[1]/div/p[2]");
    public By txtValidarCiudad = By.xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[1]/div/p[3]");
    public By txtValidarDireccion = By
            .xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[1]/div/p[4]");
    public By txtValidarCorreo = By.xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[1]/div/p[5]");
    public By txtValidarEntidad = By.xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[2]/div/p[1]");
    public By txtValidarTipoDeCuenta = By
            .xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[2]/div/p[2]");
    public By txtValidarNumCuenta = By
            .xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[2]/div/p[3]");
    public By txtValidarConfirmNumCuenta = By
            .xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[2]/div/p[4]");
    public By txtValidarNumTelefono = By
            .xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[2]/div[2]/div/p[5]");
    public By btnConfirmar = By.xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[3]/div/div/button");
    public By btnCancelar = By.xpath("//app-formulario-confirmacion-cuenta-bancaria/div/div[3]/div/div/a");
    // Modal codigo verificacion
    public By spanTituloModal = By.xpath("//*[@id='MensajeVerificacionUsuario']/div/div/div/form/span");
    public By inputCodigoDeVerificacion = By
            .xpath("//*[@id='MensajeVerificacionUsuario']/div/div/div/form/div[1]/div/input");
    public By btnCancelarModal = By.xpath("//*[@id='MensajeVerificacionUsuario']/div/div/div/form/div[2]/button[1]");
    public By btnConfirmarModal = By.xpath("//*[@id='MensajeVerificacionUsuario']/div/div/div/form/div[2]/button[2]");

    Utils utils = new Utils();
    HomeYopMailPage homeYopMailPage = new HomeYopMailPage();

    /* 
    public void validarDatosCuentaBancaria(String dataUsuarioSinCuentaBancaria, String dataIniciarSesion) {
        CSVReader csvReader = utils.dataCsv(dataUsuarioSinCuentaBancaria);
        String[] list = null;
        Integer contador = 0;
        String tipoCuenta = "";
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {

                        utils.esperaMilis(3000);
                        utils.getAssertLocalizadorContiene(txtValidarNumDocumento, list[1]);
                        utils.getAssertLocalizadorContiene(txtValidarNombreCompleto,
                                list[2] + " " + list[3] + " " + list[4] + " " + list[5]);
                        utils.getAssertLocalizadorContiene(txtValidarCiudad, list[6]);
                        utils.getAssertLocalizadorContiene(txtValidarDireccion, list[7]);
                        utils.getAssertLocalizadorContiene(txtValidarCorreo, list[8]);
                        utils.getAssertLocalizadorContiene(txtValidarEntidad, list[9]);
                        if (list[10].equals("cta ahorros")) {
                            tipoCuenta = "ahorros";
                        }
                        if (list[10].equals("cta corriente")) {
                            tipoCuenta = "corriente";
                        }
                        utils.getAssertLocalizadorContiene(txtValidarTipoDeCuenta, tipoCuenta);
                        utils.getAssertLocalizadorContiene(txtValidarNumCuenta, list[11]);
                        utils.getAssertLocalizadorContiene(txtValidarConfirmNumCuenta, list[11]);
                        utils.getAssertLocalizadorContiene(txtValidarNumTelefono, list[12]);
                        Serenity.takeScreenshot();
                        getDriver().findElement(btnConfirmar).click();
                        utils.esperaMilis(5000);
                        getDriver().switchTo().activeElement();
                        getDriver().findElement(spanTituloModal).isDisplayed();
                        homeYopMailPage.ingresarAlCorreoYCopiarCodigoDeVerficacion(dataIniciarSesion);
                        getDriver().findElement(inputCodigoDeVerificacion).sendKeys(HomeYopMailPage.sSubCadena);
                        Serenity.takeScreenshot();
                        getDriver().findElement(btnConfirmarModal).click();
                        utils.esperaMilis(5000);

                    } catch (Exception e) {
                        System.out.println(
                                "Los datos de la cuenta bancaria inscrita no coinciden con los datos de la confirmacion ***\n"
                                        + e);
                        contador++;
                    }
                } else {
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo CSV ***\n" + e);
        }
    }*/

    public void modalCodigoDeVerificacion(String correoDelUsuario) {
                        Serenity.takeScreenshot();
                        getDriver().findElement(btnConfirmar).click();
                        utils.esperaMilis(8000);
                        getDriver().switchTo().activeElement();
                        getDriver().findElement(spanTituloModal).isDisplayed();
                        homeYopMailPage.ingresarAlCorreoYCopiarCodigoDeVerficacion(correoDelUsuario);
                        getDriver().findElement(inputCodigoDeVerificacion).sendKeys(HomeYopMailPage.sSubCadena);
                        Serenity.takeScreenshot();
                        getDriver().findElement(btnConfirmarModal).click();
                        utils.esperaMilis(5000);
    }

    public void validarDatosBancariosDelTitularDeLaCuenta(String entidad, String tipoDeCuenta, String numeroDeCuenta) {
        String tipoCuenta = "";
        utils.getAssertLocalizadorContiene(txtValidarEntidad, entidad);
        if (tipoDeCuenta.equals("cta ahorros")) {
            tipoCuenta = "ahorros";
        }
        if (tipoDeCuenta.equals("cta corriente")) {
            tipoCuenta = "corriente";
        }
        utils.getAssertLocalizadorContiene(txtValidarTipoDeCuenta, tipoCuenta);
        utils.getAssertLocalizadorContiene(txtValidarNumCuenta, numeroDeCuenta);
        utils.getAssertLocalizadorContiene(txtValidarConfirmNumCuenta, numeroDeCuenta);
    }

    public void validarDatosCuentaBancaria(String dataConfirmacionDeDatosCuentaBancaria, String dataIniciarSesion,
            String flujo) {
        CSVReader csvReader = utils.dataCsv(dataConfirmacionDeDatosCuentaBancaria);
        String[] list = null;
        Integer contador = 0;
        // String tipoCuenta = "";
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        switch (flujo) {
                            case "Inscribir cuenta":
                                utils.esperaMilis(3000);
                                utils.getAssertLocalizadorContiene(txtValidarNumDocumento, list[1]);
                                utils.getAssertLocalizadorContiene(txtValidarNombreCompleto,
                                        list[2] + " " + list[3] + " " + list[4] + " " + list[5]);
                                utils.getAssertLocalizadorContiene(txtValidarCiudad, list[6]);
                                utils.getAssertLocalizadorContiene(txtValidarDireccion, list[7]);
                                utils.getAssertLocalizadorContiene(txtValidarCorreo, list[8]);
                                validarDatosBancariosDelTitularDeLaCuenta(list[9], list[10], list[11]);
                                utils.getAssertLocalizadorContiene(txtValidarNumTelefono, list[12]);
                                modalCodigoDeVerificacion(dataIniciarSesion);
                                break;
                            case "Definir cuenta":
                                utils.esperaMilis(3000);
                                utils.getAssertLocalizadorContiene(txtValidarNumDocumento, list[1]);
                                utils.getAssertLocalizadorContiene(txtValidarNombreCompleto,
                                        list[2] + " " + list[3]);
                                utils.getAssertLocalizadorContiene(txtValidarNumCuenta, list[0]);
                                utils.getAssertLocalizadorContiene(txtValidarConfirmNumCuenta, list[0]);
                                modalCodigoDeVerificacion(dataIniciarSesion);
                                break;

                            case "Editar cuenta":
                                utils.esperaMilis(3000);
                                validarDatosBancariosDelTitularDeLaCuenta(list[4], list[5], list[6]);
                                modalCodigoDeVerificacion(dataIniciarSesion);
                                break;
                        }

                    } catch (Exception e) {
                        System.out.println(
                                "Los datos de la cuenta bancaria inscrita no coinciden con los datos de la confirmacion ***\n"
                                        + e);
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
