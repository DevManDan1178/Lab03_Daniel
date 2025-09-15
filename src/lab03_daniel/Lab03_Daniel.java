/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab03_daniel;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 6323612
 */
public class Lab03_Daniel extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Setup structure
        BorderPane rootBorder = new BorderPane();
        GridPane gridPane = new GridPane();
        rootBorder.setCenter(gridPane);
        
        // Labels and Textfields
            //First Name
        Label firstNameLabel = new Label("First Name");
        TextField firstNameTxtField = new TextField();
        
        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameTxtField, 1, 0);
            //Last Name
        Label lastNameLabel = new Label("First Name");
        TextField lastNameTxtField = new TextField();
        
        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameTxtField, 1, 1);
            //Email
        Label emailLabel = new Label("First Name");
        TextField emailTxtField = new TextField();
        
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailTxtField, 1, 2);
            //Password
        Label passLabel = new Label("First Name");
        PasswordField passField = new PasswordField();
              
        gridPane.add(passLabel, 0, 3);
        gridPane.add(passField, 1, 3);

        

        


        
        
        
 
        //Show
        Scene scene = new Scene(rootBorder);   
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
