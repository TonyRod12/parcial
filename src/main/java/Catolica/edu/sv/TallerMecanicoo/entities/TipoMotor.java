package Catolica.edu.sv.TallerMecanicoo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "TipoMotor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoMotor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoMotor")
    private Integer idTipoMotor;

    @Column(name = "Tipo", length = 20)
    private String tipo;

    @Column(name = "Cilindrada", precision = 3, scale = 1)
    private BigDecimal cilindrada;

    @Column(name = "Potencia", precision = 6, scale = 2)
    private BigDecimal potencia;

    // Relación One-to-Many con Auto (un TipoMotor puede estar en muchos Autos)
    // Mapeado por el campo 'tipoMotor' en la entidad Auto
    @OneToMany(mappedBy = "tipoMotor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"tipoMotor", "hibernateLazyInitializer", "handler"}) // <--- AÑADIR AQUÍ
    private List<Auto> autos;
}
