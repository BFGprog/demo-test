package com.example.demo_test.reposotory;

import com.example.demo_test.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByMessageThreadId(Long threadId);
}

