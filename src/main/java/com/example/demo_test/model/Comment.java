package com.example.demo_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Column(name = "create_date")
    private LocalDateTime create_date;
    @ManyToOne
    @JoinColumn(name = "message_thread_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MessageThread messageThread;
}
