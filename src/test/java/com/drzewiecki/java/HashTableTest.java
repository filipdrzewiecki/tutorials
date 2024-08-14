package com.drzewiecki.java;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

public class HashTableTest {

    @Test
    void testHash() {
        Car car = new Car(1L, "car1");
        Car car2 = new Car(1L, "car2");

        HashSet<Car> cars = new HashSet<>();
        cars.add(car);
        cars.add(car2);

        Boolean bool = cars.contains(car);

        cars.stream().forEach(a -> System.out.println(a.toString()));

    }

    @Test
    void testHashMap() {
        Car car = new Car(1L, "car");
        Car car2 = new Car(1L, "car");

        car.equals(car2);

        HashMap<String, Car> cars = new HashMap<>(10);
        cars.put("1", car);
        cars.put("2", car2);




    }
}
