package com.pr4;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "author")
    private String author;
    @Column(name = "time")
    private LocalDateTime time;

    public Message(String text, String author, LocalDateTime time) {
        this.text = text;
        this.author = author;
        this.time=time;
    }

    public Message() {

    }
}
