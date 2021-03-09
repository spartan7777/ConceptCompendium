<!DOCTYPE html>
<html>
    <head>
        <title>Concept Compendium: Create Account</title>
        <meta charset="UTF-8"  />
        <link rel="stylesheet" type="text/css" href="./stylesheets/signup.css" />
        <style>@import url('https://fonts.googleapis.com/css?family=Audiowide');</style>
    </head>

    
    <nav class="topBusiness">

    </nav> 
  
    <body> 
    
        <header>
            <h1>CONCEPT COMPENDIUM</h1>
            <h2>Create An Account</h2>
        </header>

        <section>

    
            <p>Please enter your username and desired password to create an account.</p>
            <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
                <fieldset id="fieldset">
                <label class="catalogLabels">Username:</label>
                    <input type="text" id="username" name="username" value=""/><br />
                <label class="catalogLabels">First Name:</label>
                    <input type="text" id="first_name" name="first_name" value=""/><br />
                <label class="catalogLabels">Last Name:</label>
                    <input type="text" id="last_name" name="last_name" value=""/><br />
                <label class="catalogLabels">Password:</label>
                    <input type="password" id="password1" name="password1" /><br />
                <label class="catalogLabels">Password Retype:</label>
                    <input type="password" id="password2" name="password2" /><br />
                </fieldset>
                    <br />
                    <input type="submit" class="catalogButtons" value="Sign Up" name="submit" />
            </form>
        
        </section>
        
    </body>
    
</html>

