package network.yhchat.server.command;

import network.yhchat.server.Session;
import network.yhchat.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {

    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> usernames = sessionManager.getAllUsernames();
        StringBuilder sb = new StringBuilder();
        sb.append("전체 접속자 : ").append(usernames.size()).append("\n");
        for (String username : usernames) {
            sb.append(" - ").append(username).append("\n");
        }
        session.send(sb.toString());
    }
}
