package com.example.mostgenericappwithapis.mapper;

import com.example.mostgenericappwithapis.entity.GenericEntity;
import com.example.mostgenericappwithapis.model.Generic;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface GenericMapper  {
    Generic modelFromDto(GenericEntity entity);
}
