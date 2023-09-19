package com.devp.PracticaSemana7DannyPandal.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;
    private int status;

    public Category(Long id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
