package com.tuempresa.backend_lista_compras.repository;

import com.tuempresa.backend_lista_compras.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {}
