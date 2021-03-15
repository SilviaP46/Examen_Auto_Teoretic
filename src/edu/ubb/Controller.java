package edu.ubb;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {

    Stage stage = new Stage();
    Quiz quiz;
    ControllerQuiz cq = new ControllerQuiz();
    final int[] count = {0};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //StartUp
    }

    public void startQuiz(ActionEvent e) throws Exception {
        //Parent finishRoot = FXMLLoader.load(getClass().getResource("view.fxml"));
        Scene scene =  new Scene(new Group(),1100,800);
        //Scene sceneX =  new Scene(new Group(),900,700);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //stage.setScene(questionScene);
        quiz = cq.quizGenerator();

        //HBox headerBox=raspCorecte+raspGresite
        Label nrCorrectAnswers = new Label("✔" + Integer.toString(quiz.getNrCorrectAnswers()));
        nrCorrectAnswers.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        nrCorrectAnswers.setWrapText(true);
        nrCorrectAnswers.setTextAlignment(TextAlignment.JUSTIFY);
        nrCorrectAnswers.setMaxWidth(700);

        Label nrWrongAmswers = new Label("✘" + Integer.toString(quiz.getNrWrongAnswers()));
        nrWrongAmswers.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        nrWrongAmswers.setWrapText(true);
        nrWrongAmswers.setTextAlignment(TextAlignment.JUSTIFY);
        nrWrongAmswers.setMaxWidth(700);

        HBox headerBox = new HBox();
        headerBox.setSpacing(600);
        headerBox.setPadding(new Insets(-30, 0, 0, 0));
        headerBox.getChildren().addAll(nrCorrectAnswers, nrWrongAmswers);


        //HBox questionBox=nrIntrb+intrb
        /*Label nrQuestion = new Label(Integer.toString(quiz.getQuestionNumber() + 1));
        nrQuestion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        nrQuestion.setWrapText(true);
        nrQuestion.setTextAlignment(TextAlignment.JUSTIFY);
        nrQuestion.setMaxWidth(700);*/

        Label question = new Label(count[0] + 1 +")  " + quiz.getQuestions().get(0).getQuestion());

        //Setting font to the text
        question.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //setting the position of the text
        question.setWrapText(true);
        question.setTextAlignment(TextAlignment.JUSTIFY);
        question.setMaxWidth(700);

/*        HBox questionBox = new HBox();
        questionBox.setSpacing(0);
        questionBox.setPadding(new Insets(-10, 0, 0, 0));
        questionBox.getChildren().addAll(nrQuestion, question);*/


        //VBox answerBox = answer1+2+3
        Label answer1 = new Label(quiz.getQuestions().get(0).getAnswers().get(0));

        //Setting font to the text
        answer1.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer1.setWrapText(true);
        answer1.setTextAlignment(TextAlignment.JUSTIFY);
        answer1.setMaxWidth(700);

        Label answer2 = new Label(quiz.getQuestions().get(0).getAnswers().get(1));

        //Setting font to the text
        answer2.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer2.setWrapText(true);
        answer2.setTextAlignment(TextAlignment.JUSTIFY);
        answer2.setMaxWidth(700);

        Label answer3 = new Label(quiz.getQuestions().get(0).getAnswers().get(2));

        //Setting font to the text
        answer3.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer3.setWrapText(true);
        answer3.setTextAlignment(TextAlignment.JUSTIFY);
        answer3.setMaxWidth(700);

        VBox answerBox = new VBox();
        answerBox.setSpacing(15);
        answerBox.setPadding(new Insets(35, 0, 0, 0));
        answerBox.getChildren().addAll(question,answer1, answer2, answer3);


        //HBox buttonAnsBox = buttonA+B+C
        Button buttonA = new Button("A");
        buttonA.setPrefSize(95, 65);
        Button buttonB = new Button("B");
        buttonB.setPrefSize(95, 65);
        Button buttonC = new Button("C");
        buttonC.setPrefSize(95, 65);

/*        buttonA.setOnAction(actionEvent -> {quiz.getUserAnswers().add("A");
            System.out.println(quiz.getUserAnswers());});*/

        HBox buttonAnswBox = new HBox();
        buttonAnswBox.setSpacing(150);
        buttonAnswBox.setPadding(new Insets(70, 0, 0, 0));
        buttonAnswBox.getChildren().addAll(buttonA, buttonB, buttonC);


        //HBox buttonOptBox = raspMaiTz+modifica+sterge
        Button trimiteButton = new Button("Trimite");
        trimiteButton.setPrefSize(140, 60);
        Button modificaButton = new Button("Modifica");
        modificaButton.setPrefSize(140, 60);
        Button raspMaiTzButton = new Button("Raspund mai tarziu");
        raspMaiTzButton.setPrefSize(140, 60);

        HBox buttonOptBox = new HBox();
        buttonOptBox.setSpacing(100);
        buttonOptBox.setPadding(new Insets(10, 0, 0, 0));
        buttonOptBox.getChildren().addAll(raspMaiTzButton, modificaButton, trimiteButton);

        //Creating a scene object
        //Scene sceneX = new Scene(new Group(), 900, 700);


        // VBox myVBox= all my boxes
        VBox myVBox = new VBox();
        myVBox.setSpacing(30);
        myVBox.setPadding(new Insets(100, 0, 0, 120));
        myVBox.setAlignment(Pos.CENTER);
        myVBox.getChildren().addAll(headerBox, answerBox, buttonAnswBox, buttonOptBox);
        ((Group) scene.getRoot()).getChildren().addAll(myVBox);

        //Setting title to the Stage
        stage.setTitle("DRPCIV");

        //Adding scene to the stage
        stage.setScene(scene);


        //Displaying the contents of the stage
        stage.show();
        trimiteButton.setOnAction(actionEvent -> nextQuestion(quiz));

    }

    public void nextQuestion(Quiz quiz) {
        System.out.println(quiz);

        //int i = quiz.getQuestionNumber();
        //i += 1;
        //Creating a scene object
        Scene scene2 = new Scene(new Group(), 1100, 800);
        if (quiz.getQuestionNumber() < 25) {

            //System.out.println(i);
            /*int i = quiz.getQuestionNumber();
            i += 1;*/
            int i = count[0] += 1;

            System.out.println(quiz.getQuestionNumber());
            Label nrCorrectAnswers1 = new Label("✔" + Integer.toString(quiz.getNrCorrectAnswers()));
            nrCorrectAnswers1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
            nrCorrectAnswers1.setWrapText(true);
            nrCorrectAnswers1.setTextAlignment(TextAlignment.JUSTIFY);
            nrCorrectAnswers1.setMaxWidth(700);

            Label nrWrongAmswers1 = new Label("✘" + Integer.toString(quiz.getNrWrongAnswers()));
            nrWrongAmswers1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
            nrWrongAmswers1.setWrapText(true);
            nrWrongAmswers1.setTextAlignment(TextAlignment.JUSTIFY);
            nrWrongAmswers1.setMaxWidth(700);

            HBox headerBox1 = new HBox();
            headerBox1.setSpacing(600);
            headerBox1.setPadding(new Insets(-30, 0, 0, 0));
            headerBox1.getChildren().addAll(nrCorrectAnswers1, nrWrongAmswers1);


            //HBox questionBox=nrIntrb+intrb
            /*Label nrQuestion1 = new Label(Integer.toString(quiz.getQuestionNumber()+2));
            nrQuestion1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            nrQuestion1.setWrapText(true);
            nrQuestion1.setTextAlignment(TextAlignment.JUSTIFY);
            nrQuestion1.setMaxWidth(700);*/

            System.out.println(quiz.getQuestionNumber());

            Label question1 = new Label(count[0] + 1 +")  " + quiz.getQuestions().get(i).getQuestion());

            //Setting font to the text
            question1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            //setting the position of the text
            question1.setWrapText(true);
            question1.setTextAlignment(TextAlignment.JUSTIFY);
            question1.setMaxWidth(700);

            /*HBox questionBox1 = new HBox();
            questionBox1.setSpacing(0);
            questionBox1.setPadding(new Insets(-10, 0, 0, 0));
            questionBox1.getChildren().addAll(nrQuestion1, question1);*/


            //VBox answerBox = answer1+2+3
            Label answer11 = new Label(quiz.getQuestions().get(i).getAnswers().get(0));

            //Setting font to the text
            answer11.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

            //setting the position of the text
            answer11.setWrapText(true);
            answer11.setTextAlignment(TextAlignment.JUSTIFY);
            answer11.setMaxWidth(700);

            Label answer21 = new Label(quiz.getQuestions().get(i).getAnswers().get(1));

            //Setting font to the text
            answer21.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

            //setting the position of the text
            answer21.setWrapText(true);
            answer21.setTextAlignment(TextAlignment.JUSTIFY);
            answer21.setMaxWidth(700);

            Label answer31 = new Label(quiz.getQuestions().get(i).getAnswers().get(2));

            //Setting font to the text
            answer31.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

            //setting the position of the text
            answer31.setWrapText(true);
            answer31.setTextAlignment(TextAlignment.JUSTIFY);
            answer31.setMaxWidth(700);

            VBox answerBox1 = new VBox();
            answerBox1.setSpacing(15);
            answerBox1.setPadding(new Insets(35, 0, 0, 0));
            answerBox1.getChildren().addAll(question1, answer11, answer21, answer31);


            //HBox buttonAnsBox = buttonA+B+C
            Button buttonA1 = new Button("A");
            buttonA1.setPrefSize(95, 65);
            Button buttonB1 = new Button("B");
            buttonB1.setPrefSize(95, 65);
            Button buttonC1 = new Button("C");
            buttonC1.setPrefSize(95, 65);

            HBox buttonAnswBox1 = new HBox();
            buttonAnswBox1.setSpacing(150);
            buttonAnswBox1.setPadding(new Insets(70, 0, 0, 0));
            buttonAnswBox1.getChildren().addAll(buttonA1, buttonB1, buttonC1);


            //HBox buttonOptBox = raspMaiTz+modifica+sterge
            Button trimiteButton1 = new Button("Trimite");
            trimiteButton1.setPrefSize(140, 60);
            Button modificaButton1 = new Button("Modifica");
            modificaButton1.setPrefSize(140, 60);
            Button raspMaiTzButton1 = new Button("Raspund mai tarziu");
            raspMaiTzButton1.setPrefSize(140, 60);

            HBox buttonOptBox1 = new HBox();
            buttonOptBox1.setSpacing(100);
            buttonOptBox1.setPadding(new Insets(10, 0, 0, 0));
            buttonOptBox1.getChildren().addAll(raspMaiTzButton1, modificaButton1, trimiteButton1);

            /*//Creating a scene object
            Scene scene3 = new Scene(new Group(), 900, 700);*/


            // VBox myVBox= all my boxes
            VBox myVBox1 = new VBox();
            myVBox1.setSpacing(30);
            myVBox1.setPadding(new Insets(100, 0, 0, 120));
            myVBox1.setAlignment(Pos.CENTER);
            myVBox1.getChildren().addAll(headerBox1, answerBox1, buttonAnswBox1, buttonOptBox1);
            ((Group) scene2.getRoot()).getChildren().addAll(myVBox1);

            stage.setScene(scene2);
            stage.show();

/*            trimiteButton1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    nextQuestion(quiz);

                    System.out.println("x");
                    Scene s=new Scene(new Group(),900,700);
                    nextQuestion(quiz, s);
                    stage.setScene(s);
                    //stage.show();
                }
            });*/
            trimiteButton1.setOnAction(actionEvent -> nextQuestion(quiz));

        }

    }
}
