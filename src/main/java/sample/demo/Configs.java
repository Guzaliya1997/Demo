package sample.demo;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class Configs {
    protected String dbHost="localhost";
    protected String dbPort = "3306";
    protected String dbUser="root";
    protected String dbPass ="g1u5z7";
    protected String dbName="students";

    public abstract void initialize(URL url, ResourceBundle rb);
}
