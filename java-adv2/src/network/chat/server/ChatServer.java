package network.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        ChatSessionManager chatSessionManager = new ChatSessionManager();
        while (true) {
            Socket socket = serverSocket.accept();

            ChatSession chatSession = new ChatSession(socket, chatSessionManager);

            Thread chatThread = new Thread(chatSession);
            chatThread.start();
        }
    }
}
