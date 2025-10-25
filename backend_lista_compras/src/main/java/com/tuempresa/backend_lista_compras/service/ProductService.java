package com.tuempresa.backend_lista_compras.service;

import com.tuempresa.backend_lista_compras.model.Product;
import com.tuempresa.backend_lista_compras.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findOne(String id) {
        return repository.findById(id).orElse(null);
    }

    public Product update(String id, Product updated) {
        Product existing = findOne(id);
        if (existing == null) return null;

        existing.setNombre(updated.getNombre());
        existing.setCantidad(updated.getCantidad());
        existing.setPrecio(updated.getPrecio());
        existing.setCategory(updated.getCategory());
        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
