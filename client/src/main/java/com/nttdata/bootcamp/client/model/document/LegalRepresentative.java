package com.nttdata.bootcamp.client.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection="client_person")
public class LegalRepresentative {

    @Id
    private String id;
    private String codeClient;
    private String codePerson;
    private boolean state;

}