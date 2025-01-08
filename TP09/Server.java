import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server");
        ServerSocket serverSocket = new ServerSocket(2023);
        System.out.println("Server is running : " + serverSocket);
        Socket socket = serverSocket.accept();
        System.out.println("Connection established with client : " + socket);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = bufferedReader.readLine();
        System.out.println("Message from client : " + message);

        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
