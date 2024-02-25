package pe.com.sistema.facturacionelectronica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistema.facturacionelectronica.model.Account;
import pe.com.sistema.facturacionelectronica.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Long saveAccount(Account account) {
        return accountRepository.save(account).getId();
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}