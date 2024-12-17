package com.example.QuizApp.Model;

import jakarta.persistence.*;


@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_questions")
    private int totalQuestions;

    @Column(name = "correct_answers")
    private int correctAnswers;

    @Column(name = "incorrect_answers")
    private int incorrectAnswers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    //    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<AnsweredQuestion> answeredQuestions = new ArrayList<>();
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Integer getTotalQuestionsAnswered() {
//        return totalQuestionsAnswered;
//    }
//
//    public void setTotalQuestionsAnswered(Integer totalQuestionsAnswered) {
//        this.totalQuestionsAnswered = totalQuestionsAnswered;
//    }
//
//    public Integer getCorrectAnswers() {
//        return correctAnswers;
//    }
//
//    public void setCorrectAnswers(Integer correctAnswers) {
//        this.correctAnswers = correctAnswers;
//    }
//
//    public List<AnsweredQuestion> getAnsweredQuestions() {
//        return answeredQuestions;
//    }
//
//    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
//        this.answeredQuestions = answeredQuestions;
//    }
}

