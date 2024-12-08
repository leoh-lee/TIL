package network.chat.server;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatSessionManager {

    private final List<ChatSession> chatSessions = new ArrayList<>();

    public void add(ChatSession chatSession) {
        chatSessions.add(chatSession);
    }

    public void remove(ChatSession chatSession) {
        chatSessions.remove(chatSession);
    }

    public void sendAllUserMessage(String username, String message) {
        for (ChatSession chatSession : chatSessions) {
            chatSession.sendMessageToClient(username, message);
        }
    }

    public void broadcast(ChatSession session, String message) {
        for (ChatSession chatSession : chatSessions) {
            if (chatSession == session) {
                continue;
            }
            chatSession.sendServerMessage(message);
        }
    }

    public String getUsernames() {
        return chatSessions.stream()
                .map(ChatSession::getUsername)
                .collect(Collectors.joining(", "));
    }
}
