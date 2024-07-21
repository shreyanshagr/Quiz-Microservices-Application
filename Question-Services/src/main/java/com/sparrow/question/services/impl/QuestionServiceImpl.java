package com.sparrow.question.services.impl;

import com.sparrow.question.entities.Question;
import com.sparrow.question.repository.QuestionRepo;
import com.sparrow.question.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionServices {
    @Autowired
    private QuestionRepo questionRepo;


    @Override
    public Question add(Question question) {
        return this.questionRepo.save(question);
    }

    @Override
    public Question findById(int questionId) {
        return this.questionRepo.findById(questionId).orElseThrow(()->new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> findAllQuestion() {
        return this.questionRepo.findAll();
    }

    @Override
    public List<Question> findAllQuestionByQuiz(int quizId) {
        return this.questionRepo.findByQuizId(quizId);
    }
}
