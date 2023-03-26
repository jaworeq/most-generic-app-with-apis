package com.example.mostgenericappwithapis.service;

import com.example.mostgenericappwithapis.model.Generic;
import reactor.core.publisher.Flux;

public interface GenericService {
    Flux<Generic> getAll();
}
