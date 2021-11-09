package com.example.demo.apirest.Orders;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.apirest.Custormers.CustomerModel;
import com.example.demo.apirest.Custormers.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    // GET
    public ArrayList<OrderModel> getOrders() {
        return (ArrayList<OrderModel>) this.orderRepository.findAll();
    }

    // POST and UPDATE

    // public OrderModel postOrder(OrderModel order) {
    // return this.orderRepository.save(order);
    // }

    public OrderModel postOrder(OrderDto order) {
        // VALIDAR QUE SOLO SE ENVIE NUEVOS CAMPOS Y SI NO ESTAN VACIOS O EN BLANCO
        // Long id = (long) (1);
        Long customer_id = order.getCustomer_id();
        Long order_id = order.getId();

        OrderModel orderData = new OrderModel(order);
        if (order_id != null)
            orderData.setId(order_id);

        Optional<CustomerModel> customer = customerRepository.findById(customer_id);
        if (customer.isPresent()) {
            orderData.setCustomers(customer.get());
        }
        return this.orderRepository.save(orderData);
    }

    // GET - by id
    public Optional<OrderModel> getOrderById(Long id) {
        return this.orderRepository.findById(id);
    }

    // UDPDATE (Only)
    public OrderModel updateOrderById(OrderModel order) {
        return this.orderRepository.save(order);
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
