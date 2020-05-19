/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conexion {

    public Conexion() {
    }
     
    public int Checar(String password, String user) throws ClassNotFoundException, SQLException{
        ResultSet rs=null;    
        Class.forName("com.mysql.jdbc.Driver");
        Connection db = DriverManager.getConnection("jdbc:mysql://localhost/DB2","root", "root");
        Statement s = db.createStatement();
        rs=s.executeQuery("SELECT * FROM Users");
            
        while(rs.next())
            {
                if(rs.getString("id1").equals(user)&&rs.getString("clave").equals(password)) return 1;
            }     
        return 0;
    }
    
}
