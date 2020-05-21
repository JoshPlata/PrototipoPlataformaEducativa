<%-- 
    Document   : Registro
    Created on : 20/05/2020, 12:41:38 PM
    Author     : Josh Plata
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <link href="../Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <link href="../Bootstrap/css/singin.css" rel="stylesheet"/>     
    </head>
    
    <body>
        <div class="col align-self-center">
            <h1> Registro </h1>
        </div>        
            <div class="col align-self-center">
                <s:form action="/Usuario/Registro" class="form-signin">
                    
                        Correo: <input name= "username" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                        Nombre:<input name="Nombre" type="text"  class="form-control" placeholder="Nombre" required>
                        Apellido Paterno: <input name="text" type="password"  class="form-control" placeholder="Apellido Paterno" required>
                        Apellido Materno:<input name="text" type="password"  class="form-control" placeholder="Apellido Materno" required>
                        Boleta:<input name="boleta" type="text"  class="form-control" placeholder="Boleta" required>
                        Rol:<select name="rol" type="text" class="form-control" required>                                               
                               <option value="1">Alumno</option> 
                               <option value="2">Profesor</option> 
                               <option value="3">Administrador</option>   
                            </select>                        
                        Contraseña:<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>                                                                        
                        <br>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Registrar</button>
                    
                </s:form>
            </div>
    </body>
</html>
