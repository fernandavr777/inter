package com.inter.pageObjects.loginUsuario.registroUsuario;

import org.openqa.selenium.By;
import com.inter.utils.Utils;
import com.opencsv.CSVReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class DatosPersonalesPage extends PageObject {

        // Validar header datos personales
        public By headerDatosPersonales = By.xpath("//app-datos-personales/div/app-registro2/div/form/p");
        // Fomulario registro datos personales
        public By selectTipoDocumento = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[1]/div/div/select");
        public By inputNumDocumento = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[1]/div[1]/div/input");
        public By inputConfirmarNumDoc = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[1]/div[2]/div/input");
        public By inputPrimerNombre = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[2]/div[1]/div/input");
        public By inputSegundoNombre = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[2]/div[2]/div/input");
        public By inputPrimerApellido = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[3]/div[1]/div/input");
        public By inputSegundoApellido = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[3]/div[2]/div/input");
        public By inputNumCelular = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[4]/div[1]/div/input");
        public By inputFechaNacimiento = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[3]/div[4]/div[2]/div/input");
        public By inputBlockValidarCorreo = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[4]/div/div/input");
        public By selectCiudad = By.xpath("//app-datos-personales/div/app-registro2/div/form/div[5]/div/div/select");
        public By inputDireccion = By.xpath("//app-datos-personales/div/app-registro2/div/form/div[6]/div/div/input");
        public By iFrameRecaptcha = By.xpath("//*[@id=\"ngx_captcha_id_5322\"]/div/div/iframe");
        public By checkBoxCaptcha = By.xpath("//*[@id='recaptcha-anchor']/div[1]");
        public By checkBoxTratamientoDatos = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[7]/div[2]/div[1]/div/input");
        public By checkBoxTyC = By
                        .xpath("//app-datos-personales/div/app-registro2/div/form/div[7]/div[2]/div[2]/div/input");
        public By btnFinalizar = By.xpath("//app-datos-personales/div/app-registro2/div/form/div[8]/button");

        Utils utils = new Utils();

        public void registroDatosPersonalesUsuario(String dataRegistroUsuario) {
                CSVReader csvReader = utils.dataCsv(dataRegistroUsuario);
                String[] list = null;
                Integer contador = 0;
                try {
                        while ((list = csvReader.readNext()) != null) {
                                if (contador >= 1) {
                                        try {
                                                utils.esperarElementoVisible(headerDatosPersonales);
                                                utils.getAssertLocalizador(headerDatosPersonales, "Datos personales");
                                                utils.seleccionarListaTextoVisible(selectTipoDocumento, list[2]);
                                                getDriver().findElement(inputNumDocumento).sendKeys(list[3]);
                                                getDriver().findElement(inputConfirmarNumDoc).sendKeys(list[3]);
                                                getDriver().findElement(inputPrimerNombre).sendKeys(list[4]);
                                                getDriver().findElement(inputSegundoNombre).sendKeys(list[5]);
                                                getDriver().findElement(inputPrimerApellido).sendKeys(list[6]);
                                                getDriver().findElement(inputSegundoApellido).sendKeys(list[7]);
                                                getDriver().findElement(inputNumCelular).sendKeys(list[8]);
                                                Serenity.takeScreenshot();
                                                getDriver().findElement(inputFechaNacimiento).sendKeys(list[9]);
                                                getDriver().findElement(inputBlockValidarCorreo).click();
                                                utils.seleccionarListaTextoVisible(selectCiudad, list[10]);
                                                getDriver().findElement(inputDireccion).sendKeys(list[11]);
                                                utils.esperaMilis(2000);
                                                utils.scrollPagina("600");
                                                getDriver().switchTo()
                                                                .frame(getDriver().findElement(By.tagName("iframe")));
                                                getDriver().findElement(checkBoxCaptcha).click();
                                                getDriver().findElement(checkBoxTratamientoDatos).click();
                                                getDriver().findElement(checkBoxTyC).click();
                                                Serenity.takeScreenshot();
                                                getDriver().findElement(btnFinalizar).click();
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
