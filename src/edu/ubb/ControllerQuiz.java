package edu.ubb;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControllerQuiz {

    public List<String> rasp;


    public ControllerQuiz() {}
    public ControllerQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Quiz quizGenerator() throws IOException {

        JsonReader jsonReader=new JsonReader();
        List<Question> allQuestions = jsonReader.jsonReader();
        Random random=new Random();

        List<Question> quizQuestions = new ArrayList<Question>();
        for (int i=0; i<26; i++){

            int randomIndex = random.nextInt(allQuestions.size());
            quizQuestions.add(allQuestions.get(randomIndex));

            allQuestions.remove(randomIndex);
        }

        quiz = new Quiz(quizQuestions);
        return quiz;
    }

    public void showQuestion() throws IOException {
        quizGenerator();
        for(Question q:quiz.getQuestions())
            System.out.println(q);
    }

/*    public Quiz setNextQuestionFromQuiz(Quiz q){
        String question="";
        String answer1="";
        String answer2="";
        String answer3="";

        for(int i=0; i<q.getQuestions().size(); i++){
            question=q.getQuestions().get(i).getQuestion();
            answer1=q.getQuestions().get(i).getAnswers().get(0);
            answer2=q.getQuestions().get(i).getAnswers().get(1);
            answer3=q.getQuestions().get(i).getAnswers().get(2);
            rasp.add(answer1);
            rasp.add(answer2);
            rasp.add(answer3);

        }

    }*/

    public int[] checkAnswer(Quiz quiz){
        int[] points = new int[2];

        for(int i=0; i<quiz.getQuestions().size();i++){
            for(int k=0; k<quiz.getQuestions().get(i).getCorrectAnswers().size();k++) {
                for (int j = 0; j < quiz.getUserAnswers().size(); j++) {
                    if (quiz.getUserAnswers().get(j).equals(quiz.getQuestions().get(i).getCorrectAnswers().get(i)))
                        points[0] += 1;
                    points[1] += 1;
                }
            }
        }
        return points;
    }



    /*@FXML public Label intrb;
    public void inLabel(){
        intrb.setText("aaaa");
    }*/
}
