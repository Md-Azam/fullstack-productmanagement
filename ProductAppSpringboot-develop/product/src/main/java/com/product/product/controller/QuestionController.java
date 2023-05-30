package com.product.product.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.entity.Question;
import com.product.product.entity.Quiz;
import com.product.product.service.CategoryService;
import com.product.product.service.QuestionService;
import com.product.product.service.QuizService;

@RestController
@RequestMapping("question")
public class QuestionController{
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionService questionService;

@PostMapping
public Question saveQuestions(@RequestBody Question q) {
	return this.questionService.addQuestion(q);
}

@GetMapping("/")
public ResponseEntity<?> getAllQuestion(){
	return ResponseEntity.ok(this.questionService.getAllQuestion());
}

@GetMapping("/byQues/{questionId}")
public Question getOneQuestion(@PathVariable Long questionId) {
	return this.questionService.getQuestion(questionId);
}

@GetMapping("/byQuiz/{quizId}")
public ResponseEntity<?> getQuestionByQuizId(@PathVariable Long quizId) {
	Quiz quiz = this.quizService.getSingleQuiz(quizId);
	Set<Question> questionOfQuiz = quiz.getQuestion();
	List list = new ArrayList(questionOfQuiz);
	if(list.size()>(quiz.getTotalquestion())) {
		list = list.subList(0, (quiz.getTotalquestion()+1));
	}
	Collections.shuffle(list);
	return ResponseEntity.ok(list);
}

	
}

