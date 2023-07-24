# Spring Boot Tutorial

YouTube:
https://www.youtube.com/watch?v=QuvS_VLbGko

Full Source Code Repository
https://github.com/marcobehlerjetbrains/photoz-clone.git


REF1: HTTP DELETE
https://gist.github.com/marcobehlerjetbrains/75f5e082f07def8957fc0234076f7435


Delete a photo with id:
```
(async function deletePhoto(id) {
    await fetch('http://localhost:8888/photos' + id, {
        method: "DELETE"
    })
})(2)
```


REF2: HTTP POST
https://gist.github.com/marcobehlerjetbrains/3b9ed46953f810160e3a47e81f88e027

Create some new photo:
```
(async function createPhoto(){
    let photo = { "fileName": "hello.jpg" };
    await fetch('http://localhost:8888/photos', {
        method: "POST",
        header: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(photo)
    }).then( result => result.text()).
        then( text => alert(text));
})();
```



REF3: upload.html
https://gist.github.com/marcobehlerjetbrains/ccd1df86fdd0ae5193aa143c83e30e5d

````
http://localhost:8888/upload.html
````

REF4: max-file-size vs max-request-size
See comments @ https://stackoverflow.com/a/44332602


REF5: Spring Application Properties
spring.datasource.url=jdbc:h2:file:~/hello2;AUTO_SERVER=TRUE;
H2 Database Engine
Common Application Properties (spring.io)


REF6: Transactional
Spring Transaction Management: @Transactional In-Depth (marcobehler.com)


REF7: Validation & Sanitization
https://spring.io/guides/gs/validating-form-input/
https://www.baeldung.com/spring-boot-bean-validation
https://stackoverflow.com/a/53994470


REF8: What’s next
What is Spring Framework?
https://www.marcobehler.com/guides/spring-framework

What is Spring MVC: @Controllers & RestControllers https://www.marcobehler.com/guides/spring-mvc

How Spring Boot’s Autoconfigurations Work
https://www.marcobehler.com/guides/spring-boot

Create jar-package in terminal:
```
./mvnw clean package
```

Run project from .jar in project folder:
```
cd <PROJECT-FOLDER>/target

dir

java -jar <FILE-NAME>.jar
```
