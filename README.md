### Start project
```
./mvnw spring-boot:run
```

### Start project DEBUG
```
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
```

## Docker
### Build image
```
docker build -t customer-queue . 
```