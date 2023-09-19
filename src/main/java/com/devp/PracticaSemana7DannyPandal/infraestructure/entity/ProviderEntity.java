package com.devp.PracticaSemana7DannyPandal.infraestructure.entity;

import com.devp.PracticaSemana7DannyPandal.domain.model.Provider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "proveedor")
public class ProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;
    @Column(name = "direccion")
    private String address;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "estado")
    private int status;

    public ProviderEntity() {
    }

    public ProviderEntity(Long id, String name, String address, String phone, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public static ProviderEntity fromDomainModel(Provider provider) {
        return new ProviderEntity(
                provider.getId(),
                provider.getName(),
                provider.getAddress(),
                provider.getPhone(),
                provider.getStatus()
        );
    }

    public Provider toDomainModel() {
        return new Provider(
                this.id,
                this.name,
                this.address,
                this.phone,
                this.status
        );
    }
}
