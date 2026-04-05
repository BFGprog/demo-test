package com.example.demo_test.reposotory;

import com.example.demo_test.model.MessageThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
@Repository
public interface ThreadRepository extends JpaRepository<MessageThread,Long> {

    Optional<MessageThread> findById(Long id);

    @Modifying
    @Transactional
    @Query("""
           DELETE FROM MessageThread t
           WHERE t.id > 3
           AND t.create_date < :time
           """)
    void deleteOldThreads(@Param("time") LocalDateTime threshold);

}
