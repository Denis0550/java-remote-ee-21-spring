package com.sda.javaremoteee21spring.controller.web;

import com.sda.javaremoteee21spring.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/web")
public class CarWebController {

    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String CARS = "cars";
    private final CarService carService;

    public CarWebController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping({"/home-page", ""})
    public String homePage(Model data,
                           @RequestParam(value = NAME, defaultValue = "Denis") String name,
                           @RequestParam(value = SURNAME, defaultValue = "Soroka")String surname) {
        log.info("home page");
        data.addAttribute(NAME, name);
        data.addAttribute(SURNAME, surname);
        return "home-page";
    }

    @GetMapping("/cars")
    public String  allCars(Model data) {
        log.info("All cars at html page");

        var allCars = carService.findAllCars();
        data.addAttribute(CARS, allCars);

        return "all-cars";
    }






}
