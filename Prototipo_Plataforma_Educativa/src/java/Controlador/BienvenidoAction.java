package Controlador;

import Modelo.Conexion;
import java.sql.SQLException;


public class BienvenidoAction 
{
	private String username;
        private String password;
        
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
         
	public String execute() throws ClassNotFoundException, SQLException {
                
                Conexion con= new Conexion();                                              
                if(con.Checar(getPassword(),getUsername())==1){
                    return "exitoso";    
                }else{
                    return "fracaso";    
                }
                    
		
 
	}
    
}