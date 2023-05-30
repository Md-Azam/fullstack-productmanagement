package com.product.product.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.entity.Category;
import com.product.product.entity.Question;
import com.product.product.entity.Quiz;
import com.product.product.exception.ResourceNotFound;
import com.product.product.repository.CategoryRepo;
import com.product.product.repository.QuestionRepo;
import com.product.product.repository.QuizRepo;

@Service
public class QuizService {
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Quiz addQuiz(Quiz quiz,Integer cId ) {
		Category c = categoryRepo.findById(cId).orElseThrow(() -> new ResourceNotFound("category id not found"));
		quiz.setCategory(c);
		return this.quizRepo.save(quiz);
		
	}
	
	public Set<Quiz> getAllQuiz() {
		return new HashSet<>(this.quizRepo.findAll());
	}
	
	public Quiz getSingleQuiz(Long quizId) {
		Quiz q = quizRepo.findById(quizId).orElseThrow(() -> new ResourceNotFound("quiz id not found"));
	return q;
	}
	
}
