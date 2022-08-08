package com.nttdata.bootcamp.client.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection="client")
public class Client {

    @Id
    private String id;
    private String code;
    private String name;
    private String codeDocumentType;
    private String documentNumber;
    private String codeClientType;
    private String phoneNumber;
    private String email;
    private boolean state;

}
