package com.devp.PracticaSemana7DannyPandal.domain.ports.out;

import com.devp.PracticaSemana7DannyPandal.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Optional<Product> save(Product product);

    Optional<List<Product>> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> update(Product product);

    boolean deleteById(Long id);
}
