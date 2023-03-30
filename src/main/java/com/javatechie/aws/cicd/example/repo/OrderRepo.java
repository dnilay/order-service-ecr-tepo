package com.javatechie.aws.cicd.example.repo;

import com.javatechie.aws.cicd.example.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {


}
