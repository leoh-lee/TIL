package network.chat.client;

import java.io.DataInputStream;
import java.io.IOException;

public class ChatReader implements Runnable {

    private final DataInputStream input;

    public ChatReader(DataInputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String receivedMessage = input.readUTF();
                System.out.println(receivedMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
