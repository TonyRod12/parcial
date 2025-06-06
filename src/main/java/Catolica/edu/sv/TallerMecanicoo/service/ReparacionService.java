package Catolica.edu.sv.TallerMecanicoo.service;

import Catolica.edu.sv.TallerMecanicoo.entities.Reparacion;
import java.util.List;
import java.util.Optional;


public interface ReparacionService {
    List<Reparacion> getAllReparaciones();
    Optional<Reparacion> getReparacionById(Integer id);
    Reparacion createReparacion(Reparacion reparacion);
    Reparacion updateReparacion(Integer id, Reparacion reparacion);
    boolean deleteReparacion(Integer id);
}
