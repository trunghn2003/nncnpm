/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nncnpm;

/**
 *
 * @author hoang
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection getConnection() throws SQLException {
//        String url = "jdbc:sqlserver://localhost;databaseName=nncnpm;user=sa;password=123456;encrypt=true;trustServerCertificate=true";
String url = "jdbc:sqlserver://localhost;databaseName=nncnpm;user=sa;password=123456;encrypt=true;trustServerCertificate=true";


        
        return DriverManager.getConnection(url);
    }
}