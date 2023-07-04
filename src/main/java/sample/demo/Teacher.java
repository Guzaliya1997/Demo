package sample.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {
    private final StringProperty id_prepodavatelya;
    private final StringProperty  id_instituta;
    private final StringProperty  teachers_name;
    private final StringProperty  position;
    private final StringProperty  work_experience;
    private final StringProperty  qualification;
    public Teacher (){
        id_prepodavatelya= new SimpleStringProperty(this,"id_prepodavatelya");
        id_instituta= new SimpleStringProperty(this,"id_instituta");
        teachers_name =new SimpleStringProperty(this,"teachers_name");
        position= new SimpleStringProperty(this,"position");
        work_experience= new SimpleStringProperty(this,"work_experience");
        qualification= new SimpleStringProperty(this,"qualification");


    }
    public void setId_prepodavatelya(String id_prepodavatelya) {
        this.id_prepodavatelya.set(id_prepodavatelya);
    }

    public void setId_instituta(String id_instituta) {
        this.id_instituta.set(id_instituta);
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public void setWork_experience(String work_experience) {
        this.work_experience.set(work_experience);
    }

    public void setQualification(String qualification) {
        this.qualification.set(qualification);
    }

    public void setTeachers_name(String teachers_name) {
        this.teachers_name.set(teachers_name);
    }


    public String getId_prepodavatelya() {
        return id_prepodavatelya.get();
    }

    public StringProperty id_prepodavatelyaProperty() {
        return id_prepodavatelya;
    }

    public String getId_instituta() {
        return id_instituta.get();
    }

    public StringProperty id_institutaProperty() {
        return id_instituta;
    }

    public String getTeachers_name() {
        return teachers_name.get();
    }

    public StringProperty teachers_nameProperty() {
        return teachers_name;
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public String getWork_experience() {
        return work_experience.get();
    }

    public StringProperty work_experienceProperty() {
        return work_experience;
    }

    public String getQualification() {
        return qualification.get();
    }

    public StringProperty qualificationProperty() {
        return qualification;
    }

}
