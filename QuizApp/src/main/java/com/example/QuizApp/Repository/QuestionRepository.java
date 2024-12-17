package com.example.QuizApp.Repository;

import com.example.QuizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT * FROM Question ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Question getRandomQuestion();
}
