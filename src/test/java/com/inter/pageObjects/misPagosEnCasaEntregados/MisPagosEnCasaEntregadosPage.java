package com.inter.pageObjects.misPagosEnCasaEntregados;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class MisPagosEnCasaEntregadosPage extends PageObject {

    // Header
    public By headerPagosEnCasaEntregados = By
            .xpath("//app-historico-pagos/app-listar-historico-pagos/form/div/div/div[1]/div/div[1]/div/h1");
    public By btnIrAtrasHomePage = By.xpath("//app-header/nav/div[1]/div[3]/app-boton-atras/button");
    // Tabla
    public By tablaMisPagosEnCasaEntregados = By
            .xpath("//app-historico-pagos/app-listar-historico-pagos/form/div/div/div[3]/table");
    // Filtros
    public By selectBuscarPor = By.xpath("//app-listar-historico-pagos/form/div/div/div[1]/div/div[3]/div/select");
    public By inputNumero = By.xpath("//*[@id='NumeroGuia']");
    public By inputFechaDesde = By.xpath("//app-listar-historico-pagos/form/div/div/div[1]/div/div[5]/div/input[1]");
    public By inputFechaHasta = By.xpath("//app-listar-historico-pagos/form/div/div/div[1]/div/div[6]/div/input[1]");
    public By selectEstado = By.xpath("//app-listar-historico-pagos/form/div/div/div[1]/div/div[7]/div/select");
    public By btnAplicarFiltros = By.xpath("//app-listar-historico-pagos/form/div/div/div[1]/div/div[8]/ul/li[1]/a");

    Utils utils = new Utils();

    public void validarHeaderPagosEnCasaEntregados() {
        getDriver().findElement(headerPagosEnCasaEntregados).isDisplayed();
    }

    public void irAtrasAlHomePage() {
        getDriver().findElement(btnIrAtrasHomePage).click();
    }

    public void esperarTabla() {
        utils.esperarElementoVisible(tablaMisPagosEnCasaEntregados);
    }

    public void filtrarPorFechayEstado(String dataFiltrosMisPagosEnCasaEntregados) {
        CSVReader csvReader = utils.dataCsv(dataFiltrosMisPagosEnCasaEntregados);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(4000);
                        By btnCalendarioDesde = By.xpath(
                                "//app-historico-pagos/app-listar-historico-pagos/form/div/div/div[1]/div/div[5]/div/input[2]");
                        By selectMesDesde = By.xpath(
                                "//app-listar-historico-pagos/form/div/div/div[1]/div/div[5]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]");
                        By selectDiaDesde = By.xpath(
                                "//app-listar-historico-pagos/form/div/div/div[1]/div/div[5]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div/div/div[text() = '"
                                        + list[3] + "']");
                        By btnCalendarioHasta = By.xpath(
                                "//app-historico-pagos/app-listar-historico-pagos/form/div/div/div[1]/div/div[6]/div/input[2]");
                        By selectMesHasta = By.xpath(
                                "//app-listar-historico-pagos/form/div/div/div[1]/div/div[6]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]");
                        By selectDiaHasta = By.xpath(
                                "//app-listar-historico-pagos/form/div/div/div[1]/div/div[6]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div/div/div[text() = '"
                                        + list[5] + "']");
                        By selectMesVisibleHasta = By.xpath(
                                "//app-listar-historico-pagos/form/div/div/div[1]/div/div[6]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]/option[text() = '"
                                        + list[4] + "']");
                        By opcionesMes = By.xpath(
                                "/html/body/app-root/app-layout/app-historico-pagos/app-listar-historico-pagos/form/div/div/div[1]/div/div[5]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]");
                        WebElement selectMesDesdeWE;
                        WebElement selectDiaDesdeWE;
                        WebElement selectMesHastaWE;
                        WebElement selectDiaHastaWE;
                        ArrayList<String> getOpcionesMes = new ArrayList();
                        // Fecha calendario desde
                        while (getDriver().findElement(btnCalendarioDesde).isDisplayed()) {
                            getDriver().findElement(btnCalendarioDesde).click();
                            selectMesDesdeWE = getDriver().findElement(selectMesDesde);
                            utils.forzarClickJS(selectMesDesdeWE);
                            WebElement opcionesMesWE = getDriver().findElement(opcionesMes);
                            List<WebElement> rowsList = opcionesMesWE.findElements(By.tagName("option"));
                            for (WebElement row : rowsList) {
                                getOpcionesMes.add(row.getText());
                            }
                            if (getOpcionesMes.contains(list[2])) {
                                utils.seleccionarListaTextoVisible(selectMesDesde, list[2]);
                                if (getDriver().findElement(selectDiaDesde).isEnabled()) {
                                    selectDiaDesdeWE = getDriver().findElement(selectDiaDesde);
                                    utils.forzarClickJS(selectDiaDesdeWE);
                                    break;
                                } else {
                                    int contDate = 0;
                                    while (contDate >= 0) {
                                        By selectDiaDesdeVisible = By.xpath(
                                                "//app-listar-historico-pagos/form/div/div/div[1]/div/div[5]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div/div/div[text() = '"
                                                        + contDate + "']");
                                        if (getDriver().findElement(selectDiaDesdeVisible).isEnabled()) {
                                            selectDiaDesdeWE = getDriver().findElement(selectDiaDesdeVisible);
                                            utils.forzarClickJS(selectDiaDesdeWE);
                                            break;
                                        } else {
                                            contDate++;
                                        }
                                    }
                                }
                            } else {
                                utils.seleccionarListaIndice(selectMesDesde, 1);
                                int contDate = 1;
                                while (contDate >= 1) {
                                    By selectDiaDesdeVisible = By.xpath(
                                            "//app-listar-historico-pagos/form/div/div/div[1]/div/div[5]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div/div/div[text() = '"
                                                    + contDate + "']");
                                    if (getDriver().findElement(selectDiaDesdeVisible).isEnabled()) {
                                        selectDiaDesdeWE = getDriver().findElement(selectDiaDesdeVisible);
                                        utils.forzarClickJS(selectDiaDesdeWE);
                                        break;
                                    } else {
                                        contDate++;
                                    }
                                }
                            }
                        }
                        // Fecha calendario Hasta
                        while (getDriver().findElement(btnCalendarioHasta).isDisplayed()) {
                            getDriver().findElement(btnCalendarioHasta).click();
                            selectMesHastaWE = getDriver().findElement(selectMesHasta);
                            utils.forzarClickJS(selectMesHastaWE);
                            if (getDriver().findElement(selectMesVisibleHasta).isDisplayed()) {
                                utils.seleccionarListaTextoVisible(selectMesHasta, list[4]);
                                if (getDriver().findElement(selectDiaHasta).isEnabled()) {
                                    selectDiaHastaWE = getDriver().findElement(selectDiaHasta);
                                    utils.forzarClickJS(selectDiaHastaWE);
                                    break;
                                } else {
                                    System.out.println(
                                            "El dia seleccionado no se encuentra habilitado dentro del rango de los 31 dias");
                                }
                            } else {
                                utils.seleccionarListaIndice(selectMesHasta, 1);
                                int contDate = 0;
                                while (contDate >= 0) {
                                    By selectDiaHastaVisible = By.xpath(
                                            "//app-listar-historico-pagos/form/div/div/div[1]/div/div[6]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div/div/div[text() = '"
                                                    + contDate + "']");
                                    if (getDriver().findElement(selectDiaHastaVisible).isEnabled()) {
                                        selectDiaHastaWE = getDriver().findElement(selectDiaHastaVisible);
                                        utils.forzarClickJS(selectDiaHastaWE);
                                        break;
                                    } else {
                                        contDate++;
                                    }
                                }
                            }
                        }
                        utils.seleccionarListaTextoVisible(selectEstado, list[6]);
                        Serenity.takeScreenshot();
                        getDriver().findElement(btnAplicarFiltros).click();
                    } catch (Exception e) {
                        System.out.println(
                                "Error al filtrar la fecha y el estado de los pagos en casa entregados ***\n" + e);
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

    public void validarFiltroFechayEstado(String dataFiltrosMisPagosEnCasaEntregados) {
        CSVReader csvReader = utils.dataCsv(dataFiltrosMisPagosEnCasaEntregados);
        String[] list = null;
        Integer contador = 0;
        WebElement table = getDriver().findElement(tablaMisPagosEnCasaEntregados);
        List<WebElement> rowsList = table.findElements(By.tagName("tr"));
        List<WebElement> columnsList = null;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(5000);
                        esperarTabla();
                        if (list[6].equals("todos")) {
                            Serenity.takeScreenshot();
                        } else {
                            for (WebElement row : rowsList) {
                                columnsList = row.findElements(
                                        By.xpath(
                                                "//app-listar-historico-pagos/form/div/div/div[3]/table/tbody/tr/td[2]"));
                                for (WebElement column : columnsList) {
                                    utils.getAssertLocalizadorWebElement(column, list[6]);
                                }
                            }
                        }
                        Serenity.takeScreenshot();
                    } catch (Exception e) {
                        System.out.println(
                                "La tabla muestra resultados diferentes al filtro ***\n" + e);
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

    public void filtroBuscarPorNumeroEstado(String dataFiltrosMisPagosEnCasaEntregados) {
        CSVReader csvReader = utils.dataCsv(dataFiltrosMisPagosEnCasaEntregados);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        getDriver().navigate().refresh();
                        //WebElement selectBuscarPorWE = getDriver().findElement(selectBuscarPor);
                        //utils.forzarClickJS(selectBuscarPorWE);
                        utils.seleccionarListaTextoVisible(selectBuscarPor, list[0]);
                        getDriver().findElement(inputNumero).sendKeys(list[1]);
                        // filtrarPorFechayEstado(dataFiltrosMisPagosEnCasaEntregados);
                        utils.seleccionarListaTextoVisible(selectEstado, list[6]);
                        Serenity.takeScreenshot();
                        getDriver().findElement(btnAplicarFiltros).click();
                        utils.esperaMilis(5000);
                        esperarTabla();
                    } catch (Exception e) {
                        System.out.println(
                                "Error al filtrar los pagos en casa entregados ***\n" + e);
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

    public void validarFiltroBuscarPorNumeroEstado(String dataFiltrosMisPagosEnCasaEntregados) {
        CSVReader csvReader = utils.dataCsv(dataFiltrosMisPagosEnCasaEntregados);
        String[] list = null;
        Integer contador = 0;
        WebElement table = getDriver().findElement(tablaMisPagosEnCasaEntregados);
        List<WebElement> rowsList = table.findElements(By.tagName("tr"));
        List<WebElement> columnsList = null;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        esperarTabla();
                        if (list[6].equals("todos")) {
                            for (WebElement row : rowsList) {
                                columnsList = row.findElements(
                                        By.xpath(
                                                "//app-listar-historico-pagos/form/div/div/div[3]/table/tbody/tr/th"));
                                for (WebElement column : columnsList) {
                                    utils.getAssertLocalizadorWebElement(column, list[1]);
                                }
                            }
                        } else {
                            for (WebElement row : rowsList) {
                                columnsList = row.findElements(
                                        By.xpath(
                                                "//app-listar-historico-pagos/form/div/div/div[3]/table/tbody/tr/th"));
                                for (WebElement column : columnsList) {
                                    utils.getAssertLocalizadorWebElement(column, list[1]);
                                }
                            }
                            /*for (WebElement row : rowsList) {
                                columnsList = row.findElements(
                                        By.xpath(
                                                "//app-listar-historico-pagos/form/div/div/div[3]/table/tbody/tr/td[2]"));
                                for (WebElement column : columnsList) {
                                    utils.getAssertLocalizadorWebElement(column, list[6]);
                                }
                            }*/
                        }
                        Serenity.takeScreenshot();
                    } catch (Exception e) {
                        System.out.println(
                                "La tabla muestra resultados diferentes al filtro ***\n" + e);
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

    public void filtroBuscarPorNumeroFechaEstado(String dataFiltrosMisPagosEnCasaEntregados) {
        CSVReader csvReader = utils.dataCsv(dataFiltrosMisPagosEnCasaEntregados);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        getDriver().navigate().refresh();
                        utils.seleccionarListaTextoVisible(selectBuscarPor, list[0]);
                        getDriver().findElement(inputNumero).sendKeys(list[1]);
                        filtrarPorFechayEstado(dataFiltrosMisPagosEnCasaEntregados);
                    } catch (Exception e) {
                        System.out.println(
                                "Error al filtrar los pagos en casa entregados ***\n" + e);
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

    public void validarFiltroBuscarPorNumeroFechaEstado(String dataFiltrosMisPagosEnCasaEntregados) {
        CSVReader csvReader = utils.dataCsv(dataFiltrosMisPagosEnCasaEntregados);
        String[] list = null;
        Integer contador = 0;
        WebElement table = getDriver().findElement(tablaMisPagosEnCasaEntregados);
        List<WebElement> rowsList = table.findElements(By.tagName("tr"));
        List<WebElement> columnsList = null;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        esperarTabla();
                        for (WebElement row : rowsList) {
                            columnsList = row.findElements(
                                    By.xpath(
                                            "//app-listar-historico-pagos/form/div/div/div[3]/table/tbody/tr/th"));
                            for (WebElement column : columnsList) {
                                utils.getAssertLocalizadorWebElement(column, list[1]);
                            }
                        }
                        validarFiltroFechayEstado(dataFiltrosMisPagosEnCasaEntregados);
                    } catch (Exception e) {
                        System.out.println(
                                "La tabla muestra resultados diferentes al filtro ***\n" + e);
                        contador++;
                    }
                } else {
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo CSV ***\n" + e);
        }
        getDriver().close();
    }

}
