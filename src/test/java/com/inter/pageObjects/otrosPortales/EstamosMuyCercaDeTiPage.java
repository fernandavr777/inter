package com.inter.pageObjects.otrosPortales;

import org.openqa.selenium.By;
import com.inter.utils.Utils;
import net.serenitybdd.core.pages.PageObject;

public class EstamosMuyCercaDeTiPage extends PageObject {

    public By lblLineaNacional = By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav/div/div[1]/div");

    Utils utils = new Utils();

    public void validarLblLineaNacional() {
        getDriver().findElement(lblLineaNacional).isDisplayed();
    }
}
