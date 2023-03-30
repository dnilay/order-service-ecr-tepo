package com.javatechie.aws.cicd.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ORDER_TABLE")
public class Order {

    @Id

    private int id;
    private String name;
    private int quantity;
    private int price;
}
