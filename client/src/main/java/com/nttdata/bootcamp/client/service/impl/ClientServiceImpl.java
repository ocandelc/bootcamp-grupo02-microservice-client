package com.nttdata.bootcamp.client.service.impl;

import com.nttdata.bootcamp.client.model.dao.ClientDao;
import com.nttdata.bootcamp.client.model.document.Client;
import com.nttdata.bootcamp.client.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientDao clientDao;

    @Override
    public Mono<Client> insert(Client client) {
        return clientDao.save(client)
                .doFirst(() -> log.info("Begin Insert Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert Client"));
    }

    @Override
    public Mono<Client> update(Client client) {
        return clientDao.findById(client.getId())
                .doFirst(() -> log.info("Begin Update Client"))
                .map(c -> client)
                .flatMap(this.clientDao::save)
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Update Client"));
    }

    @Override
    public Mono<Void> delete(String id) {
        return clientDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete Client"));
    }

    @Override
    public Mono<Client> find(String id) {
        return clientDao.findById(id)
                .doFirst(() -> log.info("Begin Find Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Find Client"));
    }

    @Override
    public Mono<Client> findByCode(String code) {
        return clientDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode Client"));
    }

    @Override
    public Flux<Client> findAll() {
        return clientDao.findAll()
                .doFirst(() -> log.info("Begin FindAll Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll Client"));
    }

}
