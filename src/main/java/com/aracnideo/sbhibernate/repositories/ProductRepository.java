package com.aracnideo.sbhibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aracnideo.sbhibernate.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
