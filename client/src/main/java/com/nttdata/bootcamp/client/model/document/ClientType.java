package com.nttdata.bootcamp.client.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection="client_type")
public class ClientType {

    @Id
    private String id;
    private String code;
    private String name;
    private boolean state;

}
