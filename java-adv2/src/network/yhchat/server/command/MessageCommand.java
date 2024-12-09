package network.yhchat.server.command;

import network.yhchat.server.Session;
import network.yhchat.server.SessionManager;

import java.io.IOException;

public class MessageCommand implements Command{

    private final SessionManager sessionManager;

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        String message = args[1];
        sessionManager.sendAll("[" + session.getUsername() + "] " + message);
    }
}
