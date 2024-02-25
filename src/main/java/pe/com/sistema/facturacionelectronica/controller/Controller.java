package pe.com.sistema.facturacionelectronica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.sistema.facturacionelectronica.model.Account;
import pe.com.sistema.facturacionelectronica.service.AccountService;

import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private AccountService accountService;

    @Value(value = "${app.version}")
    private String APPLICATION_VERSION;

    @GetMapping("/version")
    public String getVersion() {
        return Optional.ofNullable(APPLICATION_VERSION).orElse("N/A");
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

}
