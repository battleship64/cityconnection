The Application is build in Spring Boot


The Application is divided into 3 layer
    
    DAO
    Service
    Controller
    
Dao serves as the part that get the data from city.txt file to give the list of city and the road connection of city

The Service layer mainly doing the part that check the road connection and bind the city name with index

The Controller layer are used for restful controller which can send true or false as needed

The different component are register and autowired using Spring boot

The algorithm that check the road connection is based on graph and DFS

Because of time limitation, further improvement will be made on the front end part which could showed the all the city in city.txt and make the user can choose from it and showed up the information whether the city is connected or not.   
