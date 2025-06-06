package Catolica.edu.sv.TallerMecanicoo.serviceimpl;

import Catolica.edu.sv.TallerMecanicoo.entities.Falla;
import Catolica.edu.sv.TallerMecanicoo.repository.FallaRepository;
import Catolica.edu.sv.TallerMecanicoo.service.FallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FallaServiceImpl implements FallaService {

    private final FallaRepository fallaRepository;

    @Autowired
    public FallaServiceImpl(FallaRepository fallaRepository) {
        this.fallaRepository = fallaRepository;
    }

    @Override
    public List<Falla> getAllFallas() {
        return fallaRepository.findAll();
    }

    @Override
    public Optional<Falla> getFallaById(Integer id) {
        return fallaRepository.findById(id);
    }

    @Override
    public Falla createFalla(Falla falla) {
        return fallaRepository.save(falla);
    }

    @Override
    public Falla updateFalla(Integer id, Falla updatedFalla) {
        return fallaRepository.findById(id).map(falla -> {
            falla.setDescripcion(updatedFalla.getDescripcion());
            falla.setNivelGravedad(updatedFalla.getNivelGravedad());
            falla.setCodigoDiagnostico(updatedFalla.getCodigoDiagnostico());
            return fallaRepository.save(falla);
        }).orElse(null);
    }

    @Override
    public boolean deleteFalla(Integer id) {
        if (fallaRepository.existsById(id)) {
            fallaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
