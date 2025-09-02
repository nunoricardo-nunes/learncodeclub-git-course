# Device-sales

A simple example of rest API with Spring Boot.
This is a simulation of a project for stores that sell mobile devices. Each device is for sale at a store.

## Getting started

This code can be executed in 2 ways:

1 - More complex path: you can clone the repository and run it on your machine. For this you will need to have Postgresql installed and create a database, then configure access to postgres in your application.properties file.

2 - Simplest path: If you have the docker installed, go to the src/main/docker directory and run the command:
docker-compose up

This will start the Spring Boot application and will also a Postgres database in a docker container.

The endpoints can then be accessed, for example, by Postman.

## Requests
This code contains 4 endpoints:

- POST - add new store
   endpoint: http://localhost:8080/stores
   
   Json Body example:
    {
        "name":"New Store Devices",
        "address":"avenue 15",
        "phone":"222-222-221"
    }

- POST - add new product
   endpoint: http://localhost:8080/products

   Json body example:
   {
        "store":{
                "id": 1
        },
        "brand":"Apple",
        "model":"iphone 11",
        "description":"xpto",
        "price":225.00
   }

- GET - get all stores

  endpoint: http://localhost:8080/stores   

- GET - get product by store

  endpoint: http://localhost:8080/products/store/1


