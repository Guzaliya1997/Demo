package sample.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Button employee_btn;

    @FXML
    private Button student_btn;

    @FXML
    private Button teacher_btn;

    @FXML
    private Label welcomeText;

    @FXML
    public void initialize(){
       employee_btn.setOnAction(event->{
            employee_btn.getScene().getWindow().hide();
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("second-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root=loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root) );
            stage.showAndWait();
           stage.setResizable(false);
        });
        student_btn.setOnAction(event->{
            employee_btn.getScene().getWindow().hide();
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("student.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root=loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root) );
            stage.showAndWait();
            stage.setResizable(false);
        });
        teacher_btn.setOnAction(event->{
            teacher_btn.getScene().getWindow().hide();
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("teacher.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root=loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root) );
            stage.showAndWait();
            stage.setResizable(false);
        });

    }


}

