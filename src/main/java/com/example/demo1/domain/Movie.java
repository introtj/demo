package com.example.demo1.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("movies")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Movie {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String title;
    private String year;
    private String type;
    private String poster;
    private List<String> directors;
    private List<String> writers;
    private List<String> countries;
    private List<String> genres;

    @ReadOnlyProperty
    @DocumentReference(lookup = "{'movie_id': ?#{#self._id}}")
    private List<Comment> comments;
}
