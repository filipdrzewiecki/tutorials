package com.drzewiecki.spring.aop;

import com.drzewiecki.pattern.outbox.employee.Employee;
import com.drzewiecki.pattern.outbox.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping()
    public List<Car> getCars() {
        List<Car> cars =  carService.getCars();
        return cars;
    }

    @PostMapping()
    public void createCar(@RequestBody Car car) {
        carService.createCar(car);
    }

    @PutMapping("/{carId}")
    public void updateEmployee(@PathVariable Long employeeId, @RequestBody Car car) {
        carService.updateCar(employeeId, car);
    }

    @DeleteMapping("/{carId}")
    public void deleteEmployee(@PathVariable Long carId) {
        carService.deleteCar(carId);
    }

}
