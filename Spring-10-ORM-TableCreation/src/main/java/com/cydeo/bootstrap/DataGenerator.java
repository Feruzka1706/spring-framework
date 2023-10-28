package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    CarRepository carRepository;


    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        Car car1= new Car("BMW","M5");
        Car car2= new Car("Honda","Civic");
        Car car3= new Car("Toyota","Camry");



        List<Car> cars = Arrays.asList(car1,car2,car3);
        //save these objects to db
        carRepository.saveAll(cars);

    }


}
