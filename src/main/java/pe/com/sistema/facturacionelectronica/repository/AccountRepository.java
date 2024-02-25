package pe.com.sistema.facturacionelectronica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.sistema.facturacionelectronica.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}