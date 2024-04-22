package com.inter.acceptancetests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "com.inter", snippets = SnippetType.CAMELCASE
, tags = ("@Eliminar_cuenta_bancaria_inscrita")
)
public class RunnerPortalClientesTest {

}
