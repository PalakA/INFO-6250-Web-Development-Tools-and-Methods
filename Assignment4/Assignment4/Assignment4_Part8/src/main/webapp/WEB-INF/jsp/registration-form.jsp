<%-- 
    Document   : registration-form
    Created on : Oct 27, 2021, 7:29:25 PM
    Author     : palak
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Registration Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Registration Form</h1>
        <form action="register.htm" method="post">
            <div class="row">
                <div class="col-md-2">User Email:</div>
                <div class="col-md-10"><input type="email" name="email" required="required" placeholder="Your Email"/></div>
            </div>
            <div class="row">
                <div class="col-md-2">User Password:</div>
                <div class="col-md-10"><input type="password" name="password" required="required" /></div>
                <div class="col-md-2">Start Date:</div>
                <div class="col-md-10"><input type="date" name="startdate" /></div>
                <div class="col-md-2">About Me:</div>
                <div class="col-md-10"><textarea name="aboutme" rows="5" cols="30"></textarea></div>
                <div class="col-md-2">Gender:</div>
                <div class="col-md-10">
                    <input type="radio" name="gender" value="F"> Female
                    <input type="radio" name="gender" value="M"> Male
                </div>
            </div>
            <br/>
            <input type="submit" class="btn btn-primary btn-lg"/>
        </form>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>

