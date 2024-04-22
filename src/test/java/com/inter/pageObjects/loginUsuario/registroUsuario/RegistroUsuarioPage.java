package com.inter.pageObjects.loginUsuario.registroUsuario;

import org.openqa.selenium.By;
import com.inter.pageObjects.loginUsuario.inicioSesion.IniciarSesionPage;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class RegistroUsuarioPage extends PageObject {

    // Validar header pagina registro
    public By headerRegistrate = By.xpath("//app-registro/div/app-registro1/div/div[1]/h1");
    // Formulario Registro de usuario
    public By inputNumCeloCorreo = By.xpath("//app-registro/div/app-registro1/div/form/div[1]/div/input");
    public By inputContrasena = By.xpath("//app-registro/div/app-registro1/div/form/div[2]/div/input");
    public By inputConfirmarContrasena = By.xpath("//app-registro/div/app-registro1/div/form/div[4]/div/input");
    public By btnContinuar = By.xpath("//app-registro/div/app-registro1/div/form/div[5]/button");
    // Registro con redes sociales
    public By btnRegFacebook = By.xpath("//app-registro1/div/div[2]/div/app-redes-sociales/button[1]");
    public By btnRegGoogle = By.xpath("//app-registro1/div/div[2]/div/app-redes-sociales/button[2]");

    Utils utils = new Utils();
    IniciarSesionPage iniciarSesionPage = new IniciarSesionPage();
    DatosPersonalesPage datosPersonalesPage = new DatosPersonalesPage();

    public void registroDeUsuario(String dataRegistroUsuario) {
        CSVReader csvReader = utils.dataCsv(dataRegistroUsuario);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        iniciarSesionPage.validarHeaderBienvenido();
                        iniciarSesionPage.enlaceRegistrate();
                        utils.getAssertLocalizador(headerRegistrate, "Regístrate con nosotros");
                        getDriver().findElement(inputNumCeloCorreo).sendKeys(list[0]);
                        getDriver().findElement(inputContrasena).sendKeys(list[1]);
                        getDriver().findElement(inputConfirmarContrasena).sendKeys(list[1]);
                        Serenity.takeScreenshot();
                        getDriver().findElement(btnContinuar).click();
                        datosPersonalesPage.registroDatosPersonalesUsuario(dataRegistroUsuario);
                    } catch (Exception e) {
                        System.out.println(
                                "Error al registrar usuario ***\n" + e);
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
