package sample.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty  id_studenta;
    private final StringProperty  st_name;
    private final StringProperty  group_number;
    private final StringProperty  st_birth_date;
    private final StringProperty  st_address;
    private final StringProperty  st_doc_id;
    private final StringProperty st_grade;
    private final StringProperty  id_spetsialnosti;
    private final StringProperty  st_study_form;
    private final StringProperty  st_enter_year;
    private final StringProperty  st_graduation_year;
    private final StringProperty st_payment_method;


    public Student (){
        id_studenta= new SimpleStringProperty(this,"id_studenta");
        st_name= new SimpleStringProperty(this,"st_name");
        group_number =new SimpleStringProperty(this,"group_number");
        st_birth_date= new SimpleStringProperty(this,"st_birth_date");
        st_address= new SimpleStringProperty(this,"st_address");
        st_doc_id= new SimpleStringProperty(this,"st_doc_id");
        st_grade= new SimpleStringProperty(this,"st_grade");
        id_spetsialnosti= new SimpleStringProperty(this,"id_spetsialnosti");
        st_study_form= new SimpleStringProperty(this,"st_study_form");
        st_enter_year=new SimpleStringProperty(this,"st_enter_year");
        st_graduation_year= new SimpleStringProperty(this,"st_graduation_year");
        st_payment_method = new SimpleStringProperty(this,"st_payment_method");

    }

   public StringProperty idProperty(){return id_studenta;}

    public String getId_studenta() {
        return id_studenta.get();
    }

    public StringProperty id_studentaProperty() {
        return id_studenta;
    }

    public String getSt_name() {
        return st_name.get();
    }

    public StringProperty st_nameProperty() {
        return st_name;
    }

    public String getGroup_number() {
        return group_number.get();
    }

    public StringProperty group_numberProperty() {
        return group_number;
    }

    public String getSt_birth_date() {
        return st_birth_date.get();
    }

    public StringProperty st_birth_dateProperty() {
        return st_birth_date;
    }

    public String getSt_address() {
        return st_address.get();
    }

    public StringProperty st_addressProperty() {
        return st_address;
    }

    public String getSt_doc_id() {
        return st_doc_id.get();
    }

    public StringProperty st_doc_idProperty() {
        return st_doc_id;
    }

    public String getSt_grade() {
        return st_grade.get();
    }

    public StringProperty st_gradeProperty() {
        return st_grade;
    }

    public String getId_spetsialnosti() {
        return id_spetsialnosti.get();
    }

    public StringProperty id_spetsialnostiProperty() {
        return id_spetsialnosti;
    }

    public String getSt_study_form() {
        return st_study_form.get();
    }

    public StringProperty st_study_formProperty() {
        return st_study_form;
    }

    public String getSt_enter_year() {
        return st_enter_year.get();
    }

    public StringProperty st_enter_yearProperty() {
        return st_enter_year;
    }

    public String getSt_graduation_year() {
        return st_graduation_year.get();
    }

    public StringProperty st_graduation_yearProperty() {
        return st_graduation_year;
    }

    public String getSt_payment_method() {
        return st_payment_method.get();
    }

    public StringProperty st_payment_methodProperty() {
        return st_payment_method;
    }

    public void setId_studenta(String id_studenta) {
        this.id_studenta.set(id_studenta);
    }

    public void setSt_name(String st_name) {
        this.st_name.set(st_name);
    }

    public void setGroup_number(String group_number) {
        this.group_number.set(group_number);
    }

    public void setSt_birth_date(String st_birth_date) {
        this.st_birth_date.set(st_birth_date);
    }

    public void setSt_address(String st_address) {
        this.st_address.set(st_address);
    }

    public void setSt_doc_id(String st_doc_id) {
        this.st_doc_id.set(st_doc_id);
    }

    public void setSt_grade(String st_grade) {
        this.st_grade.set(st_grade);
    }

    public void setId_spetsialnosti(String id_spetsialnosti) {
        this.id_spetsialnosti.set(id_spetsialnosti);
    }

    public void setSt_study_form(String st_study_form) {
        this.st_study_form.set(st_study_form);
    }

    public void setSt_enter_year(String st_enter_year) {
        this.st_enter_year.set(st_enter_year);
    }

    public void setSt_graduation_year(String st_graduation_year) {
        this.st_graduation_year.set(st_graduation_year);
    }

    public void setSt_payment_method(String st_payment_method) {
        this.st_payment_method.set(st_payment_method);
    }
}
