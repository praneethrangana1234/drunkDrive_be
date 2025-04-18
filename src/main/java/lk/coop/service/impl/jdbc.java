package lk.coop.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc {

    static String url = "jdbc:mysql://127.0.0.1:3306/drunken_drive?zeroDateTimeBehavior=convertToNull";
    static Connection co = null;
    static Statement st = null;

    public static Connection con() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(url, "root", "root");
        return c;
    }
}
