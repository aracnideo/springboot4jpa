package com.aracnideo.sbhibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aracnideo.sbhibernate.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
