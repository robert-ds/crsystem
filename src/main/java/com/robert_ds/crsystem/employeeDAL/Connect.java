/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robert_ds.crsystem.employeeDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author robert
 */
public class Connect {
    String strConnect = "jdbc:sqlite:/home/robert/Files/Projects/All Projects Code/Java/crsystem/db/crsystem";
    Connection conn = null;
    
    public Connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConnect);
            
            System.out.println("Connection Ok");
            
        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
        }
    }
    
    /**
     * Method insert new user
     * @param strSQL
     * @return 1 or 0
     */
    public int sqlInsertion(String strSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
            return 0;
        }
    }
    
    /**
     * Method that query registres in database
     * @param strSQL
     * @return response
     */
    public ResultSet queryRegistres(String strSQL) {
      try {
        PreparedStatement pstm = conn.prepareStatement(strSQL);
        ResultSet response = pstm.executeQuery();
        return response;
      } catch (Exception e) {
        System.out.println("Exception: " +e);
        return null;
      }
    }
    
}
