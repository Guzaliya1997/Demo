package sample.demo;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Emp_Teacher_Controller extends Configs implements Initializable {

        @FXML
        private TableView<Teacher> table;
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button add_btn;

        @FXML
        private Button delete_btn;
        @FXML
        private TableColumn<Teacher, String> id_prepod ;
        @FXML
        private TableColumn<Teacher, String> dolzhnost;

        @FXML
        private TableColumn<Teacher, String> fio_prerod;

        @FXML
        private TableColumn<Teacher, String> grade;

        @FXML
        private TableColumn<Teacher, String> id_instituta;


        @FXML
        private TextField prep_txtf1;

        @FXML
        private TextField prep_txtf2;

        @FXML
        private TextField prep_txtf3;

        @FXML
        private TextField prep_txtf4;

        @FXML
        private TextField prep_txtf5;

        @FXML
        private TextField prep_txtf6;

        @FXML
        private ScrollBar scroll;

        @FXML
        private TableColumn<Teacher, String> stazh;

        @FXML
        private Text txt1;

        @FXML
        private Text txt2;

        @FXML
        private Text txt3;

        @FXML
        private Text txt4;

        @FXML
        private Text txt5;

        @FXML
        private Text txt6;

        @FXML
        private Button update_btn;

        @FXML
        private Button back_btn;


        @FXML
        void Add(ActionEvent event) {

                String id_instituta,teachers_name,position,work_experience,qualification;

                id_instituta = prep_txtf2.getText();
                teachers_name= prep_txtf3.getText();
                position= prep_txtf4.getText();
                work_experience=prep_txtf5.getText() ;
                qualification=prep_txtf6.getText() ;


                try
                {
                        pst = con.prepareStatement("INSERT INTO students.преподаватели(id_instituta,teachers_name,position,work_experience,qualification) VALUES(?,?,?,?,?)");


                        pst.setString(1, id_instituta);
                        pst.setString(2, teachers_name);
                        pst.setString(3, position);
                        pst.setString(4, work_experience);
                        pst.setString(5, qualification);
                        pst.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Student Registration");

                        alert.setHeaderText("Student Registration");
                        alert.setContentText("Record Added!");



                        table();

                        prep_txtf2.setText("");
                        prep_txtf3.setText("");
                        prep_txtf4.setText("");
                        prep_txtf5.setText("");
                        prep_txtf6.setText("");
                        prep_txtf2.requestFocus();

                }
                catch (SQLException ex)
                {
                        Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        }


        public void table()
        {

                Connect();
                ObservableList<Teacher> teachers = FXCollections.observableArrayList();

                try
                {
                        pst = con.prepareStatement("select id_prepodavatelya,id_instituta,teachers_name,position," +
                                "work_experience,qualification  from students.преподаватели");
                        ResultSet rs = pst.executeQuery();
                        {
                                while (rs.next())
                                {
                                        Teacher tch = new Teacher();
                                        tch.setId_prepodavatelya(rs.getString("id_prepodavatelya"));
                                        tch.setId_instituta(rs.getString("id_instituta"));
                                        tch.setTeachers_name(rs.getString("teachers_name"));
                                        tch.setPosition(rs.getString("position"));
                                        tch.setWork_experience(rs.getString("work_experience"));
                                        tch.setQualification(rs.getString("qualification"));
                                        teachers.add(tch);
                                }
                        }
                        table.setItems(teachers);

                        id_prepod.setCellValueFactory(f -> f.getValue().id_prepodavatelyaProperty());
                        id_instituta.setCellValueFactory(f -> f.getValue().id_institutaProperty());
                        fio_prerod.setCellValueFactory(f -> f.getValue().teachers_nameProperty());
                        dolzhnost.setCellValueFactory(f -> f.getValue().positionProperty());
                        stazh.setCellValueFactory(f -> f.getValue().work_experienceProperty());
                        grade.setCellValueFactory(f -> f.getValue().qualificationProperty());
                }

                catch (SQLException ex)
                {
                        Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                table.setRowFactory( tv -> {
                        TableRow<Teacher> myRow = new TableRow<>();
                        myRow.setOnMouseClicked (event ->
                        {
                                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                                {
                                        myIndex =  table.getSelectionModel().getSelectedIndex();
                                        id_prepodavatelya = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_prepodavatelya()));
                                        prep_txtf2.setText(table.getItems().get(myIndex).getId_instituta());
                                        prep_txtf3.setText(table.getItems().get(myIndex).getTeachers_name());
                                        prep_txtf4.setText(table.getItems().get(myIndex).getPosition());
                                        prep_txtf5.setText(table.getItems().get(myIndex).getWork_experience());
                                        prep_txtf6.setText(table.getItems().get(myIndex).getQualification());

                                }
                        });
                        return myRow;
                });}
        @FXML
        void Delete(ActionEvent event) {
                myIndex = table.getSelectionModel().getSelectedIndex();
                id_prepodavatelya = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_prepodavatelya()));
                try
                {
                        pst = con.prepareStatement("delete from students.преподаватели where id_prepodavatelya = ? ");
                        pst.setInt(1, id_prepodavatelya);
                        pst.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Student Registration");

                        alert.setHeaderText("Student Registration");
                        alert.setContentText("Deleted!");

                        alert.showAndWait();
                        table();
                }
                catch (SQLException ex)
                {
                        Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        @FXML
        void Update(ActionEvent event) {

                String id_instituta,teachers_name,position,work_experience,qualification;

                myIndex = table.getSelectionModel().getSelectedIndex();
                id_prepodavatelya = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_prepodavatelya()));


                id_instituta = prep_txtf2.getText();
                teachers_name= prep_txtf3.getText();
                position= prep_txtf4.getText();
                work_experience=prep_txtf5.getText() ;
                qualification=prep_txtf6.getText() ;

                try
                {
                        pst = con.prepareStatement("update преподаватели " +
                                "set id_instituta= ? ,teachers_name = ?,position=?,work_experience=?,qualification=? where id_prepodavatelya= ? ");

                        pst.setString(1, id_instituta);
                        pst.setString(2, teachers_name);
                        pst.setString(3, position);
                        pst.setString(4, work_experience);
                        pst.setString(5, qualification);
                        pst.setInt(6,id_prepodavatelya);
                        pst.executeUpdate();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Student Registration");

                        alert.setHeaderText("Student Registration");
                        alert.setContentText("Updated!");

                        alert.showAndWait();
                        table();
                }
                catch (SQLException ex)
                {
                        Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        Connection con;
        PreparedStatement pst;
        int myIndex;
        int id_prepodavatelya;

        public void Connect ()
        {
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/students",dbUser,dbPass);
                } catch (ClassNotFoundException ex) {

                } catch (SQLException ex) {
                        ex.printStackTrace();
                }
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {

                initialize_back();
                Connect();
                table();

        }

        @FXML
        public void initialize_back() {
                back_btn.setOnAction(event ->

                {
                        back_btn.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("second-view.fxml"));
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
                });}}



