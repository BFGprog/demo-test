package com.example.demo_test.reposotory;

import com.example.demo_test.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByMessageThreadId(Long threadId);

    @Modifying
    @Transactional
    @Query("""
       DELETE FROM Comment c
       WHERE c.id > 9
       AND c.create_date < :time
       """)
    void deleteCommentsByOldThreads(@Param("time") LocalDateTime threshold);
}

