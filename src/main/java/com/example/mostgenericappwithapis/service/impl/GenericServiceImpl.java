package com.example.mostgenericappwithapis.service.impl;

import com.example.mostgenericappwithapis.mapper.GenericMapper;
import com.example.mostgenericappwithapis.model.Generic;
import com.example.mostgenericappwithapis.repositories.GenericRepository;
import com.example.mostgenericappwithapis.service.GenericService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class GenericServiceImpl implements GenericService {

    private final GenericRepository genericRepository;
    private final GenericMapper genericMapper;
    public Flux<Generic> getAll() {
        return genericRepository.findAll()
                .map(genericMapper::modelFromDto);
    }
}
