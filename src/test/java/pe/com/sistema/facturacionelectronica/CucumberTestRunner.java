package pe.com.sistema.facturacionelectronica;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "pe.com.sistema.facturacionelectronica.helper")
public class CucumberTestRunner {

}