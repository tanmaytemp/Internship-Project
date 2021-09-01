package com.example.phoneazuredeployment;

import java.util.ArrayList;

public interface PhoneService {
    ArrayList<Phone> getPhones();
    void putPhone(Phone p);
}
