package com.example.SmartHouse.WebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NumberController {

    private int currentNumber = 0;
    @MessageMapping("/control")
    @SendTo("/topic/number")
    public int controlNumber(int value) {
        currentNumber += value;
        return currentNumber;
    }
}
