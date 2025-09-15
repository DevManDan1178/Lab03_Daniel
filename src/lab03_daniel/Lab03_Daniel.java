/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab03_daniel;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        rootBorder.setCenter(gridPane);
        
        // Setup Labels and Textfields
            //First Name
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameTxtField = new TextField();
        
        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameTxtField, 1, 0);
            //Last Name
        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameTxtField = new TextField();
        
        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameTxtField, 1, 1);
            //Email
        Label emailLabel = new Label("Email:");
        TextField emailTxtField = new TextField();
        
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailTxtField, 1, 2);
            //Password
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
              
        gridPane.add(passLabel, 0, 3);
        gridPane.add(passField, 1, 3);
   
        
        // Buttons
            //Register
        Button registerButton = new Button("Register");
        gridPane.add(registerButton, 0, 4);
            //Clear
        Button clearButton = new Button("Clear");
        gridPane.add(clearButton, 1, 4);
        
        // Message label (Error/Success)
        Label msgLabel = new Label("");
        gridPane.add(msgLabel, 1, 5);
        // Array of input fields to shorten code
        TextField[] inputFields = {firstNameTxtField, lastNameTxtField, emailTxtField, passField};
        
        // Setup functionality
        registerButton.setDisable(true);
        // Event handler for input fields (detects if register button should be enabled)
        EventHandler fieldInputHandler = (Event event) -> {
            //If an input field is empty -> disable register | else enable register
            for (TextField field : inputFields) {
                if (field.getText().isEmpty()) {
                    registerButton.setDisable(true);
                    return;
                }
            }
            registerButton.setDisable(false);   
        };
        
        for (TextField field : inputFields) {
            field.addEventHandler(EventType.ROOT, fieldInputHandler);
        }
        
        // Handle clicks for register button (detects if the fields are valid)
        registerButton.setOnAction((ActionEvent event) -> {
            //If email and password is valid, display welcome message | else display error message (on message label)
            String message = (checkEmail(emailTxtField.getText()) && checkPassword(passField.getText())) ? "Welcome" : "Invalid email/password";
            msgLabel.setText(message);

        });
        
        // Handle clicks for clear button (clears all textfields)
        clearButton.setOnAction((ActionEvent event) -> {
            for (TextField field : inputFields) {
                field.setText("");
            }
            msgLabel.setText("");
        });
        
        // Show 
        Scene scene = new Scene(rootBorder);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Checks if email is valid 
     * @param string
     * @return true if string is that of a (potentially) valid email address | else false
     */
    private boolean checkEmail(String string) {
        // [email]@[provider].[domain] -> must have an '@' and a '.' at least 1 char after (check from the 2nd character after '@')
        int index = string.indexOf('@');
        int strLen = string.length();
        if (index <= 0 || index == strLen) {
            return false;
        }
        
        return string.indexOf('.', index + 2) != -1;
    }
    
    /**
     * Checks if password is valid
     * @param string
     * @return true if string contains at least 1 digit and 1 letter | else false
     */
    private boolean checkPassword(String string) {
        // Must contain : at least 1 digit, 1 letter   
        boolean containsDigit = false, containsLetter = false;
        for (char c : string.toCharArray()) {
            containsDigit = containsDigit || Character.isDigit(c);
            containsLetter = containsLetter || Character.isLetter(c);
            if (containsDigit && containsLetter) {
                return true;
            }
        }
        return false;
    }
} 
