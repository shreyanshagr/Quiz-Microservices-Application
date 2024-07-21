package com.sparrow.quiz.repositories;

import com.sparrow.quiz.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
