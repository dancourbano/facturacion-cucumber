package pe.com.sistema.facturacionelectronica.helper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import pe.com.sistema.facturacionelectronica.model.Account;
import pe.com.sistema.facturacionelectronica.model.Cliente;
import pe.com.sistema.facturacionelectronica.repository.AccountRepository;
import pe.com.sistema.facturacionelectronica.repository.ClienteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteRegistration {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<Cliente> response;
    private Cliente mockCliente;

    @Given("el cliente proporciona detalle de sus datos validos al usuario que registra")
    public void theUserProvidesValidAccountDetails() {
        mockCliente = FeatureUtils.getMockCliente();
    }

    @When("el usuario envia una solicitud POST al path {string}")
    public void theUserSendsAPOSTRequestTo(String path) {
        response = this.restTemplate.postForEntity(FeatureUtils.URL + path, mockCliente, Cliente.class);
    }

    @Then("el status code de la respuesta deberia ser {int}")
    public void theResponseStatusCodeOfAccountRegistrationShouldBe(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }


}
