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
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionService questionService;

	@PostMapping("/savequiz/{cId}")
	public ResponseEntity<Quiz> saveQuiz(@RequestBody Quiz quiz ,@PathVariable Integer cId ) {
		return ResponseEntity.ok(this.quizService.addQuiz(quiz,cId));
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<?> getSingleQuiz(@PathVariable Long quizId) {

		Quiz quiz = this.quizService.getSingleQuiz(quizId);
		return ResponseEntity.ok(quiz);

//		Set<Question> questionOfQuiz = quiz.getQuestion();
//		List list = new ArrayList(questionOfQuiz);
//		if(list.size()>(quiz.getTotalquestion())) {
//			list = list.subList(0, (quiz.getTotalquestion()+1));
//		}
//		Collections.shuffle(list);
//		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllQuiz(){
		return ResponseEntity.ok(quizService.getAllQuiz());
	}
}
