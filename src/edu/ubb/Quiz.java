package edu.ubb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {

    private int idQuiz;
    private int quizNumber;
    private int questionNumber;
    private int nrCorrectAnswers;
    private int nrWrongAnswers;
    private List<Question> questions;
    public List<String> userAnswers;


    public Quiz(List<Question> questions){
        this.questions=questions;
    }

    public Quiz(int idQuiz, int quizNumber, int questionNumber, int nrCorrectAnswers, int nrWrongAnswers, List<Question> questions, List<String> userAnswers) {
        this.idQuiz = idQuiz;
        this.quizNumber = quizNumber;
        this.questionNumber = questionNumber;
        this.nrCorrectAnswers = nrCorrectAnswers;
        this.nrWrongAnswers = nrWrongAnswers;
        this.questions = questions;
        this.userAnswers = userAnswers;
    }

    public Quiz() {

    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public int getQuizNumber() {
        return quizNumber;
    }

    public void setQuizNumber(int quizNumber) {
        this.quizNumber = quizNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getNrCorrectAnswers() {
        return nrCorrectAnswers;
    }

    public void setNrCorrectAnswers(int nrCorrectAnswers) {
        this.nrCorrectAnswers = nrCorrectAnswers;
    }

    public int getNrWrongAnswers() {
        return nrWrongAnswers;
    }


    public void setNrWrongAnswers(int nrWrongAnswers) {
        this.nrWrongAnswers = nrWrongAnswers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<String> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<String> userAnswers) {
        this.userAnswers = userAnswers;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "idQuiz=" + idQuiz +
                ", quizNumber=" + quizNumber +
                ", questionNumber=" + questionNumber +
                ", nrCorrectAnswers=" + nrCorrectAnswers +
                ", nrWrongAnswers=" + nrWrongAnswers +
                ", questions=" + questions +
                '}';
    }

}
