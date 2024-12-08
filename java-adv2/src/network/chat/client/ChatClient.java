package network.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int PORT = 12345;
    public static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        String username = "";

        while (true) {
            String joinMessage = SCANNER.nextLine();
            if (joinMessage.startsWith("/join|")) {
                socket.connect(new InetSocketAddress("localhost", PORT), TIMEOUT);
                username = joinMessage.split("\\|")[1];
                break;
            }
        }

        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
            Thread readerThread = new Thread(new ChatReader(input));
            readerThread.start();

            output.writeUTF(username);

            while (true) {
                String sendMessage = SCANNER.nextLine();
                output.writeUTF(sendMessage);

                if ("/exit".equals(sendMessage)) {
                    break;
                }
            }
        } finally {
            socket.close();
        }
    }
}
