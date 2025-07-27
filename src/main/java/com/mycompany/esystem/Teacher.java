/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

/**
 *
 * @author gpesana
 */
public class Teacher {

    private static String tableName = "teachers";

    int Tid;
    String Tname;
    String Tadd;
    String Tcontact;
    String Tdept;

    public void saveRecord(int teacherID, String name, String address, String contact, String department) {
        ESystem repo = new ESystem();
        repo.DBConnect();

        if (repo.isDuplicate(repo.conn, tableName, teacherID, "teacherID")) {
            return;
        }

        String query = "INSERT INTO " + tableName + " VALUES ("
                + teacherID + ","
                + "'" + name + "',"
                + "'" + address + "',"
                + "'" + contact + "',"
                + "'" + department + "'"
                + ");";

        try {
            repo.statement.executeUpdate(query);
            System.out.println("Insert values SUCCESS! [teachers]");
        } catch (Exception ex) {
            System.out.println("Insert values FAILED! [teachers]");
            System.out.println(ex);
        }

    }

    public void deleteRecord(int teacherID) {
        ESystem repo = new ESystem();
        repo.DBConnect();

        String query = "DELETE FROM " + tableName + " WHERE teacherID = " + teacherID;

        try {
            repo.statement.executeUpdate(query);
            System.out.println("Delete values SUCCESS! [teachers]");
        } catch (Exception ex) {
            System.out.println("Delete values FAILED! [teachers]");
            System.out.println(ex);
        }
    }

    public void updateRecord(int teacherID, String name, String address, String contact, String department) {
        ESystem repo = new ESystem();
        repo.DBConnect();

        String query = "UPDATE " + tableName + " SET "
                + "name = '" + name + "', "
                + "address = '" + address + "', "
                + "contact = '" + contact + "', "
                + "department = '" + department + "' "
                + "WHERE teacherID = " + teacherID + ";";

        try {
            repo.statement.executeUpdate(query);
            System.out.println("Update values SUCCESS! [teachers]");
        } catch (Exception ex) {
            System.out.println("Update values FAILED! [teachers]");
            System.out.println(ex);
        }
    }
}
