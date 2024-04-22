package com.inter.utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import static org.junit.Assert.assertTrue;

public class Utils extends PageObject {

    public void validacionInputs(By localizador, String data) throws UnsupportedFlavorException, IOException {
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        getDriver().findElement(localizador).sendKeys(selectAll);
        String selectcopy = Keys.chord(Keys.CONTROL, "c");
        getDriver().findElement(localizador).sendKeys(selectcopy);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        esperaMilis(1000);
        String result = (String) clipboard.getData(DataFlavor.stringFlavor);
        Assert.assertEquals(result, data);
        esperaMilis(1000);
        limpiarClipboard();
    }

    public void copiarValorElemento(By localizador, String data) throws UnsupportedFlavorException, IOException {
        getDriver().findElement(localizador).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        String selectcopy = Keys.chord(Keys.CONTROL, "c");
        System.out.println(selectcopy);
        Assert.assertEquals(selectcopy, data);
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            getDriver().findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void esperarURL(String contenidoURL) {
        WebDriverWait wait = new WebDriverWait(getDriver(), getImplicitWaitTimeout());
        wait.until(ExpectedConditions.urlContains("/" + contenidoURL));
    }

    public void habilitarElemento() {
        WebElement inp = getDriver().findElement(By.className("form-control ng-untouched ng-pristine"));
        // Option 1 remove the disabled attribute
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].removeAttribute('disabled'))", inp);
    }

    public void forzarClickJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", element);
    }

    public void esperarElementoClickeable(By elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public void esperarElementoVisible(By elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    public boolean aceptarAlertaVisible() {
        try {
            ExpectedConditions.alertIsPresent();
            getDriver().switchTo().alert().accept();
            return true;
        } catch (Exception e) {
            System.out.println("alert was not present");
            return false;
        }
    }

    public void cancelarAlertaVisible() {
        if (ExpectedConditions.alertIsPresent() == null) {
            System.out.println("alert was not present");
        } else {
            System.out.println("alert was present");
            getDriver().switchTo().alert().dismiss();
        }
    }

    public void esperaMilis(Integer milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validarClickElemento(WebElement click) {
        for (int i = 0; i <= 4; i++) {
            String script = "let clicked = false;" + "var btn = arguments[0];" + "btn.addEventListener('click', () => {"
                    + "window.clicked = true;" + "});";
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            //js.executeSesperaMiliscript(script, click);
            click.click();
            esperaMilis(2000);
            WebElement reCaptchaWe = getDriver()
                    .findElement(By.xpath("//*[@id='maincontent']/div[1]/div[2]/div[1]/div/div"));
            Boolean reCaptchaBol = reCaptchaWe.isDisplayed();
            Serenity.takeScreenshot();
            if (reCaptchaBol == false) {
                Boolean clicking = (Boolean) js.executeScript("return clicked;");
                System.out.println("el elemento fue clickeado " + clicking);
                assertTrue(clicking);
            }
        }
    }

    public String extraerCadenaDeTextoLocalizador(By localizador, int inicio, int fin) {
        String cadenaDeTexto = getTextLabel(localizador);
        String sSubCadenaTexto = cadenaDeTexto.substring(inicio, fin);
        System.out.println(sSubCadenaTexto);
        return sSubCadenaTexto;
    }

    public void extraerCadenaDeTextoWebElement(By localizador, int inicio, int fin) {
        WebElement textocadena = getDriver().findElement(localizador);
        String texto = getTextLabelWebElement(textocadena);
        System.out.println(texto);
        String sSubCadenaTexto = texto.substring(inicio, fin);
        System.out.println(sSubCadenaTexto);
    }

    public void scrollPagina(String numScroll) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0," + numScroll + ")");
    }

    public void seleccionarElementoQueCoincida(String xPath) {
        new Actions(getDriver())
                .moveToElement(find(
                        By.xpath(""+xPath+"")))
                .click().build().perform();
    }

    public void executeLocalizadorJS(String querySelector) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) getDriver();
        String typeKeywordJS = querySelector;
        jsExecutor.executeScript(typeKeywordJS);
    }

    public void limpiarClipboard() {
        Toolkit toolkitClear = Toolkit.getDefaultToolkit();
        Clipboard clipboardclear = toolkitClear.getSystemClipboard();
        clipboardclear.setContents(new StringSelection(""), null);
    }

    public void getSelectOptionWebelement(WebElement localizador, String data) {
        Select selectTipoId = new Select(localizador);
        WebElement optionIdSelect = selectTipoId.getFirstSelectedOption();
        String optionIdSelected = optionIdSelect.getText();
        Assert.assertEquals(optionIdSelected, data);
    }

    public void getSelectOption(By localizador, String data) {
        Select selectTipoId = new Select(find(localizador));
        WebElement optionIdSelect = selectTipoId.getFirstSelectedOption();
        String optionIdSelected = optionIdSelect.getText();
        Assert.assertEquals(optionIdSelected, data);
    }

    public void seleccionarListaValor(By lista, String valor) {
        new Select(find(lista)).selectByValue(valor);
    }

    public void seleccionarListaTextoVisible(By lista, String valor) {
        new Select(find(lista)).selectByVisibleText(valor);
    }

    public void seleccionarListaIndice(By lista, Integer indice) {
        new Select(find(lista)).selectByIndex(indice);
    }

    public void getAssertLocalizador(By localizador, String data) {
        String localizadorAssert = getTextLabel(localizador);
        Assert.assertEquals(localizadorAssert, data);
    }

    public void getAssertLocalizadorContiene(By localizador, String data) {
        String localizadorAssert = getTextLabel(localizador);
        Assert.assertTrue(localizadorAssert.contains(data));
    }

    public void getAssertLocalizadorString(String localizador, String data) {
        Assert.assertEquals(localizador, data);
    }

    public void getAssertLocalizadorWebElement(WebElement localizador, String data) {
        String localizadorAssert = getTextLabelWebElement(localizador);
        Assert.assertEquals(localizadorAssert, data);
    }

    public void cambioDePestaña(int tab) {
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        System.out.println(tabs.size());
        getDriver().switchTo().window((String) tabs.get(tab));
    }

    public void abrirNuevaPestana() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open('');");
        esperaMilis(2000);
        cambioDePestaña(1);
    }

    public void cerrarPestana() {
        getDriver().close();
        cambioDePestaña(0);
    }

    public Integer busquedaDeElemento(By localizador) {

        try {
            WebElement dynamicElement = getDriver().findElement(localizador);
            boolean state = dynamicElement.isDisplayed();
            if (state == true) {
                System.out.println("Element present");
                return 1;
            } else {
                System.out.println("Element not present");
                return 0;
            }
        } catch (Exception e) {

            System.out.println("Error - Element not present " + e);
            return -1;
        }

    }

    public void scrollToElement(By localizador) {
        new Actions(getDriver()).moveToElement(find(localizador)).perform();
    }

    public String getTextLabel(By element) {
        return getDriver().findElement(element).getText();

    }

    public String getTextLabelWebElement(WebElement localizador) {
        String elemento = localizador.getText();
        return elemento;
    }

    public CSVReader dataCsv(String ruta) {
        CSVReader celdas = null;
        try {
            Reader archCSV = new FileReader(ruta);
            CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
            celdas = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo CSV : " + e);
        }
        return celdas;
    }

    public void cargaArchivos(By localizador, String ruta) {
        // utils.esperaMilis(5000);
        File file = new File(ruta);
        String path = file.getAbsolutePath();
        esperaMilis(5000);
        getDriver().findElement(localizador).sendKeys(path);
    }

    public Double formatearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

}
