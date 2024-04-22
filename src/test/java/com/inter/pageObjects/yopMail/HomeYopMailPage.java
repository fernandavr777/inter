package com.inter.pageObjects.yopMail;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class HomeYopMailPage extends PageObject {
    public By headerYopMail = By.xpath("/html/body/div/div[2]/header/div[2]/h1");
    public By txt_email = By.xpath("//input[@id='login']");
    public static String email;
    public static int num;
    public By btn_confirmeSuCuenta = By.xpath("//a[contains(text(), 'Confirme Su Cuenta')]");
    public By txtCodigoVerificacion = By.xpath("//*[@id='mail']/div");

    ArrayList<String> tabs;
    WebDriverWait waitIFrame;
    Utils utils = new Utils();
    public static String sSubCadena = "";

    public void abrirPaginaYopMail() {
        getDriver().get("https://yopmail.com/es/");
    }

    public void ingresarAlCorreoYCopiarCodigoDeVerficacion(String correoUsuario) {
        System.out.println(correoUsuario);
        CSVReader csvReader = utils.dataCsv(correoUsuario);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.abrirNuevaPestana();
                        abrirPaginaYopMail();
                        // utils.esperaMilis(2000);
                        getDriver().findElement(headerYopMail).isDisplayed();
                        getDriver().findElement(txt_email).sendKeys(list[0]);
                        getDriver().findElement(txt_email).sendKeys(Keys.ENTER);
                        // utils.esperaMilis(3000);
                        getDriver().switchTo().frame("ifmail");
                        sSubCadena = utils.extraerCadenaDeTextoLocalizador(txtCodigoVerificacion, 29, 35);
                        Serenity.takeScreenshot();
                        // utils.esperaMilis(2000);
                        System.out.println(sSubCadena);
                        utils.cerrarPestana();
                    } catch (Exception e) {
                        System.out.println(
                                "Error al ingresar al correo y extraer codigo de verificacion ***\n" + e);
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

    public void ingresarAlCorreoYCopiarCodigoDeVerficacionSinCsv(String correoUsuario) {
                        utils.abrirNuevaPestana();
                        abrirPaginaYopMail();
                        // utils.esperaMilis(2000);
                        getDriver().findElement(headerYopMail).isDisplayed();
                        getDriver().findElement(txt_email).sendKeys(correoUsuario);
                        getDriver().findElement(txt_email).sendKeys(Keys.ENTER);
                        // utils.esperaMilis(3000);
                        getDriver().switchTo().frame("ifmail");
                        sSubCadena = utils.extraerCadenaDeTextoLocalizador(txtCodigoVerificacion, 29, 35);
                        Serenity.takeScreenshot();
                        // utils.esperaMilis(2000);
                        System.out.println(sSubCadena);
                        utils.cerrarPestana();
    }

    public void crearCorreosRandom() {
        abrirPaginaYopMail();
        num = (int) (Math.random() * 1000) + 1;
        String emailAux = "interrapidisimo.G" + num;
        email = emailAux + "@yopmail.com";
        getDriver().findElement(txt_email).sendKeys(email);
        getDriver().findElement(txt_email).sendKeys(Keys.ENTER);
        utils.cerrarPestana();
        ;
    }

    public void clicBtn_confirmarCuenta() {
        tabs.clear();
        tabs.addAll(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().navigate().refresh();
        // utils.esperaMilis(4000);
        // waitIFrame = new WebDriverWait(getDriver(), 5);
        waitIFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"));
        getDriver().findElement(btn_confirmeSuCuenta).click();
        tabs.clear();
        tabs.addAll(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(2));
    }

}
