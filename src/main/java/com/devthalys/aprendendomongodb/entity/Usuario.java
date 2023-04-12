package com.devthalys.aprendendomongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuario")
public class Usuario {

    @Id
    private String id;
    private String name;
    private Integer age;

    @DBRef
    private Usuario atleta;
}
