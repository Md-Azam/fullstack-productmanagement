package com.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.product.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
