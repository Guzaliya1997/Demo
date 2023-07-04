package sample.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Schedule {

    private final StringProperty subject_name;
    private final StringProperty group_number;
    private final StringProperty  week_day;
    private final StringProperty  week_type;
    private final StringProperty  start_time;
    private final StringProperty  end_time;
    private final StringProperty  teachers_name;




    public String getSubject_name() {
        return subject_name.get();
    }

    public StringProperty subject_nameProperty() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name.set(subject_name);
    }

    public String getWeek_day() {
        return week_day.get();
    }

    public StringProperty week_dayProperty() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day.set(week_day);
    }

    public String getGroup_number() {
        return group_number.get();
    }

    public StringProperty group_numberProperty() {
        return group_number;
    }

    public void setGroup_number(String start) {
        this.group_number.set(start);
    }

    public String getStart_time() {
        return start_time.get();
    }

    public StringProperty start_timeProperty() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time.set(start_time);
    }

    public String getEnd_time() {
        return end_time.get();
    }

    public StringProperty end_timeProperty() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time.set(end_time);
    }
    public String getWeek_type() {
        return week_type.get();
    }

    public StringProperty week_typeProperty() {
        return week_type;
    }

    public void setWeek_type(String week_type) {
        this.week_type.set(week_type);
    }
    public String getTeachers_name() {
        return teachers_name.get();
    }

    public StringProperty teachers_nameProperty() {
        return teachers_name;
    }

    public void setTeachers_name(String teachers_name) {
        this.teachers_name.set(teachers_name);
    }

    public Schedule()
    {

        subject_name= new SimpleStringProperty(this, "subject_name");
        week_day = new SimpleStringProperty(this, "week_day");
        group_number = new SimpleStringProperty(this, "group_number");
        start_time = new SimpleStringProperty(this, "start_time");
        end_time = new SimpleStringProperty(this, "end_time");
        week_type = new SimpleStringProperty(this, "week_type");
        teachers_name = new SimpleStringProperty(this, "teachers_name");
    }
}
