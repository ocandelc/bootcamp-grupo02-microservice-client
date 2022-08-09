/**
 * Resumen.
 * Objeto                   : ClientController.java
 * Descripción              : Clase de controladora para invocar a métodos CRUD con rest api.
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

import com.nttdata.bootcamp.client.model.document.Client;
import com.nttdata.bootcamp.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    /** Declaración de la clase service */
    @Autowired
    private ClientService clientService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Client, tipo Mono
     */
    @PostMapping
    public Mono<Client> create(@RequestBody Client client){
        return this.clientService.insert(client);
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Client, tipo Mono
     */
    @PutMapping
    public Mono<Client> update(@RequestBody Client client){
        return this.clientService.update(client);
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.clientService.delete(id);
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Client, tipo String
     */
    @GetMapping("/{id}")
    public Mono<Client> find(@PathVariable String id) {
        return this.clientService.find(id);
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Client, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<Client> findByCode(@PathVariable String code) {
        return this.clientService.findByCode(code);
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Client, tipo Flux
     */
    @GetMapping
    public Flux<Client> findAll() {
        return this.clientService.findAll();
    }

}
