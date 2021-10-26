package com.example.demo.apirest.Custormers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    // GET → ALL CUSTOMERS
    public ArrayList<CustomerModel> getCustomers() {
        return (ArrayList<CustomerModel>) customerRepository.findAll();
    }

    // POST → CUSTOMER (Save and update customer)
    public CustomerModel postCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    // GET → CUSTOMER BY ID
    public Optional<CustomerModel> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public boolean deleteCustomerById(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TO DO: handle exception
            System.out.println("ERROR: data does not exist or an error occurred");
            return false;
        }
    }
}
