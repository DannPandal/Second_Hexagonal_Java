package com.devp.PracticaSemana7DannyPandal.infraestructure.repository;

import com.devp.PracticaSemana7DannyPandal.domain.model.Category;
import com.devp.PracticaSemana7DannyPandal.domain.model.Product;
import com.devp.PracticaSemana7DannyPandal.domain.model.Provider;
import com.devp.PracticaSemana7DannyPandal.infraestructure.entity.CategoryEntity;
import com.devp.PracticaSemana7DannyPandal.infraestructure.entity.ProductEntity;
import com.devp.PracticaSemana7DannyPandal.infraestructure.entity.ProviderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ProductJpaRepositoryAdapterTest {

    @Mock
    ProductJpaRepository productJpaRepository;
    @Mock
    CategoryJpaRepository categoryJpaRepository;
    @Mock
    ProviderJpaRepository providerJpaRepository;

    @InjectMocks    // Inyecta los mocks en el objeto a testear (donde estan los metodos a testear)
    ProductJpaRepositoryAdapter productJpaRepositoryAdapter;

    @BeforeEach
        // Antes de cada test
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productJpaRepositoryAdapter = new ProductJpaRepositoryAdapter(productJpaRepository, categoryJpaRepository, providerJpaRepository);
    }

    // Test exitoso al guardar producto
    @Test
    void saveSuccessInProductEntity() {
        // Arrange
        Category category = new Category();
        category.setId(1L);
        Provider provider = new Provider();
        provider.setId(1L);

        Product product = new Product(1L, "Producto 1", "Descripcion Producto 1", 10, 1, category, provider);

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1L);
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setId(1L);
        ProductEntity productEntity = new ProductEntity(1L, "Producto 1", "Descripcion Producto 1", 10, 1, categoryEntity, providerEntity);

        // Simulando comportamiento
        when(categoryJpaRepository.existsById(Mockito.anyLong())).thenReturn(true);
        when(providerJpaRepository.existsById(Mockito.anyLong())).thenReturn(true);
        when(categoryJpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productEntity.getCategory()));
        when(providerJpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productEntity.getProvider()));
        when(productJpaRepository.save(Mockito.any(ProductEntity.class))).thenReturn(productEntity);

        // Act
        Optional<Product> savedProductAdapter = productJpaRepositoryAdapter.save(product);

        // Assert
        assertFalse(savedProductAdapter.isEmpty());
        assertEquals(product.getId(), savedProductAdapter.get().getId());
        assertEquals(product.getName(), savedProductAdapter.get().getName());
        assertEquals(product.getDescription(), savedProductAdapter.get().getDescription());
        assertEquals(product.getPrice(), savedProductAdapter.get().getPrice());
        assertEquals(product.getStatus(), savedProductAdapter.get().getStatus());
        assertEquals(product.getCategory().getId(), savedProductAdapter.get().getCategory().getId());
        assertEquals(product.getProvider().getId(), savedProductAdapter.get().getProvider().getId());

    }


    // Test exitoso al obtener todos los productos
    @Test
    void getAllSuccessInProductEntity() {

        // Arrange
        List<ProductEntity> productsEntity = new ArrayList<>();

        when(productJpaRepository.findAll()).thenReturn(productsEntity);
        // Act
        Optional<List<Product>> getProductAdapter = productJpaRepositoryAdapter.findAll();

        // Assert
        assertFalse(getProductAdapter.isEmpty());
    }

    // Test exitoso al buscar producto por id
    @Test
    void findByIdSuccessInProductEntity() {
        // Lo que se envia al metodo de la clases a probar
        Long id = 1L;

        // Lo que se va a enviar a BD como simulación
        ProductEntity productEntity = new ProductEntity(1L, "Producto 1", "Descripcion Producto 1", 10, 1, new CategoryEntity(), new ProviderEntity());

        // Simulando comportanmiento
        when(productJpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productEntity));

        // Ejecutando el metodo a testear
        Optional<Product> productAdapter = productJpaRepositoryAdapter.findById(id);

        // Verificando
        assertFalse(productAdapter.isEmpty());
        assertEquals(id, productAdapter.get().getId());
    }

    // Test exitoso al actualizar producto
    @Test
    void updateSuccessInProductEntity() {
        // Arrange
        Category category = new Category();
        category.setId(1L);
        Provider provider = new Provider();
        provider.setId(1L);

        Product product = new Product(1L, "Producto 1", "Descripcion Producto 1", 10, 1, category, provider);

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1L);
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setId(1L);
        ProductEntity productEntity = new ProductEntity(1L, "Producto 1", "Descripcion Producto 1", 10, 1, categoryEntity, providerEntity);

        // Simulando
        when(productJpaRepository.existsById(Mockito.anyLong())).thenReturn(true);
        when(categoryJpaRepository.existsById(Mockito.anyLong())).thenReturn(true);
        when(providerJpaRepository.existsById(Mockito.anyLong())).thenReturn(true);
        when(categoryJpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productEntity.getCategory()));
        when(providerJpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productEntity.getProvider()));
        when(productJpaRepository.save(Mockito.any(ProductEntity.class))).thenReturn(productEntity);

        // Act
        Optional<Product> updateddProductAdapter = productJpaRepositoryAdapter.update(product);

        // Assert
        assertFalse(updateddProductAdapter.isEmpty());
        assertEquals(product.getId(), updateddProductAdapter.get().getId());
        assertEquals(product.getName(), updateddProductAdapter.get().getName());
        assertEquals(product.getDescription(), updateddProductAdapter.get().getDescription());
        assertEquals(product.getPrice(), updateddProductAdapter.get().getPrice());
        assertEquals(product.getStatus(), updateddProductAdapter.get().getStatus());
        assertEquals(product.getCategory().getId(), updateddProductAdapter.get().getCategory().getId());
        assertEquals(product.getProvider().getId(), updateddProductAdapter.get().getProvider().getId());

    }

    // Test exitoso al eliminar usuario
    @Test
    void deleteByIdSuccessInUserEntity() {

        Long id = 1L;

        when(productJpaRepository.existsById(Mockito.anyLong())).thenReturn(true);
        doNothing().when(productJpaRepository).deleteById(Mockito.anyLong());

        // Ejecutando el metodo a testear
        boolean deletedProductAdapter = productJpaRepositoryAdapter.deleteById(id);

        // Verificando
        assertTrue(deletedProductAdapter);
        verify(productJpaRepository, times(1)).deleteById(Mockito.anyLong()); // verificando que se llame al metodo deleteById

    }

}