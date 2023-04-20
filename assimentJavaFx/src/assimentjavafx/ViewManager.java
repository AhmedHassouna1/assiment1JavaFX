/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assimentjavafx;

import javafx.stage.Stage;


public class ViewManager {
   private static ViewManager instance;
    private Stage loginStage;
    private Stage conversionStage;

    private ViewManager() {
    }

    public static ViewManager getInstance() {
        if (instance == null) {
            instance = new ViewManager();
        }
        return instance;
    }

    public void showLoginPage() {
        loginStage.show();
        conversionStage.hide();
    }

    public void showConversionPage() {
        loginStage.hide();
        conversionStage.show();
    }

    public void setLoginStage(Stage stage) {
        loginStage = stage;
    }

    public void setConversionStage(Stage stage) {
        conversionStage = stage;
    }
}