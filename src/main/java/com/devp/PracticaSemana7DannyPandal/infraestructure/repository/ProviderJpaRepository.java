package com.devp.PracticaSemana7DannyPandal.infraestructure.repository;

import com.devp.PracticaSemana7DannyPandal.infraestructure.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderJpaRepository extends JpaRepository<ProviderEntity, Long> {
}
