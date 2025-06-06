package Catolica.edu.sv.TallerMecanicoo.service;

import Catolica.edu.sv.TallerMecanicoo.entities.Auto;
import java.util.List;
import java.util.Optional;


public interface AutoService {
    List<Auto> getAllAutos();
    Optional<Auto> getAutoById(Integer id);
    Auto createAuto(Auto auto);
    Auto updateAuto(Integer id, Auto auto);
    boolean deleteAuto(Integer id);
}
