
import { Injectable } from '@angular/core';
import { Socket } from 'ngx-socket-io';

@Injectable({
  providedIn: 'root'
})


// websocket.service.ts
export class WsService {

  constructor(private socket: Socket) { }

  connectToWebSocket() {
    this.socket.connect();
  }

  sendMessage(message: string) {
    this.socket.emit('updateText', message);
  }

  onTextUpdated() {
    return this.socket.fromEvent<string>('textUpdated');
  }
}
