package Catolica.edu.sv.TallerMecanicoo.serviceimpl;

import Catolica.edu.sv.TallerMecanicoo.entities.Auto;
import Catolica.edu.sv.TallerMecanicoo.repository.AutoRepository;
import Catolica.edu.sv.TallerMecanicoo.repository.ClienteRepository;
import Catolica.edu.sv.TallerMecanicoo.repository.TipoMotorRepository;
import Catolica.edu.sv.TallerMecanicoo.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;
    private final TipoMotorRepository tipoMotorRepository; // Necesario para validar idTipoMotor
    private final ClienteRepository clienteRepository;     // Necesario para validar idCliente

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository, TipoMotorRepository tipoMotorRepository, ClienteRepository clienteRepository) {
        this.autoRepository = autoRepository;
        this.tipoMotorRepository = tipoMotorRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Auto> getAllAutos() {
        return autoRepository.findAll();
    }

    @Override
    public Optional<Auto> getAutoById(Integer id) {
        return autoRepository.findById(id);
    }

    @Override
    public Auto createAuto(Auto auto) {
        // Validar que TipoMotor exista
        if (auto.getTipoMotor() == null || !tipoMotorRepository.existsById(auto.getTipoMotor().getIdTipoMotor())) {
            throw new IllegalArgumentException("TipoMotor no válido o no existe.");
        }
        // Validar que Cliente exista (si no es nulo, ya que idCliente puede ser NULL en la DB)
        if (auto.getCliente() != null && !clienteRepository.existsById(auto.getCliente().getIdCliente())) {
            throw new IllegalArgumentException("Cliente no válido o no existe.");
        }
        return autoRepository.save(auto);
    }

    @Override
    public Auto updateAuto(Integer id, Auto updatedAuto) {
        return autoRepository.findById(id).map(auto -> {
            auto.setAño(updatedAuto.getAño());
            auto.setMarca(updatedAuto.getMarca());
            auto.setModelo(updatedAuto.getModelo());
            auto.setNumeroSerie(updatedAuto.getNumeroSerie());

            // Validar y actualizar TipoMotor si se proporciona y existe
            if (updatedAuto.getTipoMotor() != null) {
                if (!tipoMotorRepository.existsById(updatedAuto.getTipoMotor().getIdTipoMotor())) {
                    throw new IllegalArgumentException("TipoMotor no válido o no existe para la actualización.");
                }
                auto.setTipoMotor(updatedAuto.getTipoMotor());
            }

            // Validar y actualizar Cliente si se proporciona y existe (o si se establece a null)
            if (updatedAuto.getCliente() != null) {
                if (!clienteRepository.existsById(updatedAuto.getCliente().getIdCliente())) {
                    throw new IllegalArgumentException("Cliente no válido o no existe para la actualización.");
                }
                auto.setCliente(updatedAuto.getCliente());
            } else {
                // Si el cliente en updatedAuto es null, también se puede establecer a null en la entidad
                auto.setCliente(null);
            }

            return autoRepository.save(auto);
        }).orElse(null);
    }

    @Override
    public boolean deleteAuto(Integer id) {
        if (autoRepository.existsById(id)) {
            autoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
