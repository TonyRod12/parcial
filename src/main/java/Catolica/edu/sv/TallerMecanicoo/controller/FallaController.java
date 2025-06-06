package Catolica.edu.sv.TallerMecanicoo.controller;

import Catolica.edu.sv.TallerMecanicoo.entities.Falla;
import Catolica.edu.sv.TallerMecanicoo.service.FallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/fallas")
public class FallaController {

    private final FallaService fallaService;

    @Autowired
    public FallaController(FallaService fallaService) {
        this.fallaService = fallaService;
    }


    @GetMapping
    public ResponseEntity<List<Falla>> getAllFallas() {
        List<Falla> fallas = fallaService.getAllFallas();
        return new ResponseEntity<>(fallas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Falla> getFallaById(@PathVariable Integer id) {
        return fallaService.getFallaById(id)
                .map(falla -> new ResponseEntity<>(falla, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Falla> createFalla(@RequestBody Falla falla) {
        Falla savedFalla = fallaService.createFalla(falla);
        return new ResponseEntity<>(savedFalla, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Falla> updateFalla(@PathVariable Integer id, @RequestBody Falla falla) {
        Falla updated = fallaService.updateFalla(id, falla);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFalla(@PathVariable Integer id) {
        if (fallaService.deleteFalla(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
