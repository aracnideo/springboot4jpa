package com.aracnideo.sbhibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aracnideo.sbhibernate.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
