package com.nttdata.bootcamp.client.model.dao;

import com.nttdata.bootcamp.client.model.document.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClientDao extends ReactiveMongoRepository<Client, String> {

    Mono<Client> findByCode(String code);

}
