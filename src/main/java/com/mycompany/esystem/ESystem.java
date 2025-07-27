/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.esystem;

import java.sql.*;

/**
 *
 * @author gpesana
 */
public class ESystem {

    Connection conn;
    Statement statement;
    ResultSet resultSet;

    String db;
    static String ipAdd;
    String username;
    String password;

    public static void main(String[] args) {
        StudentsForm studView = new StudentsForm();
        studView.setVisible(true);
    }

    public void DBConnect() {
        try {
            String[] ipArr = {"172.20.10.2", "192.168.254.117", "192.168.56.101"};
            ipAdd = "172.20.10.2";
            db = "1stSem_Sy2025_2026";
            username = "root";
            password = "root";

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + ipArr[0] + ":3306/" + db + "?zeroDateTimeBehavior=CONVERT_TO_NULL", username, password);
            statement = conn.createStatement();
            System.out.println("DB Connected");
        } catch (Exception ex) {
            System.out.println("Connection Error");
        }
    }

    // TODO: remove
    public boolean isDuplicate(Connection connection, String tableName, int id, String idVar) {
        try {
            Statement stmt = connection.createStatement();
            String checkQuery = "SELECT " + idVar + " FROM " + tableName + " WHERE " + idVar + " = " + id;
            ResultSet rs = stmt.executeQuery(checkQuery);

            boolean exists = rs.next(); // true if any result found

            rs.close();
            stmt.close();

            return exists;
        } catch (Exception e) {
            e.printStackTrace(); // optional: return true to be safe
            return true;
        }
    }
}
