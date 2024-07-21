package com.sparrow.question.controller;

import com.sparrow.question.entities.Question;
import com.sparrow.question.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServices questionServices;

    @PostMapping()
    public Question createQues(@RequestBody Question question){
        return this.questionServices.add(question);
    }

    @GetMapping()
    public List<Question> findAllQuestion(){
        return this.questionServices.findAllQuestion();
    }

    @GetMapping("/{questionId}")
    public Question findQuesById(@PathVariable int questionId){
        return this.questionServices.findById(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> findAllQuestionByQuiz(@PathVariable int quizId){
        return this.questionServices.findAllQuestionByQuiz(quizId);
    }

}
