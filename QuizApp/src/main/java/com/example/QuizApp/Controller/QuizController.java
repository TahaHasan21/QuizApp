package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Model.QuizSession;
import com.example.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public Long startQuiz() {
        return quizService.startNewSession();
    }

    @GetMapping("/question")
    public Question getQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long sessionId, @RequestParam Long questionId, @RequestParam String answer) {
        quizService.submitAnswer(sessionId, questionId, answer);
        return "Answer submitted successfully!";
    }

    @GetMapping("/summary")
    public QuizSession getSummary(@RequestParam Long sessionId) {
        return quizService.getSessionSummary(sessionId);
    }
}

