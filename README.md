# Spring Grpc Http

Simple example about How to build GRPC and HTTP API with Spring-boot.

## Running the Application
1. maven command to generate compiled protos
    ```sh
    mvn clean compile
    ```
2.  maven command to run spring-boot application 
   ```sh
    mvn spring-boot:run
   ```
3. Sending curl request
   ```sh
   curl --location --request POST 'http://localhost:8001/api/demo' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "days": 11,
   "months": 11,
   "years": 2011,
   "message": "Hi"
   }'
   ```

### Validation
[Step 3]() can be ignored if you are validating using postman.

Response:-
```
{
  "time": "Fri Nov 11 00:00:00 IST 2011",
  "message": "Hi"
}
``` 
