package com.inter.pageObjects.sigueTusEnvios;

import org.openqa.selenium.By;
import com.inter.utils.Utils;
import net.serenitybdd.core.pages.PageObject;

public class SigueTusEnviosPage extends PageObject {

    public By headerTusEnvios = By.xpath("//*[@id='app']/div/div/div/div/div[1]/h1");
    public By frameTusEnviosVisible = By.xpath("//app-sigue-tu-envio-blazor-tmp/iframe");
    public By btnIrAtrasHomePage = By.xpath("//app-header/nav/div[1]/div[3]/app-boton-atras/button");

    Utils utils = new Utils();

    public void validarHeaderTusEnvios() {
        utils.esperarElementoVisible(frameTusEnviosVisible);
        getDriver().findElement(frameTusEnviosVisible).isDisplayed();
    }

    public void irAtrasAlHomePage() {
        getDriver().findElement(btnIrAtrasHomePage).click();
    }

}
