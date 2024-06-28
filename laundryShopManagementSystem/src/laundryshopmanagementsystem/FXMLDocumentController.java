package laundryshopmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Hyperlink create_acc;

    @FXML
    private Hyperlink login_acc;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signup_btn;

    @FXML
    private TextField su_username;

    @FXML
    private PasswordField su_password;


    @FXML
    private Button login_btn;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;

    //main form

    public void loginAccount(){
        if(username.getText().isEmpty() || password.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Username/Password");
            alert.showAndWait();
        }else{
            String sql = "SELECT * FROM employee WHERE username = '" + username.getText()
                    + "' AND password = '" + password.getText() + "'";
            connect = database.connectDB();
            try{
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();
                if(result.next()){
                    //apabila user dan pass benar
                    data.username = username.getText();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();
                    // link ke main form
                    Parent root = FXMLLoader.load(getClass().getResource("mainForm.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setMinWidth(1100);
                    stage.setMinHeight(600);
                    stage.setTitle("Laundry Shop Management System");
                    stage.setScene(scene);
                    stage.show();
                    // hide tulisan password
                    login_btn.getScene().getWindow().hide();
                }else{
                    // alert utk display error
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Username/Password");
                    alert.showAndWait();
                }
            }catch(Exception e){e.printStackTrace();}
        }
    }

    public void signup() {
        Connection connect = null;
        PreparedStatement prepare = null;

        try {
            connect = database.connectDB();
            String sql = "INSERT INTO employee (username,password) VALUES (?,?)";

            String username = su_username.getText().trim();
            String password = su_password.getText();

            if (username.isEmpty() || password.isEmpty()) {
                showAlert(AlertType.ERROR, "Error Message", "Enter all fields!", "Please fill in both username and password fields.");
                return; // Return early if fields are empty
            }

            if (password.length() < 8) {
                showAlert(AlertType.ERROR, "Error Message", "Invalid Password", "Password must be at least 8 characters long.");
                return; // Return early if password is too short
            }

            // Prepare and execute the SQL statement
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username);
            prepare.setString(2, password);
            prepare.executeUpdate();

            // Clear input fields after successful insertion
            su_username.clear();
            su_password.clear();

            showAlert(AlertType.INFORMATION, "MarcoMan Message", "Account Creation Successful", "Successfully created a new account!");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Database Error", "Failed to create account. Please try again later.");
        } finally {
            // Close resources
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to show alerts
    private void showAlert(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    public void changeForm(ActionEvent event) {
        if (event.getSource() == create_acc) {
            signup_form.setVisible(true);
            signin_form.setVisible(false);
        } else if (event.getSource() == login_acc) {
            signup_form.setVisible(false);
            signin_form.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
