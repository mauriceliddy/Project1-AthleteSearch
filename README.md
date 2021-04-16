This version uses a TOmcat server (not embedded)
COnnect to postgres using docker containers
FUnctionality so far:
- Landing page with login
- Static password identification
- leads to admin page where:
 - On refresh page, will make call to database and return all athletes in the athletes table:
 - JS makes fetch call to uri(Servlet) that makes call to db to return the list of athletes
 - That servlet grabs the data from db, parses into json using jackson and then returns the json data to JS
 - JS(main.js) then displays those objects on the .html page dynamically by pressing the 'click me' button under 'list of registered athletes'
 - Other functionality:
    - Also add athlete to db works
    - Retrieve all as json also works (refresh) 