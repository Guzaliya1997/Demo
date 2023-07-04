package sample.demo;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


public class Emp_Student_Controller extends Configs implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student,String> s_tbl1;

    @FXML
    private TableColumn<Student,String> s_tbl10;

    @FXML
    private TableColumn<Student,String> s_tbl11;

    @FXML
    private TableColumn<Student,String> s_tbl12;

    @FXML
    private TableColumn<Student,String> s_tbl2;

    @FXML
    private TableColumn<Student,String> s_tbl3;

    @FXML
    private TableColumn<Student,String> s_tbl4;

    @FXML
    private TableColumn<Student,String> s_tbl5;

    @FXML
    private TableColumn<Student,String> s_tbl6;

    @FXML
    private TableColumn<Student,String> s_tbl7;

    @FXML
    private TableColumn<Student,String> s_tbl8;

    @FXML
    private TableColumn<Student,String>  s_tbl9;


    @FXML
    private Button st_btn_add;

    @FXML
    private Button st_btn_delete;

    @FXML
    private Button st_btn_update;



    @FXML
    private TextField std_f10;

    @FXML
    private TextField std_f11;

    @FXML
    private TextField std_f12;

    @FXML
    private TextField std_f2;

    @FXML
    private TextField std_f3;

    @FXML
    private TextField std_f4;

    @FXML
    private TextField std_f5;

    @FXML
    private TextField std_f6;

    @FXML
    private TextField std_f7;

    @FXML
    private TextField std_f8;

    @FXML
    private TextField std_f9;

    @FXML
    private Text std_txt1;

    @FXML
    private Text std_txt10;

    @FXML
    private Text std_txt11;

    @FXML
    private Text std_txt12;

    @FXML
    private Text std_txt2;

    @FXML
    private Text std_txt3;

    @FXML
    private Text std_txt4;

    @FXML
    private Text std_txt5;

    @FXML
    private Text std_txt6;

    @FXML
    private Text std_txt7;

    @FXML
    private Text std_txt8;

    @FXML
    private Text std_txt9;

    @FXML
    private Button emp_st_back_btn;


    @FXML
    void Add(ActionEvent event) {

        String users_name,users_group_number,users_date,users_address,users_doc_id,users_grade,users_speciality_id,users_form,
                users_enter,users_graduation,users_payment_method;

        users_name = std_f2.getText();
        users_group_number= std_f3.getText();
        users_date= std_f4.getText();
        users_address=std_f5.getText() ;
        users_doc_id=std_f6.getText() ;
        users_grade=std_f7.getText() ;
        users_speciality_id=std_f8.getText() ;
        users_form= std_f9.getText();
        users_enter=std_f10.getText() ;
        users_graduation=std_f11.getText() ;
        users_payment_method=std_f12.getText();

        try
        {
            pst = con.prepareStatement("INSERT INTO студенты(st_name,group_number,st_birth_date," +
                    "st_address,st_doc_id,st_grade,id_spetsialnosti,st_study_form,st_enter_year," +
                    "st_graduation_year,st_payment_method)VALUES(?,?,?,?,?,?,?,?,?,?,?)");


            pst.setString(1, users_name);
            pst.setString(2, users_group_number);
            pst.setString(3, users_date);
            pst.setString(4, users_address);
            pst.setString(5, users_doc_id);
            pst.setString(6, users_grade);
            pst.setString(7, users_speciality_id);
            pst.setString(8, users_form);
            pst.setString(9, users_enter);
            pst.setString(10, users_graduation);
            pst.setString(11, users_payment_method);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registration");

            alert.setHeaderText("Student Registration");
            alert.setContentText("Record Added!");



            table();

            std_f2.setText("");
            std_f3.setText("");
            std_f4.setText("");
            std_f5.setText("");
            std_f6.setText("");
            std_f7.setText("");
            std_f8.setText("");
            std_f9.setText("");
            std_f10.setText("");
            std_f11.setText("");
            std_f12.setText("");
            std_f2.requestFocus();

        }
        catch (SQLException ex)
        {
            Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void table()
    {

        Connect();
      ObservableList<Student> students = FXCollections.observableArrayList();

        try
        {
            pst = con.prepareStatement("select id_studenta,st_name,group_number,st_birth_date," +
                    "st_address,st_doc_id,st_grade,id_spetsialnosti,st_study_form,st_enter_year,st_graduation_year,st_payment_method  from students.студенты");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Student st = new Student();
                    st.setId_studenta(rs.getString("id_studenta"));
                    st.setSt_name(rs.getString("st_name"));
                    st.setGroup_number(rs.getString("group_number"));
                    st.setSt_birth_date(rs.getString("st_birth_date"));
                    st.setSt_address(rs.getString("st_address"));
                    st.setSt_doc_id(rs.getString("st_doc_id"));
                    st.setSt_grade(rs.getString("st_grade"));
                    st.setId_spetsialnosti(rs.getString("id_spetsialnosti"));
                    st.setSt_study_form(rs.getString("st_study_form"));
                    st.setSt_enter_year(rs.getString("st_enter_year"));
                    st.setSt_graduation_year(rs.getString("st_graduation_year"));
                    st.setSt_payment_method(rs.getString("st_payment_method"));
                    students.add(st);
                }
            }
            table.setItems(students);

            s_tbl1.setCellValueFactory(f -> f.getValue().id_studentaProperty());
            s_tbl2.setCellValueFactory(f -> f.getValue().st_nameProperty());
            s_tbl3.setCellValueFactory(f -> f.getValue().group_numberProperty());
            s_tbl4.setCellValueFactory(f -> f.getValue().st_birth_dateProperty());
            s_tbl5.setCellValueFactory(f -> f.getValue().st_addressProperty());
            s_tbl6.setCellValueFactory(f -> f.getValue().st_doc_idProperty());
            s_tbl7.setCellValueFactory(f -> f.getValue().st_gradeProperty());
            s_tbl8.setCellValueFactory(f -> f.getValue().id_spetsialnostiProperty());
            s_tbl9.setCellValueFactory(f -> f.getValue().st_study_formProperty());
            s_tbl10.setCellValueFactory(f -> f.getValue().st_enter_yearProperty());
            s_tbl11.setCellValueFactory(f -> f.getValue().st_graduation_yearProperty());
            s_tbl12.setCellValueFactory(f -> f.getValue().st_payment_methodProperty());




        }

        catch (SQLException ex)
        {
            Logger.getLogger(Emp_Student_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<Student> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();
                    id_studenta = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_studenta()));
                    std_f2.setText(table.getItems().get(myIndex).getSt_name());
                    std_f3.setText(table.getItems().get(myIndex).getGroup_number());
                    std_f4.setText(table.getItems().get(myIndex).getSt_birth_date());
                    std_f5.setText(table.getItems().get(myIndex).getSt_address());
                    std_f6.setText(table.getItems().get(myIndex).getSt_doc_id());
                    std_f7.setText(table.getItems().get(myIndex).getSt_grade());
                    std_f8.setText(table.getItems().get(myIndex).getId_spetsialnosti());
                    std_f9.setText(table.getItems().get(myIndex).getSt_study_form());
                    std_f10.setText(table.getItems().get(myIndex).getSt_enter_year());
                    std_f11.setText(table.getItems().get(myIndex).getSt_graduation_year());
                    std_f12.setText(table.getItems().get(myIndex).getSt_payment_method());
                }
            });
            return myRow;
        });}
    @FXML
    void Delete(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id_studenta = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_studenta()));
        try
        {
            pst = con.prepareStatement("delete from students.студенты where id_studenta = ? ");
            pst.setInt(1, id_studenta);
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

        String users_name,users_group_number,users_date,users_address,users_doc_id,users_grade,users_speciality_id,users_form,
                users_enter,users_graduation,users_payment_method; ;

        myIndex = table.getSelectionModel().getSelectedIndex();
        id_studenta = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId_studenta()));


        users_name = std_f2.getText();
        users_group_number= std_f3.getText();
        users_date= std_f4.getText();
        users_address=std_f5.getText() ;
        users_doc_id=std_f6.getText() ;
        users_grade=std_f7.getText() ;
        users_speciality_id=std_f8.getText() ;
        users_form= std_f9.getText();
        users_enter=std_f10.getText() ;
        users_graduation=std_f11.getText() ;
        users_payment_method=std_f12.getText();
        try
        {
            pst = con.prepareStatement("update студенты " +
                    "set st_name= ? ,group_number = ?,st_birth_date=?,st_address=?,st_doc_id=?," +
                    "st_grade=?,id_spetsialnosti=?," +
                    "st_study_form=?,st_enter_year=?,st_graduation_year=?,st_payment_method=? where id_studenta= ? ");

            pst.setString(1, users_name);
            pst.setString(2, users_group_number);
            pst.setString(3, users_date);
            pst.setString(4, users_address);
            pst.setString(5, users_doc_id);
            pst.setString(6, users_grade);
            pst.setString(7, users_speciality_id);
            pst.setString(8, users_form);
            pst.setString(9, users_enter);
            pst.setString(10, users_graduation);
            pst.setString(11, users_payment_method);
            pst.setInt(12,id_studenta);
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
    int id_studenta;

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
        emp_st_back_btn.setOnAction(event ->

                {
                    emp_st_back_btn.getScene().getWindow().hide();
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










