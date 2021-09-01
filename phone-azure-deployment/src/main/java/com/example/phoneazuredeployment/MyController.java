package com.example.phoneazuredeployment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MyController {

    @Autowired
    PhoneService service;

    @RequestMapping(method = RequestMethod.GET, value = "/phone")
    ArrayList<Phone> gets(){
        return service.getPhones();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/phone")
    String post(@RequestBody ArrayList<Phone> list){
        for(Phone p : list){
            service.putPhone(p);
        }

        return "Successful";
    }

}
