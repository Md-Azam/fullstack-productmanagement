package com.product.product.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.product.entity.Question;
import com.product.product.entity.Quiz;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);
}
