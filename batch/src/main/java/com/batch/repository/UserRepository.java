package com.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
