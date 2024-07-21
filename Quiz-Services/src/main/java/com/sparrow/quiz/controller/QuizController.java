package com.sparrow.quiz.controller;

import com.sparrow.quiz.entities.Quiz;
import com.sparrow.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/quiz")
@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return this.quizService.add(quiz);
    }

    @GetMapping("/{quizId}")
    public Quiz getQuizById(@PathVariable int quizId){
        return this.quizService.getQuizById(quizId);
    }

    @GetMapping()
    public List<Quiz> getAllQuiz(){
        return this.quizService.getAllQuiz();
    }


}
