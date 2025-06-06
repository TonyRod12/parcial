package Catolica.edu.sv.TallerMecanicoo.repository;

import Catolica.edu.sv.TallerMecanicoo.entities.Falla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FallaRepository extends JpaRepository<Falla, Integer> {

}
