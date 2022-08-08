package com.nttdata.bootcamp.client.model.dao;

import com.nttdata.bootcamp.client.model.document.ClientType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClientTypeDao extends ReactiveMongoRepository<ClientType, String> {

    Mono<ClientType> findByCode(String code);

}
