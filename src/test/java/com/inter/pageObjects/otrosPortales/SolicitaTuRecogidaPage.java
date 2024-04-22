package com.inter.pageObjects.otrosPortales;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class SolicitaTuRecogidaPage extends PageObject {

    public By lblSolicitaTusRecogidas = By.xpath("//app-encabezadorecogidasencasa/div/div/div/div[1]/div/p[2]");

    public void validarLblSolicitaTusRecogidas() {
        getDriver().findElement(lblSolicitaTusRecogidas).isDisplayed();
    }

}
