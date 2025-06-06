package Catolica.edu.sv.TallerMecanicoo.repository;

import Catolica.edu.sv.TallerMecanicoo.entities.TipoMotor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoMotorRepository extends JpaRepository<TipoMotor, Integer> {

}

