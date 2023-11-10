package com.workintech.accountapp.service;

import com.workintech.accountapp.entity.Customer;
import com.workintech.accountapp.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRespository customerRespository;

    @Autowired
    public CustomerServiceImpl(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public Customer find(long id) {
        Optional<Customer> customerOptional = customerRespository.findById(id);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRespository.save(customer);
    }

    @Override
    public Customer delete(long id) {
        Customer customer = find(id);
        if(customer != null){
            customerRespository.delete(customer);
            return customer;
        }
        return null;
    }
}
