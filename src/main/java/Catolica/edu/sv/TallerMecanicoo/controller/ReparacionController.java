package Catolica.edu.sv.TallerMecanicoo.controller;

import Catolica.edu.sv.TallerMecanicoo.entities.Reparacion;
import Catolica.edu.sv.TallerMecanicoo.service.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/reparaciones")
public class ReparacionController {

    private final ReparacionService reparacionService;

    @Autowired
    public ReparacionController(ReparacionService reparacionService) {
        this.reparacionService = reparacionService;
    }


    @GetMapping
    public ResponseEntity<List<Reparacion>> getAllReparaciones() {
        List<Reparacion> reparaciones = reparacionService.getAllReparaciones();
        return new ResponseEntity<>(reparaciones, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reparacion> getReparacionById(@PathVariable Integer id) {
        return reparacionService.getReparacionById(id)
                .map(reparacion -> new ResponseEntity<>(reparacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Reparacion> createReparacion(@RequestBody Reparacion reparacion) {
        Reparacion savedReparacion = reparacionService.createReparacion(reparacion);
        return new ResponseEntity<>(savedReparacion, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Reparacion> updateReparacion(@PathVariable Integer id, @RequestBody Reparacion reparacion) {
        Reparacion updated = reparacionService.updateReparacion(id, reparacion);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReparacion(@PathVariable Integer id) {
        if (reparacionService.deleteReparacion(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
