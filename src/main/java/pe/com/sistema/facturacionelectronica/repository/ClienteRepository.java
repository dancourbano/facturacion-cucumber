package pe.com.sistema.facturacionelectronica.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.sistema.facturacionelectronica.model.Cliente;

public interface
ClienteRepository extends JpaRepository<Cliente,Integer> {

    @Query("Select c from Cliente c where dnioruc = :dnioruc ")
    Cliente findByDnioruc(String dnioruc);

    Cliente findByRazon(String razon);
}
