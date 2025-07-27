/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

import java.sql.*;

/**
 *
 * @author gpesana
 */
public class Students {
    static String tableName = "students";
    
    int studId;
    String name;
    String address;
    String contact;
    String gender;
    String yearlvl;
    
    public void saveRecord(int studId, String name, String address, String contact, String gender, String yearlvl) {
        ESystem repo = new ESystem();
        repo.DBConnect();
        
        if (repo.isDuplicate(repo.conn, tableName, studId, "studID")) return;
        
        String query = "INSERT INTO " + tableName + " VALUES ("
                + studId + ","
                + "'" + name + "',"
                + "'" + address + "',"
                + "'" + contact + "',"
                + "'" + gender + "',"
                + "'" + yearlvl + "'"
                + ");";
        try {
            repo.statement.executeUpdate(query);
            System.out.println("Insert values SUCCESS! [Students]");
        } catch (Exception ex) {
            System.out.println("Insert values FAILED! [Students]");
            System.out.println(ex);
        }
    }
    
    public void deleteRecord(int studID) {
        ESystem repo = new ESystem();
        repo.DBConnect();
        
        String query = "DELETE FROM " + tableName + " WHERE studID = " + studID;
        try {
            repo.statement.executeUpdate(query);
            System.out.println("Delete Success!");
        } catch (Exception ex) {
            System.out.println("Failed to delete!");
        }
    }
    
    public void updateRecord(int studId, String name, String address, String contact, String gender, String yrLvl) {
        ESystem repo = new ESystem();
        repo.DBConnect();
        
        String query = "UPDATE " + tableName + " SET "+
                "name = '" + name + "', " +
                "address = '" + address + "', " +
                "contact = '" + contact + "', " +
                "gender = '" + gender + "', " +
                "yrLvl = '" + yrLvl + "' " +
                "WHERE studID = " + studId + ";";

        try {
            repo.statement.executeUpdate(query);
            System.out.println("Update Success!");
        } catch (Exception ex) {
            System.out.println("Failed to update!");
            System.out.println(ex);
        }
    }
}


