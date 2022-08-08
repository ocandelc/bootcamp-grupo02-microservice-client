package com.nttdata.bootcamp.client.controller;

import com.nttdata.bootcamp.client.model.document.ClientType;
import com.nttdata.bootcamp.client.service.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clienttypes")
public class ClientTypeController {

    @Autowired
    private ClientTypeService clientTypeService;

    @PostMapping
    public Mono<ClientType> create(@RequestBody ClientType clientType){
        return this.clientTypeService.insert(clientType);
    }

    @PutMapping
    public Mono<ClientType> update(@RequestBody ClientType clientType){
        return this.clientTypeService.update(clientType);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.clientTypeService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<ClientType> find(@PathVariable String id) {
        return this.clientTypeService.find(id);
    }

    @GetMapping("/findByCode/{code}")
    public Mono<ClientType> findByCode(@PathVariable String code) {
        return this.clientTypeService.findByCode(code);
    }

    @GetMapping
    public Flux<ClientType> findAll() {
        return this.clientTypeService.findAll();
    }

}
