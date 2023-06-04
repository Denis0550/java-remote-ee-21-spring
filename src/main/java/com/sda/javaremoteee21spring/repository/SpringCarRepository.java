package com.sda.javaremoteee21spring.repository;

import com.sda.javaremoteee21spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface SpringCarRepository extends JpaRepository<Car, Long> {
}