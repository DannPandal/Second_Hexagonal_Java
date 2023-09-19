package com.devp.PracticaSemana7DannyPandal.domain.ports.in;

import com.devp.PracticaSemana7DannyPandal.domain.model.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductUseCase {

    Optional<Product> createProduct(Product product);

    Optional<List<Product>> getAllProduct();

    Optional<Product> getProduct(Long id);

    Optional<Product> updateProduct(Product product);

    boolean deleteProduct(Long id);
}
