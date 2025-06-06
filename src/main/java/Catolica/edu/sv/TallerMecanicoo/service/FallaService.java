package Catolica.edu.sv.TallerMecanicoo.service;

import Catolica.edu.sv.TallerMecanicoo.entities.Falla;
import java.util.List;
import java.util.Optional;


public interface FallaService {
    List<Falla> getAllFallas();
    Optional<Falla> getFallaById(Integer id);
    Falla createFalla(Falla falla);
    Falla updateFalla(Integer id, Falla falla);
    boolean deleteFalla(Integer id);
}
