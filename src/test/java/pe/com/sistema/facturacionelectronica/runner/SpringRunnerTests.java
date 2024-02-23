package pe.com.sistema.facturacionelectronica.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", tags = "", glue = "pe.com.sistema.facturacionelectronica.helper", publish = true)

public class SpringRunnerTests {

}