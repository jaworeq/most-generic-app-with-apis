package com.example.mostgenericappwithapis.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "generic")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GenericEntity {
    @Id
    Long id;
    String field;
}
