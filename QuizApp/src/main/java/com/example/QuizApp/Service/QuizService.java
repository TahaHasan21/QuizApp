package com.example.QuizApp.Service;

import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Model.QuizSession;
import com.example.QuizApp.Repository.QuestionRepository;
import com.example.QuizApp.Repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public Long startNewSession() {
        QuizSession session = new QuizSession();
        session.setTotalQuestions(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        quizSessionRepository.save(session);
        return session.getId();
    }

    public Question getRandomQuestion() {
        return questionRepository.getRandomQuestion();
    }

    public void submitAnswer(Long sessionId, Long questionId, String userAnswer) {
        Optional<Question> questionOpt = questionRepository.findById(questionId);
        Optional<QuizSession> sessionOpt = quizSessionRepository.findById(sessionId);

        if (questionOpt.isPresent() && sessionOpt.isPresent()) {
            Question question = questionOpt.get();
            QuizSession session = sessionOpt.get();

            session.setTotalQuestions(session.getTotalQuestions() + 1);

            if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                session.setCorrectAnswers(session.getCorrectAnswers() + 1);
            } else {
                session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
            }

            quizSessionRepository.save(session);
        }
    }

    public QuizSession getSessionSummary(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElseThrow();
    }
}

