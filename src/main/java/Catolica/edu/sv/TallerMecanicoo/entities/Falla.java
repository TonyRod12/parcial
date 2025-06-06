package Catolica.edu.sv.TallerMecanicoo.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "Falla")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Falla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFalla")
    private Integer idFalla;

    @Column(name = "Descripcion", columnDefinition = "TEXT") // Mapea a tipo TEXT en la DB
    private String descripcion;

    @Column(name = "NivelGravedad")
    private Integer nivelGravedad;

    @Column(name = "CodigoDiagnostico", length = 50)
    private String codigoDiagnostico;
}
