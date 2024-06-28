/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

    Created on : 12 4 2024, 12:24:58 PM
    Author     : Agung YZS and Ryan A
*/

package laundryshopmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 *
 * @author WINDOWS 10
 */
public class LaundryShopManagementSystem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXMLDocument.fxml")));
        
        Scene scene = new Scene(root);
        
        stage.setMinWidth(750);
        stage.setMinHeight(416);
        
        stage.setTitle("Laundry Shop Management System");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
