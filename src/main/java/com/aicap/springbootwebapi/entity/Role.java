package com.aicap.springbootwebapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class Role {

    private String name;
}
