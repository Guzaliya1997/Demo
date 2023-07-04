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

public class Emp_Schedule_Controller  extends Configs implements Initializable {
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button add_btn;

        @FXML
        private Button back_btn;

        @FXML
        private Button delete_btn;

        @FXML
        private TableColumn<Emp_Schedule, String> den_nedeli;

        @FXML
        private TableColumn<Emp_Schedule, String> id;

        @FXML
        private TableColumn<Emp_Schedule, String> id_dis;

        @FXML
        private TableColumn<Emp_Schedule, String> id_grup;

        @FXML
        private TableColumn<Emp_Schedule, String> nedelya;

        @FXML
        private Text ras_text2;

        @FXML
        private Text ras_text3;

        @FXML
        private Text ras_text4;

        @FXML
        private Text ras_text5;

        @FXML
        private Text ras_text6;

        @FXML
        private Text ras_text7;

        @FXML
        private TextField ras_txtf2;

        @FXML
        private TextField ras_txtf3;

        @FXML
        private TextField ras_txtf4;

        @FXML
        private TextField ras_txtf5;

        @FXML
        private TextField ras_txtf6;

        @FXML
        private TextField ras_txtf7;

        @FXML
        private TableView<Emp_Schedule> table;

        @FXML
        private Button update_btn;

        @FXML
        private TableColumn<Emp_Schedule, String> vremya_nachala;

        @FXML
        private TableColumn<Emp_Schedule, String> vremyz_okonchaniya;



        @FXML
        void Add(ActionEvent event) {

                String id_distsipliny,id_gruppy,week_day,start_time,end_time,week_type;

                id_distsipliny = ras_text2.getText();
                id_gruppy= ras_text3.getText();
                week_day= ras_text4.getText();
                start_time=ras_text5.getText() ;
                end_time=ras_text6.getText() ;
                week_type=ras_text7.getText() ;


                try
                {
                        pst = con.prepareStatement("INSERT INTO students.расписание(id_raspisaniya,id_distsipliny,id_gruppy,week_day,start_time,end_time,week_type) VALUES(?,?,?,?,?,?,?)");


                        pst.setString(1,id_distsipliny);
                        pst.setString(2,id_gruppy);
                        pst.setString(3, week_day);
                        pst.setString(4, start_time);
                        pst.setString(5, end_time);
                        pst.setString(6, week_type);
                        pst.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Student Registration");

                        alert.setHeaderText("Student Registration");
                        alert.setContentText("Record Added!");



                        table();

                        ras_text2.setText("");
                        ras_text3.setText("");
                        ras_text4.setText("");
                        ras_text5.setText("");
                        ras_text6.setText("");
                        ras_text7.setText("");
                        ras_text2.requestFocus();

                }
                catch (SQLException ex)
                {
                        Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        }


        public void table()
        {

                Connect();
                ObservableList<Emp_Schedule> schedules = FXCollections.observableArrayList();

                try
                {
                        pst = con.prepareStatement("select id_raspisaniya,id_distsipliny,id_gruppy,week_day,start_time,end_time,week_type from students.расписание");
                        ResultSet rs = pst.executeQuery();
                        {
                                while (rs.next())
                                {
                                        Emp_Schedule sch = new Emp_Schedule();
                                        sch.setId_raspisaniya(rs.getString("id_raspisaniya"));
                                        sch.setId_distsipliny(rs.getString("id_distsipliny"));
                                        sch.setId_gruppy(rs.getString("id_gruppy"));
                                        sch.setWeek_day(rs.getString("week_day"));
                                        sch.setStart_time(rs.getString("start_time"));
                                        sch.setEnd_time(rs.getString("end_time"));
                                        sch.setWeek_type(rs.getString("week_type"));
                                        schedules.add(sch);
                                }
                        }
                        table.setItems(schedules);

                        id.setCellValueFactory(f -> f.getValue().id_raspisaniyaProperty());
                        id_dis.setCellValueFactory(f -> f.getValue().id_distsiplinyProperty());
                        id_grup.setCellValueFactory(f -> f.getValue().id_gruppyProperty());
                        den_nedeli.setCellValueFactory(f -> f.getValue().week_dayProperty());
                        vremya_nachala.setCellValueFactory(f -> f.getValue().start_timeProperty());
                        vremyz_okonchaniya.setCellValueFactory(f -> f.getValue().end_timeProperty());
                        nedelya.setCellValueFactory(f -> f.getValue().week_typeProperty());
                }

                catch (SQLException ex)
                {
                        Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                table.setRowFactory( tv -> {
                        TableRow<Emp_Schedule> myRow = new TableRow<>();
                        myRow.setOnMouseClicked (event ->
                        {
                                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                                {
                                        myIndex =  table.getSelectionModel().getSelectedIndex();
                                        id_raspisaniya = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_raspisaniya()));
                                        ras_text2.setText(table.getItems().get(myIndex).getId_distsipliny());
                                        ras_txtf3.setText(table.getItems().get(myIndex).getId_gruppy());
                                        ras_text4.setText(table.getItems().get(myIndex).getWeek_day());
                                        ras_text5.setText(table.getItems().get(myIndex).getStart_time());
                                        ras_text6.setText(table.getItems().get(myIndex).getEnd_time());
                                        ras_text7.setText(table.getItems().get(myIndex).getWeek_type());

                                }
                        });
                        return myRow;
                });}
        @FXML
        void Delete(ActionEvent event) {
                myIndex = table.getSelectionModel().getSelectedIndex();
                id_raspisaniya = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_raspisaniya()));
                try
                {
                        pst = con.prepareStatement("delete from students.расписание where id_raspisaniya = ? ");
                        pst.setInt(1, id_raspisaniya);
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

                String id_distsipliny,id_gruppy,week_day,start_time,end_time,week_type;

                myIndex = table.getSelectionModel().getSelectedIndex();
                id_raspisaniya = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_raspisaniya()));


                id_distsipliny = ras_text2.getText();
                id_gruppy= ras_text3.getText();
                week_day= ras_text4.getText();
                start_time=ras_txtf5.getText() ;
                end_time=ras_txtf6.getText() ;
                week_type=ras_text7.getText() ;
                try
                {
                        pst = con.prepareStatement("update students.расписание " +
                                "set id_distsipliny= ? , id_gruppy = ?, week_day=?, start_time=?,end_time=?,week_type=? where id_raspisaniya= ? ");

                        pst.setString(1,id_distsipliny);
                        pst.setString(2, id_gruppy);
                        pst.setString(3, week_day);
                        pst.setString(4, start_time);
                        pst.setString(5, end_time);
                        pst.setString(6, week_type);
                        pst.setInt(7,id_raspisaniya);
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
        int id_raspisaniya;

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




