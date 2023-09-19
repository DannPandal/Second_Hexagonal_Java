package com.devp.PracticaSemana7DannyPandal.infraestructure.config;

import com.devp.PracticaSemana7DannyPandal.application.service.ProductService;
import com.devp.PracticaSemana7DannyPandal.application.usecase.ProductUseCaseImpl;
import com.devp.PracticaSemana7DannyPandal.domain.ports.out.ProductRepositoryPort;
import com.devp.PracticaSemana7DannyPandal.infraestructure.repository.ProductJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort){
        return new ProductService(new ProductUseCaseImpl(productRepositoryPort));
    }

    @Bean
    public ProductRepositoryPort productRepositoryPort(ProductJpaRepositoryAdapter productJpaRepositoryAdapter){
        return productJpaRepositoryAdapter;
    }

}
