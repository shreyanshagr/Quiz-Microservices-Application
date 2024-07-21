package com.sparrow.question.services;

import com.sparrow.question.entities.Question;

import java.util.List;

public interface QuestionServices {

    Question add(Question question);

    Question findById(int questionId);

    List<Question> findAllQuestion();

    List<Question> findAllQuestionByQuiz(int quizId);

}
