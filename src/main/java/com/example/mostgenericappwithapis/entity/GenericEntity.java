package com.example.mostgenericappwithapis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "generic")
@AllArgsConstructor
@Data
public class GenericEntity {
    @Id
    Long id;
    String field;
}
