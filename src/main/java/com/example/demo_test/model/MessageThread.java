package com.example.demo_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "message_thread")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageThread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String thread;
    private String text;
    @Column(name = "create_date")
    private LocalDateTime create_date;
    @OneToMany(mappedBy = "messageThread", cascade = CascadeType.REMOVE)
    private List<Comment> comments;
}
