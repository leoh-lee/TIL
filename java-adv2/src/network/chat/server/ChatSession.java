package network.chat.server;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class ChatSession implements Runnable {

    private String username = "unknown";
    private final Socket socket;
    private final ChatSessionManager chatSessionManager;
    private final DataInputStream input;
    private final DataOutputStream output;

    public ChatSession(Socket socket, ChatSessionManager chatSessionManager) throws IOException {
        this.socket = socket;
        this.chatSessionManager = chatSessionManager;
        chatSessionManager.add(this);
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            String joinUsername = input.readUTF();
            changeUsername(joinUsername);
            System.out.println(joinUsername + "님이 입장하셨습니다.");
            chatSessionManager.broadcast(this, joinUsername + "님이 입장하셨습니다.");
            while (true) {
                String readLine = input.readUTF();
                if ("/exit".equals(readLine)) {
                    SocketCloseUtil.closeAll(socket, input, output);
                    chatSessionManager.remove(this);
                    System.out.println(username + "님이 퇴장하셨습니다.");
                    chatSessionManager.broadcast(this, username + "님이 퇴장하셨습니다.");
                    break;
                }

                if (readLine.startsWith("/change|")) {
                    String username = readLine.split("\\|")[1];
                    changeUsername(username);
                    continue;
                }

                if ("/users".equals(readLine)) {
                    String usernames = chatSessionManager.getUsernames();
                    sendServerMessage(usernames);
                    continue;
                }

                if (readLine.startsWith("/message|")) {
                    String message = readLine.split("\\|")[1];
                    chatSessionManager.sendAllUserMessage(username, message);
                }

            }
        } catch (IOException e) {
            log(e);
        } finally {
            SocketCloseUtil.closeAll(socket, input, output);
        }
    }

    public void changeUsername(String username) {
        this.username = username;
    }

    public void sendMessageToClient(String username, String message) {
        try {
            String messageFormat = "[%10s] %s";
            String formattedMessage = messageFormat.formatted(username, message);
            output.writeUTF(formattedMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return username;
    }

    public void sendServerMessage(String message) {
        try {
            output.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
