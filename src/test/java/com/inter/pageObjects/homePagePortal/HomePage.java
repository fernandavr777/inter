package com.inter.pageObjects.homePagePortal;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.inter.pageObjects.misPagosEnCasaEntregados.MisPagosEnCasaEntregadosPage;
import com.inter.pageObjects.otrosPortales.CotizaTuEnvioPage;
import com.inter.pageObjects.otrosPortales.EstamosMuyCercaDeTiPage;
import com.inter.pageObjects.otrosPortales.SolicitaTuRecogidaPage;
import com.inter.pageObjects.pagoEnCasa.MisCuentasBancariasPage;
import com.inter.pageObjects.sigueTusEnvios.SigueTusEnviosPage;
import com.inter.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {

    // Validar Header HomePage
    public By headerHomePage = By.xpath("//app-menu/div/div[2]/div/div[1]/h3/b");
    // Barra Header
    public By btnCerrarSesion = By.xpath("//app-header/nav/div[1]/div[3]/ul/li[3]/a");
    // Enlaces HomePage
    public By btnEnlacePagoEnCasa = By.xpath("//app-menu/div/div[2]/div/div[3]/div[1]/button");
    public By btnEnlaceSigueTusEnvios = By.xpath("//app-menu/div/div[2]/div/div[3]/div[2]/button");
    public By btnEnlaceMisPagosEnCasaEntregados = By.xpath("//app-menu/div/div[2]/div/div[3]/div[3]/button");
    public By btnEnlaceCotizaTuEnvio = By.xpath("//app-menu/div/div[2]/div/div[3]/div[4]/button");
    public By btnEnlaceEstamosMuyCercaDeTi = By.xpath("//app-menu/div/div[2]/div/div[3]/div[5]/button");
    public By btnEnlaceSolicitaTuRecogida = By.xpath("//app-menu/div/div[2]/div/div[3]/div[6]/button");

    Utils utils = new Utils();
    MisCuentasBancariasPage misCuentasBancariasPage = new MisCuentasBancariasPage();
    SigueTusEnviosPage sigueTusEnviosPage = new SigueTusEnviosPage();
    MisPagosEnCasaEntregadosPage misPagosEnCasaEntregadosPage = new MisPagosEnCasaEntregadosPage();
    CotizaTuEnvioPage cotizaTuEnvioPage = new CotizaTuEnvioPage();
    EstamosMuyCercaDeTiPage estamosMuyCercaDeTiPage = new EstamosMuyCercaDeTiPage();
    SolicitaTuRecogidaPage solicitaTuRecogidaPage = new SolicitaTuRecogidaPage();

    public void validarHeaderHomePage() {
        utils.getAssertLocalizador(headerHomePage, "Tenemos las mejores");
        Serenity.takeScreenshot();
        getDriver().close();
    }

    public void validarHeaderHomePageDisplayed() {
        getDriver().findElement(headerHomePage).isDisplayed();
        Serenity.takeScreenshot();
    }

    public void cerrarSesion() {
        getDriver().findElement(btnCerrarSesion).click();
    }

    public void validarEnlacePagoEncasa() {
        getDriver().findElement(btnEnlacePagoEnCasa).click();
        utils.esperarURL("miscuentasbancarias");
        misCuentasBancariasPage.validarHeaderMisCuentasBancarias();
        String uRL = getDriver().getCurrentUrl();
        Assert.assertEquals(uRL, "https://portalautogestionqa.interrapidisimo.com/cuentas/miscuentasbancarias");
        utils.esperaMilis(3500);
        Serenity.takeScreenshot();
    }

    public void validarEnlaceSigueTUsEnvios() {
        getDriver().findElement(btnEnlaceSigueTusEnvios).click();
        utils.esperarURL("mis-envios-bz/0");
        utils.esperaMilis(3000);
        sigueTusEnviosPage.validarHeaderTusEnvios();
        String uRL = getDriver().getCurrentUrl();
        Assert.assertEquals(uRL, "https://portalautogestionqa.interrapidisimo.com/envios/mis-envios-bz/0");
        utils.esperaMilis(3500);
        Serenity.takeScreenshot();
        sigueTusEnviosPage.irAtrasAlHomePage();
    }

    public void validarEnlaceMisPagosEnCasaEntregados() {
        getDriver().findElement(btnEnlaceMisPagosEnCasaEntregados).click();
        utils.esperarURL("pagos");
        misPagosEnCasaEntregadosPage.validarHeaderPagosEnCasaEntregados();
        String uRL = getDriver().getCurrentUrl();
        Assert.assertEquals(uRL, "https://portalautogestionqa.interrapidisimo.com/cuentas/pagos");
        utils.esperaMilis(3500);
        Serenity.takeScreenshot();
    }

    public void validarEnlaceCotizaTuEnvio() {
        getDriver().findElement(btnEnlaceCotizaTuEnvio).click();
        utils.esperaMilis(5000);
        utils.cambioDePestaña(1);
        utils.esperarURL("cotiza-tu-envio/");
        utils.esperaMilis(3000);
        cotizaTuEnvioPage.validarHeaderCotizaTuEnvio();
        String uRL = getDriver().getCurrentUrl();
        Assert.assertEquals(uRL, "https://interrapidisimo.com/cotiza-tu-envio/");
        utils.esperaMilis(3500);
        Serenity.takeScreenshot();
        utils.cerrarPestana();
    }

    public void validarEnlaceEstamosMuyCercaDeTi() {
        getDriver().findElement(btnEnlaceEstamosMuyCercaDeTi).click();
        utils.esperaMilis(3000);
        utils.cambioDePestaña(1);
        utils.esperarURL("SitioOficinaMasCercana/");
        estamosMuyCercaDeTiPage.validarLblLineaNacional();
        String uRL = getDriver().getCurrentUrl();
        Assert.assertEquals(uRL, "https://www3.interrapidisimo.com/SitioOficinaMasCercana/");
        utils.esperaMilis(3500);
        Serenity.takeScreenshot();
        utils.cerrarPestana();
    }

    public void validarEnlaceSolicitaTuRecogida() {
        getDriver().findElement(btnEnlaceSolicitaTuRecogida).click();
        utils.esperaMilis(3000);
        utils.cambioDePestaña(1);
        utils.esperarURL("recogidasencasa.interrapidisimo.com/");
        solicitaTuRecogidaPage.validarLblSolicitaTusRecogidas();
        String uRL = getDriver().getCurrentUrl();
        Assert.assertEquals(uRL, "https://recogidasencasa.interrapidisimo.com/");
        utils.esperaMilis(3500);
        Serenity.takeScreenshot();
        utils.cerrarPestana();
        getDriver().close();
    }

}
