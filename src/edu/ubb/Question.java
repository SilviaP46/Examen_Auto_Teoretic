package edu.ubb;

import java.util.List;

public class Question {

        private int idQuestion;
        private String question;
        List<String> answers;
        List<String> correctAnswers;
       // List<String> userAnswers;


        public Question(){}
        public Question(int idQuestion, String question, List<String> answers, List<String> correctAnswers) {
            this.idQuestion = idQuestion;
            this.question = question;
            this.answers = answers;
            this.correctAnswers = correctAnswers;
        }

        public int getIdQuestion() {
            return idQuestion;
        }

        public void setIdQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
        }

        public String getQuestion() { return question; }

        public void setQuestion(String question) { this.question = question; }

         public List<String> getAnswers() {
            return answers;
        }

        public void setAnswers(List<String> answers) {
            this.answers = answers;
        }

        public List<String> getCorrectAnswers() {
            return correctAnswers;
        }

        public void setCorrectAnswers(List<String> correctAnswers) {
            this.correctAnswers = correctAnswers;
        }

/*        public List<String> getUserAnswers() {
            return userAnswers;
        }

        public void setUserAnswers(List<String> userAnswers) {
            this.userAnswers = userAnswers;
        }*/

    @Override
        public String toString() {
            return "Question{" +
                    "idQuestion=" + idQuestion +
                    " question= " + question +
                    ", answers=" + answers +
                    ", correctAnswers=" + correctAnswers +
                    '}';
        }
}
