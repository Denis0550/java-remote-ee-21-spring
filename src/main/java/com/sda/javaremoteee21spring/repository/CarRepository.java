package com.sda.javaremoteee21spring.repository;


import com.sda.javaremoteee21spring.entity.Car;
import com.sda.javaremoteee21spring.entity.Color;
import com.sda.javaremoteee21spring.entity.Fuel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class CarRepository {

    private final Map<Long, Car> cars = new HashMap<>();


    public CarRepository() {
        for (Car car: createSomeCars()) {
            cars.put(car.getId(), car);
        }
    }




    private List<Car> createSomeCars() {
        return List.of(
                Car.builder()
                        .id(1L)
                        .brand("Mazda")
                        .model("6")
                        .vin("123456")
                        .colour(Color.SOUL_RED)
                        .productionYearMonth(YearMonth.now())
                        .mileage(100)
                        .fuelType(Fuel.GASOLINE)
                        .insurance(true)
                        .build(),
                Car.builder()
                        .id(2L)
                        .brand("Mazda")
                        .model("5")
                        .vin("23556")
                        .colour(Color.GRAY)
                        .productionYearMonth(YearMonth.now())
                        .mileage(550)
                        .fuelType(Fuel.DIESEL)
                        .insurance(false)
                        .build()
        );
    }


    public List<Car> findAll() {
        log.info("find all cars");

        return new ArrayList<>(cars.values());
    }

    public Car findById(Long id) {
        log.info("finding car by id: [{}]", id);
        return cars.get(id);
    }

    public Car save(Car carToSave) {
        log.info("Saving car: [{}]", carToSave);
        Long id = nextId();
        carToSave.setId(id);
        cars.put(id, carToSave);
        return carToSave;
    }

    private Long nextId() {
        // old way
//        Long max = 0L;
//        for (Long id: cars.keySet()) {
//            if (id > max) {
//                max = id;
//            }
//        }
//        return max + 1;

        // new way
        return cars.keySet()
                .stream()
                .max(Long::compareTo)
                .orElse(0L) + 1;
    }


}
