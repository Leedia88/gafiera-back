package com.aicap.springbootwebapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Role {

    @Id
    private Long id;

    private String name;
}
