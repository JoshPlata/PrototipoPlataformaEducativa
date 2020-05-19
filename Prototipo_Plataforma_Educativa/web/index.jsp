<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
    
    <head>
        <title>Login</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <link href="Bootstrap/css/singin.css" rel="stylesheet"/>     
    </head>
    
<body class="text-center">    
    <div class="container">
        
        <h1>Prototipo de Plataforma Educativa</h1>
            
            <div class="row justify-content-center">
            <div class="col-4">
                
                <s:form action="/Usuario/Bienvenido" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal">Porfavor ingresa</h1>

                        <label for="inputEmail" class="sr-only">Email address</label>
                        <input name= "username" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>

                        <label for="inputPassword" class="sr-only">Password</label>
                        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                        <h6> Registrate </h6>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

                </s:form>
                        
            </div>
            </div>
            
        
    </div>
</body>
</html>
