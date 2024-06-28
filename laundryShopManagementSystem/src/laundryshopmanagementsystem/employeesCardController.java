package laundryshopmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.text.SimpleDateFormat;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import java.sql.Timestamp;

public class employeesCardController implements Initializable {

    @FXML
    private AnchorPane card_form;

    @FXML
    private Label card_employeesID;

    @FXML
    private Label card_employeesusername;

    @FXML
    private Label card_employeesdate;

    private int id;

    public void setData(getEmployees employees) {
        // Assuming getId(), getUsername(), and getTimestamp() are the appropriate getters
        int id = employees.getId();
        String username = employees.getUsername();
        Timestamp timestamp = employees.getTimestamp();

        // Set the data to the corresponding UI components
        card_employeesID.setText(String.valueOf(id));
        card_employeesusername.setText(username);
        card_employeesdate.setText(timestamp.toString());

        // Store the ID if needed (not displayed in UI)
        this.id = id;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code, if any
    }
}
