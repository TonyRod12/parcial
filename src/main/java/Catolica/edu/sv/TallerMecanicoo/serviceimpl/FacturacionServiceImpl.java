package Catolica.edu.sv.TallerMecanicoo.serviceimpl;

import Catolica.edu.sv.TallerMecanicoo.entities.Facturacion;
import Catolica.edu.sv.TallerMecanicoo.repository.FacturacionRepository;
import Catolica.edu.sv.TallerMecanicoo.repository.ClienteRepository;
import Catolica.edu.sv.TallerMecanicoo.repository.AutoRepository;
import Catolica.edu.sv.TallerMecanicoo.repository.ReparacionRepository;
import Catolica.edu.sv.TallerMecanicoo.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FacturacionServiceImpl implements FacturacionService {

    private final FacturacionRepository facturacionRepository;
    private final ClienteRepository clienteRepository;     // Necesario para validar idCliente
    private final AutoRepository autoRepository;           // Necesario para validar idAuto
    private final ReparacionRepository reparacionRepository; // Necesario para validar idReparacion

    @Autowired
    public FacturacionServiceImpl(FacturacionRepository facturacionRepository,
                                  ClienteRepository clienteRepository,
                                  AutoRepository autoRepository,
                                  ReparacionRepository reparacionRepository) {
        this.facturacionRepository = facturacionRepository;
        this.clienteRepository = clienteRepository;
        this.autoRepository = autoRepository;
        this.reparacionRepository = reparacionRepository;
    }

    @Override
    public List<Facturacion> getAllFacturaciones() {
        return facturacionRepository.findAll();
    }

    @Override
    public Optional<Facturacion> getFacturacionById(Integer id) {
        return facturacionRepository.findById(id);
    }

    @Override
    public Facturacion createFacturacion(Facturacion facturacion) {
        // Validar que Cliente exista
        if (facturacion.getCliente() == null || !clienteRepository.existsById(facturacion.getCliente().getIdCliente())) {
            throw new IllegalArgumentException("Cliente no válido o no existe.");
        }
        // Validar que Auto exista
        if (facturacion.getAuto() == null || !autoRepository.existsById(facturacion.getAuto().getIdAuto())) {
            throw new IllegalArgumentException("Auto no válido o no existe.");
        }
        // Validar que Reparacion exista
        if (facturacion.getReparacion() == null || !reparacionRepository.existsById(facturacion.getReparacion().getIdReparacion())) {
            throw new IllegalArgumentException("Reparación no válida o no existe.");
        }
        return facturacionRepository.save(facturacion);
    }

    @Override
    public Facturacion updateFacturacion(Integer id, Facturacion updatedFacturacion) {
        return facturacionRepository.findById(id).map(facturacion -> {
            // Validar y actualizar Cliente si se proporciona y existe
            if (updatedFacturacion.getCliente() != null) {
                if (!clienteRepository.existsById(updatedFacturacion.getCliente().getIdCliente())) {
                    throw new IllegalArgumentException("Cliente no válido o no existe para la actualización.");
                }
                facturacion.setCliente(updatedFacturacion.getCliente());
            }

            // Validar y actualizar Auto si se proporciona y existe
            if (updatedFacturacion.getAuto() != null) {
                if (!autoRepository.existsById(updatedFacturacion.getAuto().getIdAuto())) {
                    throw new IllegalArgumentException("Auto no válido o no existe para la actualización.");
                }
                facturacion.setAuto(updatedFacturacion.getAuto());
            }

            // Validar y actualizar Reparacion si se proporciona y existe
            if (updatedFacturacion.getReparacion() != null) {
                if (!reparacionRepository.existsById(updatedFacturacion.getReparacion().getIdReparacion())) {
                    throw new IllegalArgumentException("Reparación no válida o no existe para la actualización.");
                }
                facturacion.setReparacion(updatedFacturacion.getReparacion());
            }

            facturacion.setTotalAPagar(updatedFacturacion.getTotalAPagar());
            facturacion.setFechaEmision(updatedFacturacion.getFechaEmision());

            return facturacionRepository.save(facturacion);
        }).orElse(null);
    }

    @Override
    public boolean deleteFacturacion(Integer id) {
        if (facturacionRepository.existsById(id)) {
            facturacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}