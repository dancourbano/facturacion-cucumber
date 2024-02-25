package pe.com.sistema.facturacionelectronica.helper;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import pe.com.sistema.facturacionelectronica.FacturacionelectronicaApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = FacturacionelectronicaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberConfiguration {

}
