package com.devp.PracticaSemana7DannyPandal.application.service;

import com.devp.PracticaSemana7DannyPandal.domain.model.Product;
import com.devp.PracticaSemana7DannyPandal.domain.ports.in.ProductUseCase;

import java.util.List;
import java.util.Optional;

public class ProductService implements ProductUseCase {

    // inyección de dependencia por constructor
    // inyección de puerto de entrada
    private final ProductUseCase productUseCase;
    public ProductService(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }
    @Override
    public Optional<Product> createProduct(Product product) {
        return productUseCase.createProduct(product);
    }

    @Override
    public Optional<List<Product>> getAllProduct() {
        return productUseCase.getAllProduct();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productUseCase.getProduct(id);
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        return productUseCase.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productUseCase.deleteProduct(id);
    }
}
