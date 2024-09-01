package com.parquesoftti.c26a.controller;

import com.parquesoftti.c26a.model.Customer;
import com.parquesoftti.c26a.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;

    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer Customer){
        return customerService.save(Customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.update(id,customer);
    }


    @GetMapping("/search")
    public Customer findByCustomerName(@RequestParam String name){
        return customerService.findByCustomerName(name);
    }
}
