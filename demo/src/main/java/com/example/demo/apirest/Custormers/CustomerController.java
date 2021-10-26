package com.example.demo.apirest.Custormers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * http://localhost/customer
 * 
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // GET
    @GetMapping()
    public ArrayList<CustomerModel> getCustomers() {
        return customerService.getCustomers();
    }

    // POST
    @PostMapping()
    public CustomerModel postCustomer(@RequestBody CustomerModel customer) {
        return customerService.postCustomer(customer);
    }

    // GET - By Id
    @GetMapping(path = "/{id}")
    public Optional<CustomerModel> getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    // DELETE - By Id
    @DeleteMapping(path = "/{id}")
    public String deleteCustomerById(@PathVariable("id") Long id) {
        boolean customerDeleted = this.customerService.deleteCustomerById(id);
        if (customerDeleted) {
            return "Successful! Data deleted: " + id;
        } else {
            return "ERROR: User does not exist or an error occurred, please try again: " + id;
        }
    }

}
