/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assimentjavafx;

import java.awt.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Home Tech
 */
public class LoginPage {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Image photoImage;

   

    public LoginPage() {
        Label titleLabel = new Label("Login");
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        Image photoImage = new Image("file:src/javafxapplication5/photo.png");
        ImageView imageView = new ImageView(photoImage);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        usernameField = new TextField();
        usernameField.setPrefSize(150, 30);
        usernameField.setMaxWidth(150); 
        usernameField.setStyle("-fx-border-color: blue;");

        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        passwordField = new PasswordField();
        passwordField.setPrefSize(150, 30);
        passwordField.setMaxWidth(150); 
        passwordField.setStyle("-fx-border-color: blue;");

        loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #1565c0;");
        loginButton.setFont(Font.font("Verdana", FontWeight.BOLD, 12));


        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(titleLabel, imageView, usernameLabel,
                usernameField, passwordLabel, passwordField, loginButton);

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.equals("1") && password.equals("1")) {
                ViewManager.getInstance().showConversionPage();
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Invalid username or password");
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(root, 300, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Login");
        ViewManager.getInstance().setLoginStage(stage);
    }
}


