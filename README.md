# Spring Boot Api to Fetch data from Sql and convert it into Json

This code contains a simple spring boot api which connects with the sql database and fetches the data and then converts that data into json format.
#### Steps

  - Make a simple spring application with web and jasper dependency
  - Make a connection with mysql database
  - execute a desirable query
  - make a pojo class with proper variables to store the data
  - make an object of pojo class
  - make array list of that object
  - iterarte over your sql output and add it to arraylist
  - now use gson library to conver the array list to json output
  - use jasper dependency to ouput the outcome on webpage.
