package mx.uv.jmgs.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mx.uv.jmgs.inventario.entity.Producto;
import mx.uv.jmgs.inventario.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Optional <Producto> buscarPorId(Long id) {
        return repository.findById(id);
    }
    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
