package com.tuempresa.backend_lista_compras.service;

import com.tuempresa.backend_lista_compras.model.Category;
import com.tuempresa.backend_lista_compras.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findOne(String id) {
        return repository.findById(id).orElse(null);
    }

    public Category update(String id, Category updated) {
        Category existing = findOne(id);
        if (existing == null) return null;
        existing.setNombre(updated.getNombre());
        existing.setDescripcion(updated.getDescripcion());
        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
