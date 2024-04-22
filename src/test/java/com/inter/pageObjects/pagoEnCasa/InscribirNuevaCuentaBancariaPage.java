package com.inter.pageObjects.pagoEnCasa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class InscribirNuevaCuentaBancariaPage extends PageObject {

        // Validar header lista cuentas bancarias
        public By headerInscribirNuevaCuenta = By
                        .xpath("//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[1]/h1");
        // Datos titular de la cuenta
        public By selectTipoDeDocumento = By
                        .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[1]/div[1]/div[1]/div/select");
        public By inputNumDocumento = By
                        .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[1]/div[1]/div[2]/div/input");
        public By inputPrimerNombre = By
                        .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[1]/div[2]/div[1]/div/input");
        public By inputSegundoNombre = By
                        .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[1]/div[2]/div[2]/div/input");
        public By inputPrimerApellido = By
                        .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[1]/div[3]/div[1]/div/input");
        public By inputSegundoApellido = By
                        .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[1]/div[3]/div[2]/div/input");
        public By selectCiudad = By.xpath(
                        "//app-administrar-cuenta-bancaria/app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[3]/div/select");
        public By inputDireccion = By.xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[4]/div/input");
        public By inputCorreoElectronico = By
                        .xpath("//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[5]/div/input");
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
        String numCuenta = "";
        String numDocumento = "";
        String nombreTitularCuenta = "";
        String apellidoTitular = "";


        public void validarHeaderInscribirCuenta() {
                getDriver().findElement(headerInscribirNuevaCuenta).isDisplayed();
        }

        public void formularioInscribirCuentaBancaria(String dataUsuarioSinCuentaBancaria) {
                CSVReader csvReader = utils.dataCsv(dataUsuarioSinCuentaBancaria);
                String[] list = null;
                Integer contador = 0;
                try {
                        while ((list = csvReader.readNext()) != null) {
                                if (contador >= 1) {
                                        try {   
                                                numCuenta = list[11];
                                                numDocumento = list[1];
                                                nombreTitularCuenta = list[2];
                                                apellidoTitular = list[4];
                                                utils.esperaMilis(3000);
                                                utils.esperarElementoClickeable(selectTipoDeDocumento);
                                                utils.seleccionarListaTextoVisible(selectTipoDeDocumento, list[0]);
                                                getDriver().findElement(inputNumDocumento).sendKeys(list[1]);
                                                getDriver().findElement(inputPrimerNombre).sendKeys(list[2]);
                                                getDriver().findElement(inputSegundoNombre).sendKeys(list[3]);
                                                getDriver().findElement(inputPrimerApellido).sendKeys(list[4]);
                                                getDriver().findElement(inputSegundoApellido).sendKeys(list[5]);
                                                utils.scrollToElement(selectCiudad);
                                                By selectCiudadCoincide = By.xpath(
                                                                "//app-formulario-cuenta-bancaria/form/div[2]/div[1]/div[3]/div/select/option[contains(text(), '"
                                                                                + list[6] + "')]");
                                                String ciudad = utils.getTextLabel(selectCiudadCoincide);
                                                utils.seleccionarListaTextoVisible(selectCiudad, ciudad);
                                                getDriver().findElement(inputDireccion).sendKeys(list[7]);
                                                getDriver().findElement(inputCorreoElectronico).sendKeys(list[8]);
                                                utils.seleccionarListaTextoVisible(selectEntidad, list[9]);
                                                if (list[10].equals("cta ahorros")) {
                                                        getDriver().findElement(checkBoxCuentaAhorros).click();
                                                }
                                                if (list[10].equals("cta corriente")) {
                                                        getDriver().findElement(checkBoxCuentaCorriente).click();
                                                }
                                                getDriver().findElement(inputNumeroDeCuenta).sendKeys(list[11]);
                                                getDriver().findElement(inputConfirmarNumeroDeCuenta)
                                                                .sendKeys(list[11]);
                                                getDriver().findElement(inputNumTelefonoTitular).sendKeys(list[12]);
                                                Serenity.takeScreenshot();
                                                WebElement btnConfirmarWE = getDriver().findElement(btnConfirmar);
                                                utils.forzarClickJS(btnConfirmarWE);

                                        } catch (Exception e) {
                                                System.out.println(
                                                                "Error al inscribir cuenta bancaria ***\n" + e);
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
