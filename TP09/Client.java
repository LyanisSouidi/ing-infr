import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client");
        Socket socket = new Socket("172.31.249.202", 2023);
        System.out.println("Connection established with server : " + socket);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("Hello from client");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        socket.close();
    }
}
