package com.example.phoneazuredeployment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConcPhoneService implements PhoneService{

    @Autowired
    PhoneDao dao;

    @Override
    public ArrayList<Phone> getPhones() {
        ArrayList<Phone> list = new ArrayList<>();
        dao.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void putPhone(Phone p) {
        dao.save(p);

    }
}
