package com.aicap.springbootwebapi.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private User user;
//    private Event event;
    private LocalDate registrationDate;
    private LocalDate paymentDate;

}
