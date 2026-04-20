package mx.uv.jmgs.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uv.jmgs.inventario.entity.Producto;

public interface ProductRepository extends JpaRepository<Producto, Long> {

}