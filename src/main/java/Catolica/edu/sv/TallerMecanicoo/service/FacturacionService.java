package Catolica.edu.sv.TallerMecanicoo.service;

import Catolica.edu.sv.TallerMecanicoo.entities.Facturacion;
import java.util.List;
import java.util.Optional;


public interface FacturacionService {
    List<Facturacion> getAllFacturaciones();
    Optional<Facturacion> getFacturacionById(Integer id);
    Facturacion createFacturacion(Facturacion facturacion);
    Facturacion updateFacturacion(Integer id, Facturacion facturacion);
    boolean deleteFacturacion(Integer id);
}
