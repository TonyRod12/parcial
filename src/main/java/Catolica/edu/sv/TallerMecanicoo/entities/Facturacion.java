package Catolica.edu.sv.TallerMecanicoo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate; // Para el tipo DATE en Java 8+


@Entity
@Table(name = "Facturacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private Integer idFactura;

    // Relación Many-to-One con Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // <--- AÑADIR AQUÍ
    private Cliente cliente;

    // Relación Many-to-One con Auto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuto", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // <--- AÑADIR AQUÍ
    private Auto auto;

    // Relación Many-to-One con Reparacion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReparacion", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // <--- AÑADIR AQUÍ
    private Reparacion reparacion;

    @Column(name = "TotalAPagar", precision = 10, scale = 2)
    private BigDecimal totalAPagar;

    @Column(name = "FechaEmision")
    private LocalDate fechaEmision;
}