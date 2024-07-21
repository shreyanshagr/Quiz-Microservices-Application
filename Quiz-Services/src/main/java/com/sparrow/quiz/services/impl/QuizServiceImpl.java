package com.sparrow.quiz.services.impl;

import com.sparrow.quiz.entities.Question;
import com.sparrow.quiz.entities.Quiz;
import com.sparrow.quiz.repositories.QuizRepo;
import com.sparrow.quiz.services.QuestionClient;
import com.sparrow.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private  QuizRepo quizRepo;

    @Autowired
    private QuestionClient questionClient;


    @Override
    public Quiz add(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = this.quizRepo.findAll();

        // Using forEach instead of map, because we are modifying each quiz in the list
        quizzes.forEach(quiz -> {
            // Assuming questionClient.getQuestionOfQuiz(quiz.getQuizId()) returns a List<Question>
            List<Question> questions = questionClient.getQuestionOfQuiz(quiz.getQuizId());
            quiz.setQuestions(questions);
        });

        return quizzes;
    }

    @Override
    public Quiz getQuizById(int quizId) {
        Quiz quiz = this.quizRepo.findById(quizId).orElseThrow(()->new RuntimeException("No quiz found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quizId));
        return quiz;
    }
}
