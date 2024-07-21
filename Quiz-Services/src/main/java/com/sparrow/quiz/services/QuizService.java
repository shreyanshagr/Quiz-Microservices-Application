package com.sparrow.quiz.services;

import com.sparrow.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> getAllQuiz();

    Quiz getQuizById(int quizId);

}
