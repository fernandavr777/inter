package com.inter.pageObjects.pagoEnCasa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.inter.pageObjects.yopMail.HomeYopMailPage;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class EditarCuentaBancariaPage extends PageObject {

    public By headerEditarCuentaBancaria = By
            .xpath("//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[1]/h1");
    // DatosBancarios titular de la cuenta
    public By selectEntidad = By.xpath(
            "//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[2]/div[2]/div[1]/div/select");
    public By checkBoxCuentaAhorros = By.xpath(
            "//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[2]/div[2]/div[2]/div[1]/div/input[1]");
    public By checkBoxCuentaCorriente = By.xpath(
            "//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[2]/div[2]/div[2]/div[1]/div/input[2]");
    public By inputNumeroDeCuenta = By
            .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[2]/div[2]/div[2]/div/input");
    public By inputConfirmarNumeroDeCuenta = By
            .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[2]/div[2]/div[3]/div/input");
    public By inputNumTelefonoTitular = By
            .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[2]/div[4]/div/input");
    // Botones
    public By btnCancelar = By
            .xpath("//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[3]/div[2]/a");
    public By btnConfirmar = By
            .xpath("//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[3]/div[2]/button");

    Utils utils = new Utils();
    ConfirmarDatosPage confirmarDatosPage = new ConfirmarDatosPage();
    String numCuentaBancariaEdit = "";

    public void editarCuentaBancaria(String dataEditarCuentaBancaria, String dataIniciarSesion) {
        CSVReader csvReader = utils.dataCsv(dataEditarCuentaBancaria);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(4000);
                        getDriver().findElement(headerEditarCuentaBancaria).isDisplayed();
                        WebElement selectEntidadWE = getDriver().findElement(selectEntidad);
                        utils.forzarClickJS(selectEntidadWE);
                        utils.seleccionarListaTextoVisible(selectEntidad, list[4]);
                        switch (list[5]) {
                            case "ahorros":
                                getDriver().findElement(checkBoxCuentaAhorros).click();
                                break;
                            case "corriente":
                                getDriver().findElement(checkBoxCuentaCorriente).click();
                                break;
                        }
                        getDriver().findElement(inputNumeroDeCuenta).clear();
                        getDriver().findElement(inputNumeroDeCuenta).sendKeys(list[6]);
                        getDriver().findElement(inputConfirmarNumeroDeCuenta).clear();
                        getDriver().findElement(inputConfirmarNumeroDeCuenta)
                                .sendKeys(list[6]);
                        Serenity.takeScreenshot();
                        WebElement btnConfirmarWE = getDriver().findElement(btnConfirmar);
                        utils.forzarClickJS(btnConfirmarWE);
                        confirmarDatosPage.validarDatosCuentaBancaria(dataEditarCuentaBancaria, dataIniciarSesion, "Editar cuenta");
                        

                    } catch (Exception e) {
                        System.out.println(
                                "Error al editar la cuenta bancaria ***\n" + e);
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
