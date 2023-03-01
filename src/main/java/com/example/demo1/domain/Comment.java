package com.example.demo1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    @Field(targetType = FieldType.OBJECT_ID, name = "movie_id")
    private String movieId;
    private String text;
    private String name;
    private String email;
}
