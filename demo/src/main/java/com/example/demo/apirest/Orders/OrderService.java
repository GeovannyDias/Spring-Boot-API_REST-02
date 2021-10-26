package com.example.demo.apirest.Orders;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    // GET
    public ArrayList<OrderModel> getOrders() {
        return (ArrayList<OrderModel>) this.orderRepository.findAll();
    }

    // POST and UPDATE
    public OrderModel postOrder(OrderModel order) {
        return this.orderRepository.save(order);
    }

    // GET - by id
    public Optional<OrderModel> getOrderById(Long id) {
        return this.orderRepository.findById(id);
    }

    // DELETE
    public boolean deteleOrder(Long id) {
        try {
            this.orderRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TO DO: handle exception
            System.out.println("ERROR: data does not exist or an error occurred");
            return false;
        }
    }

}
