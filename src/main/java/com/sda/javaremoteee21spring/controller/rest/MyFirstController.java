package com.sda.javaremoteee21spring.controller.rest;

import com.sda.javaremoteee21spring.dto.Person;
import com.sda.javaremoteee21spring.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyFirstController {

    private final MyService service;


    // @Slf4j does this :
    private static final Logger log = LoggerFactory.getLogger(MyFirstController.class);

    public MyFirstController(MyService service) {
        log.info("MyFirstController constructor");
        this.service = service;
    }

    @GetMapping("/name")
    public String showMeMyName() {
        return "Denis";
    }

    @GetMapping("/me")
    public Person justMe() {
        return new Person("John", "Doe", 99);
    }


//    @GetMapping("me-and-friend")
    @GetMapping(value = "me-and-friend")
    public List<Person> meAndFriend() {
        //List<Person> persons = new ArrayList<>();
        // persons.add(...);
        // persons.add(...);
        return List.of(
                new Person("mariusz", "p.", 18),
                new Person("john", "k.", 25)
        );
    }
    // ?param1=value1&param2=value2
    // /api/try-login?login=marius&password=12345
    @GetMapping("/try-login")
    public String logIn(@RequestParam(defaultValue = "John Doe", value = "login") String userLogin,
                        @RequestParam(defaultValue = "pass", value = "password") String userPassword) {
        log.info("received login : [{}] and password: [{}]", userLogin, userPassword);
        return "OK";
    }

    @PostMapping("/try-login")
    public ResponseEntity<String> logInWithPost(@RequestParam("login") String userLogin,
                                                @RequestParam("password") String userPassword) {
        log.info("received login : [{}] and password: [{}]", userLogin, userPassword);
        log.info("login with post");
        if (userLogin == null || userPassword == null) {
            return ResponseEntity.badRequest().body("Provide credentials");
        }
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/secret")
    public String getOneSecret() {
        String secretToShare = service.shareOneSecret();
        log.info("Sharing [{}] secret with user",secretToShare);
        return secretToShare;
    }







}
