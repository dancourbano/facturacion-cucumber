package pe.com.sistema.facturacionelectronica.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistema.facturacionelectronica.model.Cliente;
import pe.com.sistema.facturacionelectronica.repository.ClienteRepository;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Set<Cliente> listarCliente() {
        return new LinkedHashSet<>(clienteRepository.findAll());
    }

    public Cliente listaclientesxDnioruc(String dnioruc) {
        return clienteRepository.findByDnioruc(dnioruc);
    }

    public Cliente getClientexId(String id) {
        return clienteRepository.findById(Integer.parseInt(id)).get();
    }

    public Cliente listaclientesxRazon(String razon) {
        return clienteRepository.findByRazon(razon);
    }

    public void eliminarCliente(Integer indice) {
        Cliente cli = new Cliente();
        cli.setIndice(indice);
        clienteRepository.delete(cli);

    }
}
