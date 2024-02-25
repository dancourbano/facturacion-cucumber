package pe.com.sistema.facturacionelectronica.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pe.com.sistema.facturacionelectronica.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import pe.com.sistema.facturacionelectronica.model.Cliente;

import java.io.IOException;

public class FeatureUtils {
    public static String URL = "http://localhost:9001";
    public static Account getMockAccount() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("Account.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Account.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Cliente getMockCliente() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("Cliente.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Cliente.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}