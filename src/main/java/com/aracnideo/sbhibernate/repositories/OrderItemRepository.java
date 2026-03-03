package com.aracnideo.sbhibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aracnideo.sbhibernate.entities.OrderItem;
import com.aracnideo.sbhibernate.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
