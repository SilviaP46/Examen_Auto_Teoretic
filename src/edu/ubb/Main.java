package edu.ubb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.IOException;



public class Main extends Application {

/*    @FXML
    public Label pls;
    @FXML
    public Pane questionPane;*/


    @Override
        public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
            primaryStage.setTitle("Hello Worlddd");
            primaryStage.setScene(new Scene(root, 1100, 800));

            /*ControllerQuiz cq = new ControllerQuiz();
            Quiz quiz;
            quiz=cq.quizGenerator();
            ControllerQuiz cquiz = new ControllerQuiz(quiz);
            Controller controller = new Controller(cquiz);
*/
            //initView2();
            primaryStage.show();




            //ControllerQuiz cq = new ControllerQuiz();
            //cq.quizGenerator();


           /* Parent finishRoot = FXMLLoader.load(getClass().getResource("view2.fxml"));
            Scene questionScene =  new Scene(finishRoot);

            String question = cq.quizGenerator().getQuestions().get(0).getQuestion();
            //intrb = new Label(question);
            intrb.setText("aaa");*/


            /*questionStage.setScene(questionScene);
            questionStage.show();*/

            /*String question = cq.quizGenerator().getQuestions().get(0).getQuestion();
            intrb = new Label(question);*/
            /*javafx.scene.control.Label intrb = new javafx.scene.control.Label();
            intrb.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");*/

        }

/*        @FXML public Pane questionsPane;
        public void initView2() throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view2.fxml"));
            questionsPane = (Pane) loader.load();

            // Show the scene containing the root layout.
           // Scene scene = new Scene(questionsPane);


        }*/
        public static void main(String[] args) throws IOException {
            launch(args);
        }
    }

/*
    public static void main(String[] args) {//throws IOException {
        launch(args);
        JsonReader jsonReader=new JsonReader();
        for(Question q: jsonReader.jsonReader())
            System.out.println(q.getQuestion());

        ControllerQuiz cq=new ControllerQuiz();
        cq.quizGenerator();
        JsonReader jsonReader=new JsonReader();
        for(int i=0; i<26; i++)
            System.out.println(cq.getQuiz().getQuestions().get(i));*/



