package com.example.phoneazuredeployment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDao extends JpaRepository<Phone, Integer> {
}
