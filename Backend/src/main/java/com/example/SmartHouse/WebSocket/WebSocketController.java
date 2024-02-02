//package com.example.SmartHouse.WebSocket;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//
//    @MessageMapping("/updateData")
//    @SendTo("/smartHouseClient/data")
//    public Object updateData(Object data) {
//        // Process the incoming data (e.g., update the object)
//        // Send the updated data to the WebSocket topic
//        return data;
//    }
//}
