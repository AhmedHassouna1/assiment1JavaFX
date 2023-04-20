package assimentjavafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import assimentjavafx.ViewManager;

public class ConversionPage {

    private TextField usdField;
    private TextField ilsField;
    private Button convertButton;
    private Button logoutButton;

    public ConversionPage() {
        Label titleLabel = new Label("Currency Conversion");
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        titleLabel.setStyle("-fx-text-fill: #311b92;");

        Label usdLabel = new Label("USD:");
        usdLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        usdField = new TextField();

        Label toLabel = new Label("       TO       ");
        toLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Label ilsLabel = new Label("ILS:");
        ilsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        ilsField = new TextField();

        convertButton = new Button("Convert");
        convertButton.setStyle("-fx-background-color: #0288d1;");
        convertButton.setFont(Font.font("Verdana", FontWeight.BOLD, 12));



        logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #fb8c00;");
        logoutButton.setFont(Font.font("Verdana", FontWeight.BOLD, 12));


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(titleLabel, 0, 0, 3, 1);
        grid.add(usdLabel, 0, 1);
        grid.add(usdField, 1, 1);
        grid.add(toLabel, 2, 1);
        grid.add(ilsLabel, 3, 1);
        grid.add(ilsField, 4, 1);
        grid.add(convertButton, 1, 2);
        grid.add(logoutButton, 4, 0); // Add logoutButton in the last column of the grid

        convertButton.setOnAction(event -> {
            if (!usdField.getText().isEmpty() && ilsField.getText().isEmpty()) {
                double usd = Double.parseDouble(usdField.getText());
                double ils = CurrencyConverter.convertToILS(usd);
                ilsField.setText(String.format("%.2f", ils));
            } else if (!ilsField.getText().isEmpty() && usdField.getText().isEmpty()) {
                double ils = Double.parseDouble(ilsField.getText());
                double usd = CurrencyConverter.convertToUSD(ils);
                usdField.setText(String.format("%.2f", usd));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in one of the fields");
                alert.showAndWait();
            }
        });

        logoutButton.setOnAction(event -> {
            ViewManager.getInstance().showLoginPage();
        });

        // Set the constraints for the logoutButton to move it to the far right
        GridPane.setConstraints(logoutButton, 5, 0);

        Scene scene = new Scene(grid, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Currency Conversion");
        ViewManager.getInstance().setConversionStage(stage);
    }
}
