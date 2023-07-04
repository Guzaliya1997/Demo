package sample.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teacher_Controller extends Configs implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


        @FXML
        private AnchorPane anchor;

        @FXML
        private Button back_btn;

        @FXML
        private TableColumn<Schedule, String> end_time;

        @FXML
        private TableColumn<Schedule, String> group_number;

        @FXML
        private Label label;

        @FXML
        private TableColumn <Schedule, String> start_time;

        @FXML
        private TableColumn <Schedule, String> subject_name;

        @FXML
        private TableView<Schedule> table;

        @FXML
        private TableColumn <Schedule, String> teachers_name;

        @FXML
        private Text txt;

        @FXML
        private TextField txt_f;

        @FXML
        private TableColumn <Schedule, String> week_day;

        @FXML
        private TableColumn <Schedule, String> week_type;

    @FXML
    void schedule_check(ActionEvent event) {

        table(txt_f);

    }

    public void table(TextField txt_f) {
        String  TeachersName = txt_f.getText();
        Connect();
        ObservableList<Schedule> teachSchedule = FXCollections.observableArrayList();
        try (PreparedStatement pst = con.prepareStatement
                ("SELECT subject_name,group_number,week_day,week_type,start_time,end_time,teachers_name " +
                        "FROM students.расписание " +
                        "join students.дисциплины ON расписание.id_distsipliny= дисциплины.id_distsipliny " +
                        "join students.преподаватели\n" +
                        "ON  дисциплины.id_prepodavatelya=преподаватели.id_prepodavatelya join students.группы ON расписание.id_gruppy=группы.id_gruppy\n" +
                        "Where преподаватели.teachers_name=?")) {
            pst.setString(1, TeachersName);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Schedule sch = new Schedule();
                    sch.setSubject_name(rs.getString("subject_name"));
                    sch.setGroup_number(rs.getString("group_number"));
                    sch.setWeek_day(rs.getString("week_day"));
                    sch.setWeek_type(rs.getString("week_type"));
                    sch.setStart_time(rs.getString("start_time"));
                    sch.setEnd_time(rs.getString("end_time"));
                    sch.setTeachers_name(rs.getString("teachers_name"));
                    teachSchedule.add(sch);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            table.setItems(teachSchedule);
            subject_name.setCellValueFactory(f -> f.getValue().subject_nameProperty());
            group_number.setCellValueFactory(f -> f.getValue().group_numberProperty());
            week_day.setCellValueFactory(f -> f.getValue().week_dayProperty());
            week_type.setCellValueFactory(f -> f.getValue().week_typeProperty());
            start_time.setCellValueFactory(f -> f.getValue().start_timeProperty());
            end_time.setCellValueFactory(f -> f.getValue().end_timeProperty());
            teachers_name.setCellValueFactory(f -> f.getValue().teachers_nameProperty());
        } catch (SQLException ex) {
            Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Connection con;

    private static final Logger LOGGER = Logger.getLogger(Student_Controller.class.getName());

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/students", dbUser, dbPass);
            LOGGER.log(Level.INFO, "Connected to database");
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "JDBC driver not found", ex);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error connecting to database", ex);
        }
    }

    @Override
    public void initialize (URL url, ResourceBundle rb){
        schedule_check(new ActionEvent());
        initialize_back();
        Connect();
        table(txt_f);

        txt_f.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Call table() with the group number entered in txt_f
                table(txt_f);
            }
        });

    }

    @FXML
    public void initialize_back () {
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

