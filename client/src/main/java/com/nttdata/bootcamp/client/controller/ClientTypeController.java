/**
 * Resumen.
 * Objeto                   : ClientTypeController.java
 * Descripción              : Clase para los métodos de rest api del cliente.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.client.controller;

import com.nttdata.bootcamp.client.model.document.ClientType;
import com.nttdata.bootcamp.client.service.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar método CRUD a través de request.
 */
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
