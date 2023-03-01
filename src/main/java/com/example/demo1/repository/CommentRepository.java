package com.example.demo1.repository;

import com.example.demo1.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
