package com.nttdata.bootcamp.client.service.impl;

import com.nttdata.bootcamp.client.model.dao.ClientTypeDao;
import com.nttdata.bootcamp.client.model.document.ClientType;
import com.nttdata.bootcamp.client.service.ClientTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientTypeServiceImpl implements ClientTypeService {

    private static final Logger log = LoggerFactory.getLogger(ClientTypeServiceImpl.class);

    @Autowired
    private ClientTypeDao clientTypeDao;

    @Override
    public Mono<ClientType> insert(ClientType clientType) {
        return clientTypeDao.save(clientType)
                .doFirst(() -> log.info("Begin Insert ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert ClientType"));
    }

    @Override
    public Mono<ClientType> update(ClientType clientType) {
        return clientTypeDao.findById(clientType.getId())
                .doFirst(() -> log.info("Begin Update ClientType"))
                .map(c -> clientType)
                .flatMap(this.clientTypeDao::save)
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Update ClientType"));
    }

    @Override
    public Mono<Void> delete(String id) {
        return clientTypeDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete ClientType"));
    }

    @Override
    public Mono<ClientType> find(String id) {
        return clientTypeDao.findById(id)
                .doFirst(() -> log.info("Begin Find ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Find ClientType"));
    }

    @Override
    public Mono<ClientType> findByCode(String code) {
        return clientTypeDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode ClientType"));
    }

    @Override
    public Flux<ClientType> findAll() {
        return clientTypeDao.findAll()
                .doFirst(() -> log.info("Begin FindAll ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll ClientType"));
    }

}
