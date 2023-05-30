package com.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.product.entity.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{

}
