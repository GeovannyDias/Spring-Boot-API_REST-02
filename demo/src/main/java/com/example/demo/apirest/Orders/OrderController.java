package com.example.demo.apirest.Orders;

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
 * http://localhost/order
 * 
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    // GET
    @GetMapping()
    public ArrayList<OrderModel> getOrdeds() {
        return this.orderService.getOrders();
    }

    // POST
    @PostMapping()
    public OrderModel postOrder(@RequestBody OrderModel order) {
        return this.orderService.postOrder(order);
    }

    // GET - by id
    @GetMapping(path = "/{id}")
    public Optional<OrderModel> getOrderById(@PathVariable("id") Long id) {
        return this.orderService.getOrderById(id);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        boolean orderDeleted = this.orderService.deteleOrder(id);
        if (orderDeleted) {
            return "Successful! Data deleted.";
        } else {
            return "ERROR: User does not exist or an error occurred, please try again";
        }
    }
}
