package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @GetMapping("/info")  //localhost:8080/car/info?make=Honda&model=Civic
    public String carInfo(@RequestParam("make") String carMake,
                          @RequestParam("model") String carModel,
                          @RequestParam Integer year,
                          Model model){
        model.addAttribute("make",carMake);
        model.addAttribute("carModel",carModel);
        model.addAttribute("year",year);
        return "car/car-info";
    }

    @GetMapping("/info2")  //localhost:8080/car/info?make=Honda&model=Civic
    public String carInfo2(@RequestParam("make") String carMake,
                           @RequestParam(value = "model", required = false) String carModel,
                           Model model){
        model.addAttribute("make",carMake);
        model.addAttribute("carModel",carModel);
        return "car/car-info";
    }

    @GetMapping("/info/{make}/{year}") //localhost:8080/car/info/Honda/2015
    public String getCarInfo(@PathVariable("make") String carMake,
                             @PathVariable(value = "year") Integer carYear, Model model){

        model.addAttribute("make",carMake);
        model.addAttribute("year",carYear);
        return "car/car-info";
    }


}
