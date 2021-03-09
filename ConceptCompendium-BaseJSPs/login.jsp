<!DOCTYPE html>
<html>
    <head>
        <title>Concept Compendium: Log In</title>
        <meta charset="UTF-8"  />
        <link rel="stylesheet" type="text/css" href="./stylesheets/login.css" />
        <style>@import url('https://fonts.googleapis.com/css?family=Audiowide');</style>
    </head>
    
    <nav class="topBusiness">

    </nav>
  
    <body> 
    
        <header>
            <h1>CONCEPT COMPENDIUM</h1>
            <h2>Log In: Start To Catalog Your Ideas</h2>
        </header>
        
        <section>

        
            <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
                <fieldset id="fieldset">
            <label class="catalogLabels">Username:</label>
                <input type="text" id="username" name="username" value=""/><br />
            <label class="catalogLabels">Password:</label>
                <input type="password" id="password" name="password" />
                </fieldset>
                <br />
                <input type="submit" class="catalogButtons" value="Log In" name="submit" />
            </form>

            
        </section>
        
    </body>
    
</html>
        

    
