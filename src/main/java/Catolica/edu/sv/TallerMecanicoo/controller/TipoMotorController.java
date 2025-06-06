package Catolica.edu.sv.TallerMecanicoo.controller;

import Catolica.edu.sv.TallerMecanicoo.entities.TipoMotor;
import Catolica.edu.sv.TallerMecanicoo.service.TipoMotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/tiposmotor") // Define la ruta base para todos los endpoints de este controlador
public class TipoMotorController {

    private final TipoMotorService tipoMotorService;

    // Inyección de dependencia del servicio de TipoMotor
    @Autowired
    public TipoMotorController(TipoMotorService tipoMotorService) {
        this.tipoMotorService = tipoMotorService;
    }


    @GetMapping
    public ResponseEntity<List<TipoMotor>> getAllTiposMotor() {
        List<TipoMotor> tiposMotor = tipoMotorService.getAllTiposMotor();
        return new ResponseEntity<>(tiposMotor, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoMotor> getTipoMotorById(@PathVariable Integer id) {
        return tipoMotorService.getTipoMotorById(id)
                .map(tipoMotor -> new ResponseEntity<>(tipoMotor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<TipoMotor> createTipoMotor(@RequestBody TipoMotor tipoMotor) {
        TipoMotor savedTipoMotor = tipoMotorService.createTipoMotor(tipoMotor);
        return new ResponseEntity<>(savedTipoMotor, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TipoMotor> updateTipoMotor(@PathVariable Integer id, @RequestBody TipoMotor tipoMotor) {
        TipoMotor updated = tipoMotorService.updateTipoMotor(id, tipoMotor);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoMotor(@PathVariable Integer id) {
        if (tipoMotorService.deleteTipoMotor(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}