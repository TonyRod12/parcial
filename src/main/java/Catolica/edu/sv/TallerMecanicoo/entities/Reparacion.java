package Catolica.edu.sv.TallerMecanicoo.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "Reparacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReparacion")
    private Integer idReparacion;

    @Column(name = "Descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "CostoEstimado", precision = 10, scale = 2)
    private BigDecimal costoEstimado;

    @Column(name = "MecanicoAsignado", length = 100)
    private String mecanicoAsignado;

    @Column(name = "TiempoEstimado", precision = 5, scale = 2)
    private BigDecimal tiempoEstimado;
}
