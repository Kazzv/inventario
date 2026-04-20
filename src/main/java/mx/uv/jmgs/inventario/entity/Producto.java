package mx.uv.jmgs.inventario.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(length = 255)
    private String descripcion;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Integer stock;
    private String categoria;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
