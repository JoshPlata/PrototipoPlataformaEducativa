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
        Connection db = DriverManager.getConnection("jdbc:mysql://localhost/Prototipo_Pla_DB","root", "root");
        Statement s = db.createStatement();
        rs=s.executeQuery("SELECT * FROM Usuario");
            
        while(rs.next())
            {
                if(rs.getString("email").equals(user)&&rs.getString("contrasena").equals(password)) return 1;
            }     
        return 0;
    }
    
}
