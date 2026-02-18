package com.example.demo_test.reposotory;

import com.example.demo_test.model.MessageThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ThreadRepository extends JpaRepository<MessageThread,Long> {

    Optional<MessageThread> findById(Long id);
}
