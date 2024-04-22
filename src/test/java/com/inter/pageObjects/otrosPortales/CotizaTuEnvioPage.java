package com.inter.pageObjects.otrosPortales;

import org.openqa.selenium.By;

import com.inter.utils.Utils;

import net.serenitybdd.core.pages.PageObject;

public class CotizaTuEnvioPage extends PageObject {

    public By headerCotizaTuEnvio = By.xpath("/html/body/div[2]/section[2]/div/div/div/div[2]/div/h2");
    

    Utils utils = new Utils();

    public void validarHeaderCotizaTuEnvio() {
        getDriver().findElement(headerCotizaTuEnvio).isDisplayed();
    }

}
