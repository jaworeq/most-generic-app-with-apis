package com.example.mostgenericappwithapis.repositories;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "generic")
@AllArgsConstructor
@Data
public class Generic {
    @Id
    Long id;
    String field;
}
