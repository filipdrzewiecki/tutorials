package com.drzewiecki.spring.aop;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    public Car createCar(Car car) {
        return null;
    }

    public Car updateCar(Long carId, Car car) {
        return null;
    }

    public void deleteCar(Long carId) {
    }

    public List<Car> getCars() {
        Car car = new Car();
        return List.of(car);
    }
}
