# Amaris Challenge


### Stack used
- Java 8
- H2
- Apache Maven 3.5
- Spring Boot 2.6.7

### Instructions for installation with Maven

+ **With Maven:**
    + Run the command: mvn clean install
    + Run the command: mvn spring-boot:run

### Uso
Once the application is up and running, the API endpoints can be tested locally using a client
REST [Postman](https://www.getpostman.com/) or from the console if you have cURL installed.

API Get prices
-----
#### Get prices by parameters
```
GET localhost:8081/api/prices?dateApply=2020-06-14 16:00:00&brandId=1&productId=35455
```
```
Response: 200 - OK
{
    "message": "petición a las 16 del día 14 del producto 35455 para la brand Zara",
    "prices": {
        "id": 2,
        "brand": {
            "id": 1,
            "brand": "Zara"
        },
        "startDate": "2020-06-14T15:00:00.000-05:00",
        "endDate": "2020-06-14T18:30:00.000-05:00",
        "priceList": 2,
        "product": {
            "id": 35455,
            "name": "Pantalon"
        },
        "priority": 1,
        "price": 25.45,
        "curr": "EUR"
    }
}
```