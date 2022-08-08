package com.nttdata.bootcamp.client.controller;

import com.nttdata.bootcamp.client.model.document.Client;
import com.nttdata.bootcamp.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Mono<Client> create(@RequestBody Client client){
        return this.clientService.insert(client);
    }

    @PutMapping
    public Mono<Client> update(@RequestBody Client client){
        return this.clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.clientService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<Client> find(@PathVariable String id) {
        return this.clientService.find(id);
    }

    @GetMapping("/findByCode/{code}")
    public Mono<Client> findByCode(@PathVariable String code) {
        return this.clientService.findByCode(code);
    }

    @GetMapping
    public Flux<Client> findAll() {
        return this.clientService.findAll();
    }

}
