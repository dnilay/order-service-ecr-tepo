package com.javatechie.aws.cicd.example.controller;

import com.javatechie.aws.cicd.example.Order;
import com.javatechie.aws.cicd.example.repo.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orders/h2")
public class OrderH2Controller {

    private final OrderRepo orderRepo;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderRepo.save(order));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders()
    {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findAll());
    }
}
