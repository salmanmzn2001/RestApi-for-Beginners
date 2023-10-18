package com.example.RestApi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String firstname;
    private  String lastname;



}
