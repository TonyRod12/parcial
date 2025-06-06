package Catolica.edu.sv.TallerMecanicoo.controller;

import Catolica.edu.sv.TallerMecanicoo.entities.Auto;
import Catolica.edu.sv.TallerMecanicoo.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/autos")
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }


    @GetMapping
    public ResponseEntity<List<Auto>> getAllAutos() {
        List<Auto> autos = autoService.getAllAutos();
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable Integer id) {
        return autoService.getAutoById(id)
                .map(auto -> new ResponseEntity<>(auto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<?> createAuto(@RequestBody Auto auto) {
        try {
            Auto savedAuto = autoService.createAuto(auto);
            return new ResponseEntity<>(savedAuto, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuto(@PathVariable Integer id, @RequestBody Auto auto) {
        try {
            Auto updated = autoService.updateAuto(id, auto);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable Integer id) {
        if (autoService.deleteAuto(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
