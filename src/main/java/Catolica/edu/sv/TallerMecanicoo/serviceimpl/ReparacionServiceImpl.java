package Catolica.edu.sv.TallerMecanicoo.serviceimpl;

import Catolica.edu.sv.TallerMecanicoo.entities.Reparacion;
import Catolica.edu.sv.TallerMecanicoo.repository.ReparacionRepository;
import Catolica.edu.sv.TallerMecanicoo.service.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReparacionServiceImpl implements ReparacionService {

    private final ReparacionRepository reparacionRepository;

    @Autowired
    public ReparacionServiceImpl(ReparacionRepository reparacionRepository) {
        this.reparacionRepository = reparacionRepository;
    }

    @Override
    public List<Reparacion> getAllReparaciones() {
        return reparacionRepository.findAll();
    }

    @Override
    public Optional<Reparacion> getReparacionById(Integer id) {
        return reparacionRepository.findById(id);
    }

    @Override
    public Reparacion createReparacion(Reparacion reparacion) {
        return reparacionRepository.save(reparacion);
    }

    @Override
    public Reparacion updateReparacion(Integer id, Reparacion updatedReparacion) {
        return reparacionRepository.findById(id).map(reparacion -> {
            reparacion.setDescripcion(updatedReparacion.getDescripcion());
            reparacion.setCostoEstimado(updatedReparacion.getCostoEstimado());
            reparacion.setMecanicoAsignado(updatedReparacion.getMecanicoAsignado());
            reparacion.setTiempoEstimado(updatedReparacion.getTiempoEstimado());
            return reparacionRepository.save(reparacion);
        }).orElse(null);
    }

    @Override
    public boolean deleteReparacion(Integer id) {
        if (reparacionRepository.existsById(id)) {
            reparacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
