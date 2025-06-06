package Catolica.edu.sv.TallerMecanicoo.serviceimpl;

import Catolica.edu.sv.TallerMecanicoo.entities.TipoMotor;
import Catolica.edu.sv.TallerMecanicoo.repository.TipoMotorRepository;
import Catolica.edu.sv.TallerMecanicoo.service.TipoMotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TipoMotorServiceImpl implements TipoMotorService {

    private final TipoMotorRepository tipoMotorRepository;


    @Autowired
    public TipoMotorServiceImpl(TipoMotorRepository tipoMotorRepository) {
        this.tipoMotorRepository = tipoMotorRepository;
    }


    @Override
    public List<TipoMotor> getAllTiposMotor() {
        return tipoMotorRepository.findAll();
    }


    @Override
    public Optional<TipoMotor> getTipoMotorById(Integer id) {
        return tipoMotorRepository.findById(id);
    }


    @Override
    public TipoMotor createTipoMotor(TipoMotor tipoMotor) {
        return tipoMotorRepository.save(tipoMotor);
    }


    @Override
    public TipoMotor updateTipoMotor(Integer id, TipoMotor updatedTipoMotor) {
        return tipoMotorRepository.findById(id).map(tipoMotor -> {
            tipoMotor.setTipo(updatedTipoMotor.getTipo());
            tipoMotor.setCilindrada(updatedTipoMotor.getCilindrada());
            tipoMotor.setPotencia(updatedTipoMotor.getPotencia());
            return tipoMotorRepository.save(tipoMotor);
        }).orElse(null);
    }


    @Override
    public boolean deleteTipoMotor(Integer id) {
        if (tipoMotorRepository.existsById(id)) {
            tipoMotorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
