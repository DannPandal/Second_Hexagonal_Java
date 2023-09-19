package com.devp.PracticaSemana7DannyPandal.infraestructure.entity;

import com.devp.PracticaSemana7DannyPandal.domain.model.Category;
import com.devp.PracticaSemana7DannyPandal.domain.model.Product;
import com.devp.PracticaSemana7DannyPandal.domain.model.Provider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "producto")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "precio")
    private double price;
    @Column(name = "estado")
    private int status;

    @ManyToOne()
    @JoinColumn(name = "categoria_id")
    private CategoryEntity category;
    @ManyToOne()
    @JoinColumn(name = "proveedor_id")
    private ProviderEntity provider;

    public ProductEntity() {
    }
    public ProductEntity(Long id, String name, String description, double price, int status, CategoryEntity category, ProviderEntity provider) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.category = category;
        this.provider = provider;
    }

    public static ProductEntity fromDomainModel(Product product) {
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStatus(),
                CategoryEntity.fromDomainModel(product.getCategory()),
                ProviderEntity.fromDomainModel(product.getProvider())
        );
    }

    public Product toDomainModel() {
        return new Product(
                this.id,
                this.name,
                this.description,
                this.price,
                this.status,
                this.category.toDomainModel(),
                this.provider.toDomainModel()
        );
    }
}
