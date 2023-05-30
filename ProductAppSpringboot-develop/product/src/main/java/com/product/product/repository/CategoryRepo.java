package com.product.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.product.entity.Category;
import com.product.product.entity.Quiz;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	//public List<Category> findByQuiz(Quiz quiz);
}
