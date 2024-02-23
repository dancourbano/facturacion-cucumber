package pe.com.sistema.facturacionelectronica.helper;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AbstractRestAssuredHelper {
    private final static String BASE_URI = "http://localhost";

    @LocalServerPort
    private int port;

    protected void configureRestAssured() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;

    }

    protected RequestSpecification getAnonymousRequest() {
        configureRestAssured();
        return SerenityRest.given();
    }
}