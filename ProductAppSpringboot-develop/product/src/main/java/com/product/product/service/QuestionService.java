package com.product.product.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.entity.Question;
import com.product.product.entity.Quiz;
import com.product.product.exception.ResourceNotFound;
import com.product.product.repository.QuestionRepo;
@Service
public class QuestionService {

	
	@Autowired
	private QuestionRepo questionRepo;
	
	public Question addQuestion(Question question) {
		return this.questionRepo.save(question);
		
	}
	
	public Set<Question> getAllQuestion() {
		return new HashSet<>(this.questionRepo.findAll());
	}
	
	public Question getQuestion(Long questionId) {
		Question q = questionRepo.findById(questionId).orElseThrow(() -> new ResourceNotFound("Question id not found"));
	return q;
	}
	
	public Set<Question> getQuestionByQuiz(Quiz quiz) {
		return this.questionRepo.findByQuiz(quiz);
	}
}
