package com.sparrow.quiz.services;

import com.sparrow.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8081", value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICES")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable int quizId);
}
