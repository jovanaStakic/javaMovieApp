/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import java.io.FileInputStream;
import java.util.Properties;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class DBConnection {
    Connection connection;
    private static DBConnection instance;

    private DBConnection() {
    }
    
    public static DBConnection getInstance(){
        if(instance==null)
            instance=new DBConnection();
        return instance;
    }
    
    
    public Connection getConnection() throws Exception{
        Properties properties=new Properties();
        properties.load(new FileInputStream("config/DBconfig.properties"));
        
        String url="jdbc:mysql://localhost:3306/"+properties.getProperty("DB_NAME");
        String user=properties.getProperty("USER");
        String password=properties.getProperty("PASSWORD");
        connection=DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        System.out.println("Uspešno povezivanje sa bazom.");
        return connection;
    }
    
 
    
}
