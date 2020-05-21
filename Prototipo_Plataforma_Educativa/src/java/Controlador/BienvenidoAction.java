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
                int valor=con.Logear(getPassword(),getUsername());
                if(valor>0){
                    switch (valor){
                        case 2:
                            return "Alumno";                          
                        case 3:
                            return "Profesor";                          
                        case 4:
                            return "Administrador";                          
                        default:
                            return "fracaso";  
                        
                    }                    
                }else{
                    return "fracaso";    
                }
                    
		
 
	}
    
}