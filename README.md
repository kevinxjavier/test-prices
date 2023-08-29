# Getting Started

### Create SpringBoot Project 
```
$ curl https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.3&packaging=jar&jvmVersion=17&groupId=com.kevinpina&artifactId=test-prices&name=test-prices&description=Demo%20project%20for%20PRUEBA%20PRECIOS%20TEXT&packageName=com.kevinpina&dependencies=web,h2,lombok
```

### About tools
* Apache Maven 3.8.6 
* java 18.0.2.1 2022-08-18

### What is requested:
Build an application/service in SpringBoot that provides a rest endpoint such that:

* Accept as input parameters: Application Date, Product Identifier, String Identifier.
* Return as output data: product identifier, chain identifier, rate to apply, dates of application and final price to apply.
* An in-memory database (e.g. h2) must be used and initialized with the data from the example (you can change the name of the fields and add new ones if you want, choose the data type that is considered appropriate for them).

### Develop some tests of the rest endpoint that validates the following requests of the service with the example data:
* Test 1: request at 10:00 a.m. on the 14th for product 35455 for brand 1 (XYZ)
* Test 2: request at 4:00 p.m. on the 14th for product 35455 for brand 1 (XYZ)
* Test 3: request at 9:00 p.m. on day 14th for product 35455 for brand 1 (XYZ)
* Test 4: request at 10:00 a.m. on the 15th for product 35455 for brand 1 (XYZ)
* Test 5: request at 9:00 p.m. on day 16th for product 35455 for brand 1 (XYZ)

### What Will be valued:
* Design and construction of the service.
* Code Quality.
* Correct results in the tests.

### Document
* [Prueba Precios](https://grupoinditex.sharepoint.com/sites/commbrands/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2Fcommbrands%2FShared%20Documents%2FGeneral%2FEquipo%2FEntrevistas%2FPrueba%20Precios%20TEXT%2Epdf&parent=%2Fsites%2Fcommbrands%2FShared%20Documents%2FGeneral%2FEquipo%2FEntrevistas&p=true&ga=1)

### Compile & test & Run
```
$ mvn clean compile package test
$ mvn spring-boot:run
```

### Swagger
* [OpenApi](http://localhost:8080/v3/api-docs)
* [Swagger](http://localhost:8080/swagger-ui.html)
* [Swagger](http://localhost:8080/swagger-ui/index.html)

### Test 
Test can be founds in src/test/java also with a Temrinal or Postman we can test them using the following curls (after running $ mvn spring-boot:run):
```
Test 1 $ curl --location --request GET 'http://localhost:8080/api/price/35455/2020-06-14%2010:00:00'
Test 2 $ curl --location --request GET 'http://localhost:8080/api/price/35455/2020-06-14%2016:00:00'
Test 3 $ curl --location --request GET 'http://localhost:8080/api/price/35455/2020-06-14%2021:00:00'
Test 4 $ curl --location --request GET 'http://localhost:8080/api/price/35455/2020-06-15%2010:00:00'
Test 5 $ curl --location --request GET 'http://localhost:8080/api/price/35455/2020-06-16%2021:00:00'
```
