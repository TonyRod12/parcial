package Catolica.edu.sv.TallerMecanicoo.repository;

import Catolica.edu.sv.TallerMecanicoo.entities.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

}