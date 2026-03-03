package com.aracnideo.sbhibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aracnideo.sbhibernate.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
