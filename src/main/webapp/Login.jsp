
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href='https://use.fontawesome.com/releases/v5.8.1/css/all.css'>
    <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
    <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <form class="box" action="login" method="post">
                        <h1>Login</h1>
                        <input type="text" name="username" placeholder="Username"> 
                        <input type="password" name="password" placeholder="Password"> 
                        <input type="submit" name="" value="Login">
                        <p class="forgot text-muted">Forgot password? Contact to Admin</p> 
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
