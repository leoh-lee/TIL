package network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // client <- server: FIN (종료)
        Thread.sleep(1000);

        // clinet가 종료에 대한 ACK을 날려야는데..

        // client -> server: PUSH[1]
        output.write(1);

        // client <- server: RST(잘못된 요청이라고 응답이 옴)
        Thread.sleep(1000);     // RST 메시지 전송 대기

        try {
            // java.net.SocketException: Connection reset ( RST )
            int read = input.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            // java.net.SocketException: Broken pipe
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // 실제로는 이 예외들이 IOException의 자식이기 떄문에 IOException 발생 시 자원 정리해주면 됨
    }

}
