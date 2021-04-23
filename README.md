# Project 1
Full stack Application for Athletes to search available workout data to see if there is someone to run with on a certain day. Includes main login page which then redriects user to either an admin page or basic user page

## User Features
- [x] Landing page with login authentification
- [x] Reads in workout data from each athlete in a .csv file and stores in java collection
- [ ] Session tracking/security and limiting access to each page (remove direct access to html pages)
- [x] Checks database for username and password credentials  
- [x] If admin credentials are entered app redirects to admin dashboard. Functionality:
   - [x] Search and return for all workouts from the database. Display in table
   - [x] Search and return for all users registered in the database
   - [x] Add a new user to the database
   - [x] Delete a user and all their workouts
- [x] If user credentials are entered, app checks username and password and redirects to admin user. Functionality:
   - [x] Can display only that user's workouts for the week
   - [x] Can delete a workout
   - [x] Can add a workout
   - [x] Search the database for another workout partner
   - [x] Returns either the name of matching athlete or message that there are no matches
   - [ ] Data/response returned to html page
- [x] Allows user to store workout data in the database after search
- [x] Connected successfully to database
- [x] Program can return and store data successfully from the database

## Application Features
- [x] README included
- [x] Junit testing complete
- [x] Integration(database) testing complete
- [] JS Testing - Jest
- [x] Log 4j Logging incorporated
- [x] Pushed to GitHub
- [x] Tomcat as application server
- [x] Pages HTML, CSS and Bootstrap based
- [x] Gradle
- [x] Postgres Database
- [x] Docker as container for DB
- [x] Java EE (javax) Servlets
- [x] Javascript to render data from Servlets
- [x] Data input uses Fetch()
- [ ] SQL Normalization: 3NF 
- [x] MVC
- [x] Data Access Object
- [x] Dependency injection
- [?] Front Controller
- [?] Business Delegate
- [?] Anemic/DD

## Functionality
- [x] Agile User Stories
- [x] CRUD - Create, Read, Update, Delete
- [x] Web App dashboard interface
- [x] Asynchronous interface updates
- [x] Login - Authentication & Authorization
- [] Database persistance
- [x?] Session management

## Instructions for Use 
- Login page for either admin or regular user
- Initial user and workout data is loaded internally from csv file
- Depending on user or admin credentials you will be routed to the appropriate landing page
- For admin you will have access to:
  - Can view all user’s workouts
  - Can view all users and passwords
  - Can add a user
   -Can delete a workout
- For User you ill have access to:
  - View his/her individual workouts
  - Delete a workout
  - Add a workout
   -Search for another athlete to run with


