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

public class getCliente {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<Cliente> response;
    private Cliente mockCliente;

    @Given("un cliente registrado con el indice {long}")
    public void anExistingAccountWithID(long indice) {
        // use the mock account saved
        this.mockCliente = FeatureUtils.getMockCliente();
        this.clienteRepository.save(this.mockCliente);
    }

    @When("el usuario envia una solicitud GET a {string}")
    public void theUserSendsAGETRequestTo(String path) {
        String url = String.format("%s/%s/%d", FeatureUtils.URL, path, mockCliente.getIndice());
        response = this.restTemplate.getForEntity(url, Cliente.class);
    }

    @Then("el code status de la respuesta debe ser {int}")
    public void theResponseStatusCodeOfGettingAnAccountShouldBe(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("el cuerpo de la respuesta debe contener los detalles del cliente")
    public void theResponseBodyShouldContainTheAccountDetails() {
        Cliente resCliente = response.getBody();
        assert resCliente != null;
        assertEquals(mockCliente.getIndice(), resCliente.getIndice());
        assertEquals(mockCliente.getRazon(), resCliente.getRazon());
        assertEquals(mockCliente.getDireccion(), resCliente.getDireccion());
        assertEquals(mockCliente.getDnioruc(), resCliente.getDnioruc());
        assertEquals(mockCliente.getEmail(), resCliente.getEmail());
        assertEquals(mockCliente.getCelular(), resCliente.getCelular());
        assertEquals(mockCliente.getTipodoc(), resCliente.getTipodoc());


    }
}
