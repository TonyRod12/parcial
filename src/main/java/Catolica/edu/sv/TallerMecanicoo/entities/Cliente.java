package Catolica.edu.sv.TallerMecanicoo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "Nombre", length = 255)
    private String nombre;

    @Column(name = "Telefono", length = 20, unique = true)
    private String telefono;

    @Column(name = "Direccion", length = 255)
    private String direccion;

    @Column(name = "CorreoElectronico", length = 255, unique = true)
    private String correoElectronico;

    // Relación One-to-Many con Auto (un Cliente puede tener muchos Autos)
    // Mapeado por el campo 'cliente' en la entidad Auto
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"cliente", "hibernateLazyInitializer", "handler"}) // <--- AÑADIR AQUÍ
    private List<Auto> autos;
}