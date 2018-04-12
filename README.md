#docker-demo

This project is a playground for dockers. In main directory there are four modules.

Flyway module - docker container for flyway tool. Purpose of this docker is populating
a database.

screening-server module - web app for CRUD operations on Screenings. Simple controller-service-repository structure.

screening-parser - parsing cinema's screening information from cinema's website. To accomplished that,
selenium was used. To run this module, user need to add chromedriver file in resources directory. 
It is not attached in this repository. Module is in progress, so test class is used as quick look-up 
how parsing is working.

screening-api - common part of model for server and parser modules. It is connected with them by maven's pom.

Key element of project is docker-compose.yml. It describes running details for server module, postgres database, flyway.
Server and flyway are waiting for completed setup of database. It is accomplished by using script wait-for-it.
To use that each dockerfile was written from scratch.

Because project is developing on Windows environment and docker is not a native technology for this OS, at this point it 
cannot be run on linux without changes. Running on windows need to setup proper visibility between host and VM. Without it
docker volumes won't work.

Target workflow of app:
1. Parsing data each day using Quartz
2. Saving it to database
3. users can vote for certain screening (like doodle app but for movie screenings)

TODO:   
1. screening-parser:
    * Dockerfile
    * finish functionality  
2. vote-server module
    * entire module      
3. General:
    * move wait-for-it to global resource folder
    * clean up parent pom
    * connect modules's poms to parent pom
    * make project available for linux OS
    * add maven-docker compatibility - now dockerfiles assume that there are jars file in target directory   
    
    


