package com.javatechie.aws.cicd.example;

import com.javatechie.aws.cicd.example.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class OrderServiceApplication implements CommandLineRunner {

    @Autowired
    private OrderDao orderDao;

    private OrderRepo orderRepo;
    @GetMapping
    public List<Order> fetchOrders() {
        return orderDao.getOrders().stream().
                sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderRepo.save(new Order(1,"Pen",100,2L));
        orderRepo.save(new Order(2,"Pencil",101,3L));
        orderRepo.save(new Order(3,"Laptop",100,2000000L));
        orderRepo.save(new Order(4,"Desktop",10,200000L));
        orderRepo.save(new Order(5,"Paper",1001,34568L));
    }
}
