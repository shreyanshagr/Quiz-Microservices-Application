package com.sparrow.question.repository;

import com.sparrow.question.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByQuizId(int quizId);
}
