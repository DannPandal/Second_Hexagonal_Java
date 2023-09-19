package com.devp.PracticaSemana7DannyPandal.infraestructure.repository;

import com.devp.PracticaSemana7DannyPandal.domain.model.Product;
import com.devp.PracticaSemana7DannyPandal.domain.ports.out.ProductRepositoryPort;
import com.devp.PracticaSemana7DannyPandal.infraestructure.entity.CategoryEntity;
import com.devp.PracticaSemana7DannyPandal.infraestructure.entity.ProductEntity;
import com.devp.PracticaSemana7DannyPandal.infraestructure.entity.ProviderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class ProductJpaRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;
    private final ProviderJpaRepository providerJpaRepository;

    public ProductJpaRepositoryAdapter(ProductJpaRepository productJpaRepository, CategoryJpaRepository categoryJpaRepository, ProviderJpaRepository providerJpaRepository){
        this.productJpaRepository = productJpaRepository;
        this.categoryJpaRepository = categoryJpaRepository;
        this.providerJpaRepository = providerJpaRepository;
    }

    @Override
    public Optional<Product> save(Product product) {
        ProductEntity productEntity = ProductEntity.fromDomainModel(product);
        productEntity.setId(0L);

        // validar si no existe la categoria
        if (! categoryJpaRepository.existsById(product.getCategory().getId())){
            return Optional.empty();
        }
        // validar si no existe el proveedor
        if (! providerJpaRepository.existsById(product.getProvider().getId())){
            return Optional.empty();
        }

        Optional<CategoryEntity> category = categoryJpaRepository.findById(product.getCategory().getId());
        productEntity.setCategory(category.get());

        Optional<ProviderEntity> provider = providerJpaRepository.findById(product.getProvider().getId());
        productEntity.setProvider(provider.get());

        ProductEntity savedProductEntity = productJpaRepository.save(productEntity);
        return Optional.of(savedProductEntity.toDomainModel());
    }

    @Override
    public Optional<List<Product>> findAll() {
        List<ProductEntity> productsEntity = productJpaRepository.findAll();
        List<Product> products = productsEntity.stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
        return Optional.of(products);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id).map(ProductEntity::toDomainModel);
    }

    @Override
    public Optional<Product> update(Product product) {
        ProductEntity productEntity = ProductEntity.fromDomainModel(product);

        // validar si no existe el producto a cambiar
        if (! productJpaRepository.existsById(product.getId())){
            return Optional.empty();
        }
        // validar si no existe la categoria
        if (! categoryJpaRepository.existsById(product.getCategory().getId())){
            return Optional.empty();
        }
        // validar si no existe el proveedor
        if (! providerJpaRepository.existsById(product.getProvider().getId())){
            return Optional.empty();
        }

        Optional<CategoryEntity> category = categoryJpaRepository.findById(product.getCategory().getId());
        productEntity.setCategory(category.get());

        Optional<ProviderEntity> provider = providerJpaRepository.findById(product.getProvider().getId());
        productEntity.setProvider(provider.get());

        ProductEntity updatedProductEntity = productJpaRepository.save(productEntity);

        return Optional.of(updatedProductEntity.toDomainModel());
    }

    @Override
    public boolean deleteById(Long id) {
        if (productJpaRepository.existsById(id)) {
            productJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
