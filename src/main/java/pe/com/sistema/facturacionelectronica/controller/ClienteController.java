package pe.com.sistema.facturacionelectronica.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.sistema.facturacionelectronica.model.Cliente;
import pe.com.sistema.facturacionelectronica.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
        Cliente clienteG = clienteService.guardarCliente(cliente);
        return  ResponseEntity.ok(clienteG);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarClientes(){
        return ResponseEntity.ok(clienteService.listarCliente());
    }

    @GetMapping("/{dnioruc}")
    public Cliente listaClientexDnioruc(@PathVariable("dnioruc") String dnioruc){
        return clienteService.listaclientesxDnioruc(dnioruc);

    }

    @GetMapping("/indice/{indice}")
    public Cliente listaClientexId(@PathVariable("indice") String indice){
        return clienteService.getClientexId(indice);
    }

    @GetMapping("/razon/{razon}")
    public Cliente listaClientexRazon(@PathVariable("razon") String razon){
        return clienteService.listaclientesxRazon(razon);
    }

    @PutMapping("/")
    public Cliente actualizarCliente(@RequestBody Cliente cliente){
        return clienteService.actualizarCliente(cliente);
    }

    @DeleteMapping("/{indice}")
    public void eliminarCliente(@PathVariable("indice")Integer indice ){
        clienteService.eliminarCliente(indice);
    }


}
