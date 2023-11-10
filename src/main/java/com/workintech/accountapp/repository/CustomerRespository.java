package com.workintech.accountapp.repository;

import com.workintech.accountapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, Long> {
}
