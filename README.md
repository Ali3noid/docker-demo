#docker-demo

###Features:
    
1. Separate dockers for:
    * screening server
    * postgresql database
    * flyway to populate database structures
    * TODO:
        * screening-parser
        * screening-api
2. screening-server:
    * spring-boot controller-service-repository
    * flyway creating structure
    * hibernate synchronized with flyway structure
3. screening-parser:
    * hibernate synchronized with flyway structure
    * connected with screening-api module
    * TODO
        * Dockerfile
        * functionality
4. screening-api:
    * common screening model for other modules         
5. TODO:
    * move wait-for-it to global resource folder
    * write parent pom
    * connect poms
    


