package com.inter.pageObjects.pagoEnCasa;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.inter.utils.Utils;
import com.opencsv.CSVReader;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class MisCuentasBancariasPage extends PageObject {

    public By headerTusCuentasInscritas = By
            .xpath("//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[1]/div/div/div/div/h1");
    public By btnAtrasHomePage = By.xpath("//app-header/nav/div[1]/div[3]/app-boton-atras/button");
    public By btnInscribirNuevaCuenta = By
            .xpath("//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[3]/button[2]");
    public By btnVerMisPagosEnCasa = By.xpath("//app-cuentas-bancarias/div[1]/div[3]/button[1]");
    public By btnPaginaSiguienteTabla = By.xpath("//*[@id='btnSiguiente']");
    public By tableCuentasBancarias = By.xpath("//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table");

    // Modal quitar cuenta bancaria
    public By headerModalQuitarCuenta = By.xpath("//*[@id='MensajeQuitarCuenta']/div/div/div/div[1]/div/h5");
    public By validarNumeroDeCuenta = By.xpath("//*[@id='MensajeQuitarCuenta']/div/div/div/h6");
    public By btnConfirmarEliminar = By.xpath("//*[@id='btnQuitarCuenta']");
    public By btnCancelar = By.xpath("//*[@id='btnQuitarCuenta']");

    Utils utils = new Utils();
    InscribirNuevaCuentaBancariaPage inscribirNuevaCuentaBancariaPage = new InscribirNuevaCuentaBancariaPage();
    EditarCuentaBancariaPage editarCuentaBancariaPage = new EditarCuentaBancariaPage();

    public void validarHeaderMisCuentasBancarias() {
        utils.esperarElementoVisible(headerTusCuentasInscritas);
        getDriver().findElement(headerTusCuentasInscritas).isDisplayed();
    }

    public void irAtrasAlHomePage() {
        getDriver().findElement(btnAtrasHomePage).click();
    }

    public void inscribirNuevaCuentaBancaria(String dataUsuarioSinCuentaBancaria) {
        WebElement btnWEInscribirCuenta = getDriver().findElement(btnInscribirNuevaCuenta);
        utils.esperaMilis(3000);
        utils.forzarClickJS(btnWEInscribirCuenta);
        Serenity.takeScreenshot();
        inscribirNuevaCuentaBancariaPage.formularioInscribirCuentaBancaria(dataUsuarioSinCuentaBancaria);
    }

    /*
     * public void buscarCuentaEnLaTablaprueba() {
     * String numCuenta = inscribirNuevaCuentaBancariaPage.numCuenta;
     * int n = 4;
     * String ultimosNumerosCuenta = StringUtils.right(numCuenta, n);
     * String numDocumento = inscribirNuevaCuentaBancariaPage.numDocumento;
     * String nombreTiTular = inscribirNuevaCuentaBancariaPage.nombreTitularCuenta +
     * " "
     * + inscribirNuevaCuentaBancariaPage.apellidoTitular;
     * By validarCuentayTitular = By.xpath(
     * "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
     * + ultimosNumerosCuenta + "') and contains(td[3]/text(), '" + numDocumento
     * + "') and contains(td[4]/text(), '" + nombreTiTular + "')]");
     * By definirCuentaBancaria = By.xpath(
     * "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
     * + ultimosNumerosCuenta + "') and contains(td[3]/text(), '" + numDocumento
     * + "') and contains(td[4]/text(), '" + nombreTiTular + "')]//div/a[1]");
     * // String dataTabla = utils.getTextLabel(validarCuentayTitular);
     * while (getDriver().findElement(tableCuentasBancarias).isDisplayed()) {
     * if (getDriver().findElement(validarCuentayTitular).isDisplayed()) {
     * utils.getAssertLocalizadorContiene(validarCuentayTitular,
     * ultimosNumerosCuenta);
     * utils.getAssertLocalizadorContiene(validarCuentayTitular, numDocumento);
     * utils.getAssertLocalizadorContiene(validarCuentayTitular, nombreTiTular);
     * if (getDriver().findElement(definirCuentaBancaria).isDisplayed()) {
     * getDriver().findElement(definirCuentaBancaria).click();
     * break;
     * } else {
     * System.out.println("La cuenta ya se encuentra definida");
     * break;
     * }
     * 
     * } else {
     * utils.esperaMilis(5000);
     * if (getDriver().findElement(btnPaginaSiguienteTabla).isEnabled()) {
     * getDriver().findElement(btnPaginaSiguienteTabla).click();
     * } else {
     * System.out.println("La cuenta bancaria no existe");
     * getDriver().close();
     * }
     * }
     * }
     * }
     */

    public void buscarCuentaEnLaTabla() {
        String numCuenta = inscribirNuevaCuentaBancariaPage.numCuenta;
        int n = 4;
        String ultimosNumerosCuenta = StringUtils.right(numCuenta, n);
        String numDocumento = inscribirNuevaCuentaBancariaPage.numDocumento;
        String nombreTiTular = inscribirNuevaCuentaBancariaPage.nombreTitularCuenta + " "
                + inscribirNuevaCuentaBancariaPage.apellidoTitular;
        By validarCuentayTitular = By.xpath(
                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                        + ultimosNumerosCuenta + "') and contains(td[3]/text(), '" + numDocumento
                        + "') and contains(td[4]/text(), '" + nombreTiTular + "')]");
        // String dataTabla = utils.getTextLabel(validarCuentayTitular);
        while (getDriver().findElement(tableCuentasBancarias).isDisplayed()) {
            if (getDriver().findElement(validarCuentayTitular).isDisplayed()) {
                utils.getAssertLocalizadorContiene(validarCuentayTitular, ultimosNumerosCuenta);
                utils.getAssertLocalizadorContiene(validarCuentayTitular, numDocumento);
                utils.getAssertLocalizadorContiene(validarCuentayTitular, nombreTiTular);
                break;
            } else {
                utils.esperaMilis(5000);
                if (getDriver().findElement(btnPaginaSiguienteTabla).isEnabled()) {
                    getDriver().findElement(btnPaginaSiguienteTabla).click();
                } else {
                    System.out.println("La cuenta bancaria no existe");
                    getDriver().close();
                }
            }
        }
    }

    public void buscarYValidarCuentaBancaria(String numCuenta, String numDocumento, String nombre, String Apellido) {
        utils.esperaMilis(3000);
        By validarCuentayTitular = By.xpath(
                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                        + numCuenta + "') and contains(td[3]/text(), '" + numDocumento
                        + "') and contains(td[4]/text(), '" + nombre
                        + "') and contains(td[4]/text(), '" + Apellido + "')]");
        // String dataTabla = utils.getTextLabel(validarCuentayTitular);
        while (getDriver().findElement(tableCuentasBancarias).isDisplayed()) {
            //boolean  elementoEsPresente = getDriver().findElement(validarCuentayTitular).isDisplayed();
            if (utils.isElementPresent(validarCuentayTitular) == true) {
                utils.getAssertLocalizadorContiene(validarCuentayTitular, numCuenta);
                utils.getAssertLocalizadorContiene(validarCuentayTitular, numDocumento);
                utils.getAssertLocalizadorContiene(validarCuentayTitular, nombre);
                utils.getAssertLocalizadorContiene(validarCuentayTitular, Apellido);
                break;
            } else {
                utils.esperaMilis(5000);
                WebElement elementoEstaHabilitado = getDriver().findElement(btnPaginaSiguienteTabla);
                String elementoHabilitado = elementoEstaHabilitado.getAttribute("disabled");
                if (elementoHabilitado.equals("false")) {
                    getDriver().findElement(btnPaginaSiguienteTabla).click();
                } else {
                    System.out.println("La cuenta bancaria no existe");
                    Serenity.takeScreenshot();
                    break;
                }
            }
        }
        //getDriver().close();
    }

    public void buscarCuentaEnLaTablaCuentaYaInscrita(String dataBuscarCuentaInscritaEnLaTabla, String flujo) {
        CSVReader csvReader = utils.dataCsv(dataBuscarCuentaInscritaEnLaTabla);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        switch (flujo) {
                            case "Buscar cuenta":
                                buscarYValidarCuentaBancaria(list[0], list[1], list[2], list[3]);
                                break;

                            case "Buscar cuenta editada":
                                buscarYValidarCuentaBancaria(list[6], list[1], list[2], list[3]);
                                break;

                            case "Buscar cuenta eliminada":
                                buscarYValidarCuentaBancaria(list[0], list[1], list[2], list[3]);
                                break;
                        }
                        // utils.esperaMilis(5000);

                    } catch (Exception e) {
                        System.out.println(
                                "Error al buscar la cuenta bancaria ***\n" + e);
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

    public void definirCuentaBancaria() {
        String numCuenta = inscribirNuevaCuentaBancariaPage.numCuenta;
        int n = 4;
        String ultimosNumerosCuenta = StringUtils.right(numCuenta, n);
        String numDocumento = inscribirNuevaCuentaBancariaPage.numDocumento;
        String nombreTiTular = inscribirNuevaCuentaBancariaPage.nombreTitularCuenta + " "
                + inscribirNuevaCuentaBancariaPage.apellidoTitular;
        By definirCuentaBancaria = By.xpath(
                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                        + ultimosNumerosCuenta + "') and contains(td[3]/text(), '" + numDocumento
                        + "') and contains(td[4]/text(), '" + nombreTiTular + "')]//div/a[1]");
        // String dataTabla = utils.getTextLabel(validarCuentayTitular);
        while (getDriver().findElement(tableCuentasBancarias).isDisplayed()) {
            if (getDriver().findElement(definirCuentaBancaria).isDisplayed()) {
                getDriver().findElement(definirCuentaBancaria).click();
                break;

            } else {
                utils.esperaMilis(5000);
                if (getDriver().findElement(btnPaginaSiguienteTabla).isEnabled()) {
                    getDriver().findElement(btnPaginaSiguienteTabla).click();
                } else {
                    System.out.println("La cuenta bancaria no existe");
                    getDriver().close();
                }
            }

        }

    }

    public void definirCuentaBancariaSinIncripcion(String dataDefinirCuentaBancaria) {
        CSVReader csvReader = utils.dataCsv(dataDefinirCuentaBancaria);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(5000);
                        By definirCuentaBancaria = By.xpath(
                                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                                        + list[0] + "') and contains(td[3]/text(), '" + list[1]
                                        + "') and contains(td[4]/text(), '" + list[2]
                                        + "') and contains(td[4]/text(), '" + list[3] + "')]//div/a[1]");
                        // String dataTabla = utils.getTextLabel(validarCuentayTitular);
                        while (getDriver().findElement(tableCuentasBancarias).isDisplayed()) {
                            if (getDriver().findElement(definirCuentaBancaria).isDisplayed()) {
                                getDriver().findElement(definirCuentaBancaria).click();
                                break;

                            } else {
                                utils.esperaMilis(5000);
                                if (getDriver().findElement(btnPaginaSiguienteTabla).isEnabled()) {
                                    getDriver().findElement(btnPaginaSiguienteTabla).click();
                                } else {
                                    System.out.println("La cuenta bancaria no existe");
                                    getDriver().close();
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(
                                "Error al definir la cuenta bancaria ***\n" + e);
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

    public void editarCuentaBancariaYConfirmarDatos(String dataEdicionCuentaBancaria, String dataIniciarSesion) {
        CSVReader csvReader = utils.dataCsv(dataEdicionCuentaBancaria);
        String[] list = null;
        Integer contador = 0;
        // si arriba la busco solo entrar a hacer click
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(5000);
                        By editarCuentaBancaria = By.xpath(
                                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                                        + list[0] + "') and contains(td[3]/text(), '" + list[1]
                                        + "') and contains(td[4]/text(), '" + list[2]
                                        + "') and contains(td[4]/text(), '" + list[3] + "')]//div/a[2]");
                        // String dataTabla = utils.getTextLabel(validarCuentayTitular);
                        while (getDriver().findElement(tableCuentasBancarias).isDisplayed()) {
                            if (getDriver().findElement(editarCuentaBancaria).isDisplayed()) {
                                getDriver().findElement(editarCuentaBancaria).click();
                                break;

                            } else {
                                utils.esperaMilis(5000);
                                if (getDriver().findElement(btnPaginaSiguienteTabla).isEnabled()) {
                                    getDriver().findElement(btnPaginaSiguienteTabla).click();
                                } else {
                                    System.out.println("La cuenta bancaria no existe");
                                    getDriver().close();
                                }
                            }
                        }
                        editarCuentaBancariaPage.editarCuentaBancaria(dataEdicionCuentaBancaria, dataIniciarSesion);

                    } catch (Exception e) {
                        System.out.println(
                                "Error al definir la cuenta bancaria ***\n" + e);
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

    public void validarCuentaBancariaDefinidaEnTabla() {
        String numCuenta = inscribirNuevaCuentaBancariaPage.numCuenta;
        int n = 4;
        String ultimosNumerosCuenta = StringUtils.right(numCuenta, n);
        String numDocumento = inscribirNuevaCuentaBancariaPage.numDocumento;
        String nombreTiTular = inscribirNuevaCuentaBancariaPage.nombreTitularCuenta + " "
                + inscribirNuevaCuentaBancariaPage.apellidoTitular;
        utils.esperaMilis(5000);
        By validarCuentayTitular = By.xpath(
                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                        + ultimosNumerosCuenta + "') and contains(td[3]/text(), '" + numDocumento
                        + "') and contains(td[4]/text(), '" + nombreTiTular
                        + "') and contains(td[5]/text(), 'Cuenta definida')]");
        if (getDriver().findElement(validarCuentayTitular).isDisplayed()) {
            Serenity.takeScreenshot();
        }

    }

    public void validarCuentaBancariaDefinidaEnTablaSinIncrispcion(String dataDefinirCuentaBancaria) {
        CSVReader csvReader = utils.dataCsv(dataDefinirCuentaBancaria);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(5000);
                        By validarCuentayTitular = By.xpath(
                                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                                        + list[0] + "') and contains(td[3]/text(), '" + list[1]
                                        + "') and contains(td[4]/text(), '" + list[2]
                                        + "') and contains(td[4]/text(), '" + list[3]
                                        + "') and contains(td[5]/text(), 'Cuenta definida')]");

                        if (getDriver().findElement(validarCuentayTitular).isDisplayed()) {
                            Serenity.takeScreenshot();
                        }

                    } catch (Exception e) {
                        System.out.println(
                                "Error al definir la cuenta bancaria ***\n" + e);
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

    public void eliminarCuentaBancaria(String dataEliminarCuentaBancaria) {
        CSVReader csvReader = utils.dataCsv(dataEliminarCuentaBancaria);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        // utils.esperaMilis(5000);
                        By btnEliminarCuenta = By.xpath(
                                "//app-listacuentasbancarias/app-cuentas-bancarias/div[1]/div[2]/table/tbody/tr[contains(td/text(), '"
                                        + list[0] + "') and contains(td[3]/text(), '" + list[1]
                                        + "') and contains(td[4]/text(), '" + list[2]
                                        + "') and contains(td[4]/text(), '" + list[3] + "')]//div/a[3]");
                        while (getDriver().findElement(tableCuentasBancarias).isDisplayed()) {
                            if (getDriver().findElement(btnEliminarCuenta).isDisplayed()) {
                                getDriver().findElement(btnEliminarCuenta).click();
                                utils.esperaMilis(4000);
                                getDriver().switchTo().activeElement();
                                getDriver().findElement(headerModalQuitarCuenta).isDisplayed();
                                utils.getAssertLocalizadorContiene(validarNumeroDeCuenta, list[0]);
                                getDriver().findElement(btnConfirmarEliminar).click();
                                utils.esperaMilis(8000);
                                break;
                            } else {
                                utils.esperaMilis(5000);
                                if (getDriver().findElement(btnPaginaSiguienteTabla).isEnabled()) {
                                    getDriver().findElement(btnPaginaSiguienteTabla).click();
                                } else {
                                    System.out.println("La cuenta bancaria no existe");
                                    getDriver().close();
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(
                                "Error al buscar la cuenta bancaria ***\n" + e);
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
