package com.parquesoftti.c26a.service;

import com.parquesoftti.c26a.model.Customer;
import com.parquesoftti.c26a.repository.CustomerRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService{

    final CustomerRespository customerRespository;

    @Override
    public List<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRespository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRespository.save(customer);
    }

    @Override
    public Customer update(Long id,Customer customer) {

        Customer customerTmp = customerRespository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));

        customerTmp.setCustomerName(customer.getCustomerName());
        customerTmp.setEmail(customer.getEmail());
        customerTmp.setPhoneNumber(customer.getPhoneNumber());

        return customerRespository.save(customerTmp);
    }

    @Override
    public void delete(Long id) {
        customerRespository.deleteById(id);
    }

    @Override
    public Customer findByCustomerName(String name) {
        return customerRespository.findByCustomerName(name)
                .orElseThrow(()-> new RuntimeException("Customer not found"));
    }
}

