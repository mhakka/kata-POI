## Run the application
To run the application, execute:

```
mvn clean package && java -jar target/POI-0.1-SNAPSHOT.jar
```


## Call the Web service

* Calculate the number of points of interest of an area (Question 1) exemple:
  ```
  http://localhost:8080/poiapi/count?area_minlat=6.5&area_maxlat=7&area_minlon=-7&area_maxlon=-6.5
  ```

* Find the N densest areas (Question 2) exemple:
  ```
  http://localhost:8080/poiapi/densestareas?limit=2
  ```

