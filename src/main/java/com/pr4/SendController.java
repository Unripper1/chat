package com.pr4;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class SendController {
    private final MessageRepo messageRepo;

    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public OutMessageDTO send(MessageDTO message) throws Exception {
        LocalDateTime time= LocalDateTime.now();
        Message messageDB=new Message(message.getText(),message.getAuthor(),time);
        messageRepo.save(messageDB);
        return new OutMessageDTO(HtmlUtils.htmlEscape(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))+" "+ message.getAuthor()+": "+message.getText()));
    }

}
