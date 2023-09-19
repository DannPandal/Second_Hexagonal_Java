package com.devp.PracticaSemana7DannyPandal.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Provider {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private int status;

    public Provider(Long id, String name, String address, String phone, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }
}
