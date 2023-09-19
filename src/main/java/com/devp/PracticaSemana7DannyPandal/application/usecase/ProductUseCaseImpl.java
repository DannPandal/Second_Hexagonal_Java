package com.devp.PracticaSemana7DannyPandal.application.usecase;

import com.devp.PracticaSemana7DannyPandal.domain.model.Product;
import com.devp.PracticaSemana7DannyPandal.domain.ports.in.ProductUseCase;
import com.devp.PracticaSemana7DannyPandal.domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }
    @Override
    public Optional<Product> createProduct(Product product) {
        return productRepositoryPort.save(product);
    }

    @Override
    public Optional<List<Product>> getAllProduct() {
        return productRepositoryPort.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepositoryPort.findById(id);
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        return productRepositoryPort.update(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productRepositoryPort.deleteById(id);
    }
}
