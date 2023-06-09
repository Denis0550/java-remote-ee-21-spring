package com.sda.javaremoteee21spring.controller.web;

import com.sda.javaremoteee21spring.entity.Car;
import com.sda.javaremoteee21spring.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cars/delete/{id}")
    public String deleteCarById(@PathVariable Long id) {
        log.info("Deleting car by id: [{}]",id);

        carService.deleteCarById(id);
        // redirect creates Location header with url to go
        return "redirect:/web/cars";
    }


    @GetMapping("/cars/show-add-form")
    public String newCarForm() {
        log.info("Presenting new car form for user");
        return "new-car";
    }

    @PostMapping("/cars/save")
    public String saveCar(Car carToSave) {
        log.info("saving new car:[{}]",carToSave);

        //TODO: implement
//        carService.saveCar(carToSave);
        return "redirect:/web/cars";


    }




}
