package com.pr4;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OutMessageDTO {
    private String content;
    private LocalDateTime time;
    private String author;

    public OutMessageDTO(String content) {
        this.content = content;
    }
}

