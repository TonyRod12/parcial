package Catolica.edu.sv.TallerMecanicoo.service;

import Catolica.edu.sv.TallerMecanicoo.entities.TipoMotor;
import java.util.List;
import java.util.Optional;


public interface TipoMotorService {
    List<TipoMotor> getAllTiposMotor();
    Optional<TipoMotor> getTipoMotorById(Integer id);
    TipoMotor createTipoMotor(TipoMotor tipoMotor);
    TipoMotor updateTipoMotor(Integer id, TipoMotor tipoMotor);
    boolean deleteTipoMotor(Integer id);
}
