package com.example.experi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_seq")
public class MongoUser {

    @Id
    private String id;

    private int userNum;

    private String userName;

}
