package Catolica.edu.sv.TallerMecanicoo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "Auto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAuto")
    private Integer idAuto;

    @Column(name = "Año")
    private Integer año;

    @Column(name = "Marca", length = 50)
    private String marca;

    @Column(name = "Modelo", length = 50)
    private String modelo;

    @Column(name = "NumeroSerie", length = 100, unique = true)
    private String numeroSerie;

    // Relación Many-to-One con TipoMotor (un Auto tiene un TipoMotor)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoMotor", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // <--- AÑADIR AQUÍ
    private TipoMotor tipoMotor;

    // Relación Many-to-One con Cliente (un Auto pertenece a un Cliente)
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idCliente", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // <--- AÑADIR AQUÍ
    private Cliente cliente;
}