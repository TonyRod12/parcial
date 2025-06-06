package Catolica.edu.sv.TallerMecanicoo.service;

import Catolica.edu.sv.TallerMecanicoo.entities.Cliente;
import java.util.List;
import java.util.Optional;


public interface ClienteService {
    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(Integer id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Integer id, Cliente cliente);
    boolean deleteCliente(Integer id);
}
