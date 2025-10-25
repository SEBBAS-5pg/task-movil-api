package com.tuempresa.backend_lista_compras.controller;

import com.tuempresa.backend_lista_compras.model.Category;
import com.tuempresa.backend_lista_compras.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*") // <- permite conexión desde tu app móvil
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable String id) {
        return service.findOne(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable String id, @RequestBody Category category) {
        return service.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
