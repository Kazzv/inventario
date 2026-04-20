package mx.uv.jmgs.inventario.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.uv.jmgs.inventario.entity.Producto;
import mx.uv.jmgs.inventario.service.ProductService;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
   private final ProductService service;


    // GET /api/productos
    @GetMapping
    public List<Producto> listarProductos() {
       return service.listarTodos();
   }

   @GetMapping("/{id}")
   public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
       return service.buscarPorId(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
   }

   @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
         Producto gaurdado = service.guardar(producto);
         return ResponseEntity.status(HttpStatus.CREATED).body(gaurdado);
    }
    
    // PUT /api/productos
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        Producto actualizado = service.guardar(producto);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE /api/productos
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}