package sample.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Emp_Schedule {
    private final StringProperty id_raspisaniya;
    private final StringProperty id_distsipliny;
    private final StringProperty id_gruppy;
    private final StringProperty week_day;
    private final StringProperty start_time;
    private final StringProperty end_time;
    private final StringProperty week_type;


    public void setId_raspisaniya(String id_raspisaniya) {
        this.id_raspisaniya.set(id_raspisaniya);
    }

    public void setId_distsipliny(String id_distsipliny) {
        this.id_distsipliny.set(id_distsipliny);
    }

    public void setId_gruppy(String id_gruppy) {
        this.id_gruppy.set(id_gruppy);
    }

    public void setWeek_day(String week_day) {
        this.week_day.set(week_day);
    }

    public void setStart_time(String start_time) {
        this.start_time.set(start_time);
    }

    public void setEnd_time(String end_time) {
        this.end_time.set(end_time);
    }

    public void setWeek_type(String week_type) {
        this.week_type.set(week_type);
    }


    public String getId_raspisaniya() {
        return id_raspisaniya.get();
    }

    public StringProperty id_raspisaniyaProperty() {
        return id_raspisaniya;
    }

    public String getId_distsipliny() {
        return id_distsipliny.get();
    }

    public StringProperty id_distsiplinyProperty() {
        return id_distsipliny;
    }

    public String getEnd_time() {
        return end_time.get();
    }

    public StringProperty end_timeProperty() {
        return end_time;
    }

    public String getId_gruppy() {
        return id_gruppy.get();
    }

    public StringProperty id_gruppyProperty() {
        return id_gruppy;
    }

    public String getWeek_day() {
        return week_day.get();
    }

    public StringProperty week_dayProperty() {
        return week_day;
    }

    public String getStart_time() {
        return start_time.get();
    }

    public StringProperty start_timeProperty() {
        return start_time;
    }

    public String getWeek_type() {
        return week_type.get();
    }

    public StringProperty week_typeProperty() {
        return week_type;
    }

    public Emp_Schedule() {
        id_raspisaniya = new SimpleStringProperty(this, "id_raspisaniya");
        id_distsipliny = new SimpleStringProperty(this, "id_distsipliny");
        id_gruppy = new SimpleStringProperty(this, "id_gruppy");
        week_day = new SimpleStringProperty(this, "week_day");
        start_time = new SimpleStringProperty(this, "start_time");
        end_time = new SimpleStringProperty(this, "end_time");
        week_type = new SimpleStringProperty(this, "week_type");
    }

}

