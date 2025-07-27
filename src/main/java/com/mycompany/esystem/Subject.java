/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

/**
 *
 * @author giann
 */
public class Subject {
    static String tableName = "subjects";
    
    int subjID;
    String subjCode;
    String subjDesc;
    int subjUnits;
    String sched;
    
    
    public void saveRecord(int subjectID, String code, String description, int units, String schedule) {
        ESystem repo = new ESystem();
        repo.DBConnect();
        
        if (repo.isDuplicate(repo.conn, tableName, subjectID, "subjectID")) return;
        
        String query = "INSERT INTO " + tableName + " VALUES ("
                + subjectID + ","
                + "'" + code + "',"
                + "'" + description + "',"
                + "" + units + ","
                + "'" + schedule + "'"
                + ");";
        try {
            repo.statement.executeUpdate(query);
            System.out.println("Insert values SUCCESS! [subjects]");
        } catch (Exception ex) {
            System.out.println("Insert values FAILED! [subjects]");
        }
        
    }
    
    public void deleteRecord(int subjectID) {
        ESystem repo = new ESystem();
        repo.DBConnect();
        
        String query = "DELETE FROM " + tableName + " WHERE subjectID = " + subjectID;
        try {
            repo.statement.executeUpdate(query);
            System.out.println("Delete values SUCCESS! [subjects]");
        } catch (Exception ex) {
            System.out.println("Delete values FAILED! [subjects]");
        }
    }
    
    public void updateRecord(int subjectID, String code, String description, int units, String schedule) {
        ESystem repo = new ESystem();
        repo.DBConnect();
        
        String query = "UPDATE " + tableName + " SET "+
                "code = '" + code + "', " +
                "description = '" + description + "', " +
                "units = " + units + ", " +
                "schedule = '" + schedule + "' " +
                "WHERE teacherID = " + subjectID + ";";

        try {
            repo.statement.executeUpdate(query);
            System.out.println("Update values SUCCESS! [subjects]");
        } catch (Exception ex) {
            System.out.println("Update values FAILED! [subjects]");
            System.out.println(ex);
        }
    }
    
}
