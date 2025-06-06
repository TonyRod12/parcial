package Catolica.edu.sv.TallerMecanicoo.controller;

import Catolica.edu.sv.TallerMecanicoo.entities.Facturacion;
import Catolica.edu.sv.TallerMecanicoo.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {

    private final FacturacionService facturacionService;

    @Autowired
    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }


    @GetMapping
    public ResponseEntity<List<Facturacion>> getAllFacturaciones() {
        List<Facturacion> facturaciones = facturacionService.getAllFacturaciones();
        return new ResponseEntity<>(facturaciones, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Facturacion> getFacturacionById(@PathVariable Integer id) {
        return facturacionService.getFacturacionById(id)
                .map(facturacion -> new ResponseEntity<>(facturacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<?> createFacturacion(@RequestBody Facturacion facturacion) {
        try {
            Facturacion savedFacturacion = facturacionService.createFacturacion(facturacion);
            return new ResponseEntity<>(savedFacturacion, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateFacturacion(@PathVariable Integer id, @RequestBody Facturacion facturacion) {
        try {
            Facturacion updated = facturacionService.updateFacturacion(id, facturacion);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturacion(@PathVariable Integer id) {
        if (facturacionService.deleteFacturacion(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
