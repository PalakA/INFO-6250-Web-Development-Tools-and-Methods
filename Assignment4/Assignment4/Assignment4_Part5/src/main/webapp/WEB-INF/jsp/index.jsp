<!DOCTYPE html>
<html>
    <head>
        <title>Books Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="action.htm" method="post">
            <input type="hidden" name="action" value="addbooks"/>
            <h1>How many books do you wish to add?</h1>
            <input name="num" required="required"/>
            <button type="submit" value="submit">Submit</button>
        </form>
    </body>
</html>