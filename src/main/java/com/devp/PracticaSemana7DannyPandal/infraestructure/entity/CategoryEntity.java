package com.devp.PracticaSemana7DannyPandal.infraestructure.entity;


import com.devp.PracticaSemana7DannyPandal.domain.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "categoria")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "estado")
    private int status;

    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public static CategoryEntity fromDomainModel(Category category) {
        return new CategoryEntity(
                category.getId(),
                category.getName(),
                category.getStatus()
        );
    }

    public Category toDomainModel() {
        return new Category( this.id, this.name, this.status);
    }
}
