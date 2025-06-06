package Catolica.edu.sv.TallerMecanicoo.serviceimpl;

import Catolica.edu.sv.TallerMecanicoo.entities.Cliente;
import Catolica.edu.sv.TallerMecanicoo.repository.ClienteRepository;
import Catolica.edu.sv.TallerMecanicoo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        // Aquí podrías añadir validaciones adicionales, por ejemplo, si el correo ya existe
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente updatedCliente) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre(updatedCliente.getNombre());
            cliente.setTelefono(updatedCliente.getTelefono());
            cliente.setDireccion(updatedCliente.getDireccion());
            cliente.setCorreoElectronico(updatedCliente.getCorreoElectronico());
            return clienteRepository.save(cliente);
        }).orElse(null);
    }

    @Override
    public boolean deleteCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
