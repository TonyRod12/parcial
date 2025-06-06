package Catolica.edu.sv.TallerMecanicoo.repository;

import Catolica.edu.sv.TallerMecanicoo.entities.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReparacionRepository extends JpaRepository<Reparacion, Integer> {

}
