package com.tuempresa.backend_lista_compras.repository;

import com.tuempresa.backend_lista_compras.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {}
