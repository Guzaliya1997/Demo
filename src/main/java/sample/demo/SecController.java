package sample.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SecController {
    @FXML
    private Button back_btn;
    @FXML
    private Button add1;

    @FXML
    private Button add2;

    @FXML
    private Button add3;

    @FXML
    private Button delete1;

    @FXML
    private Button delete2;

    @FXML
    private Button delete3;

    @FXML
    private Button edit1;

    @FXML
    private Button edit2;

    @FXML
    private Button edit3;

    @FXML
    private Text txt1;

    @FXML
    private Text txt2;

    @FXML
    private Text txt3;

    @FXML
    private Button watch1;

    @FXML
    private Button watch2;

    @FXML
    private Button watch3;

    @FXML
    private Label welcomeText;

    @FXML
    public void initialize() {
        initialize_pre();
        initialize_ras();
        initialize_back();
        watch1.setOnAction(event ->

                {
                    watch1.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("emp_student.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                   //tage.setResizable(false);
                }

        );
    }
    @FXML
    public void initialize_pre() {
        watch2.setOnAction(event ->

                {
                    watch2.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("emp_prepod.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                    stage.setResizable(false);
                }

        );
    }
    @FXML
    public void initialize_ras() {
        watch3.setOnAction(event ->

                {
                    watch3.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("emp_raspisanie.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                   // stage.setResizable(false);
                }

        );
    }
    @FXML
    public void initialize_back() {
        back_btn.setOnAction(event ->

                {
                    back_btn.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("hello-view.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                    stage.setResizable(false);

                }

        );
    }
}


