package Catolica.edu.sv.TallerMecanicoo.repository;

import Catolica.edu.sv.TallerMecanicoo.entities.Facturacion;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Integer> {

}