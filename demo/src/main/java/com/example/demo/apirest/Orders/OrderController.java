package com.example.demo.apirest.Orders;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // @Autowired → Inyector de dependencias
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    // GET
    @GetMapping()
    public ArrayList<OrderModel> getOrdeds() {
        return this.orderService.getOrders();
    }

    // POST
    @PostMapping()
    public OrderModel postOrder(@RequestBody OrderDto order) {
        return this.orderService.postOrder(order);
    }
    // @PostMapping()
    // public OrderModel postOrder(@RequestBody OrderModel order) {
    // return this.orderService.postOrder(order);
    // }

    // GET - by id
    @GetMapping(path = "/{id}")
    public Optional<OrderModel> getOrderById(@PathVariable("id") Long id) {
        return this.orderService.getOrderById(id);
    }

    // UPDATE (Only)
    @PutMapping(path = "/{id}")
    public OrderModel updateOrderById(@PathVariable("id") Long order_id, @RequestBody OrderModel order) {
        Optional<OrderModel> foundOrder = this.orderRepository.findById(order_id);
        // .orElseThrow(() -> new ResourceNotFoundException("Note", "id", order_id));
        // CONTROLAR CAMPOS VACIOS (!order.getName_item().isEmpty() ||
        // !order.getName_item().isBlank())
        if (foundOrder.isPresent() && order_id == order.getId()) {
            return this.orderService.updateOrderById(order);
        } else {
            // RETURN new
            // ResponseEntity<OrderModel>(OrderService.postFunction(dto).HttpStatus.OK);
            return null;
        }
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
