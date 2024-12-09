import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Bob {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        System.out.println("(Alice) " + bufferedReader.readLine());

        System.out.println("(Bob) Oui, dites-moi.");
        bufferedWriter.write("Oui, dites-moi.");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("(Alice) " + bufferedReader.readLine());

        System.out.println("(Bob) Oui bien sur. Marchez dans cette direction trois pâtés de maisons.");
        bufferedWriter.write("Oui bien sur. Marchez dans cette direction trois pâtés de maisons.");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("(Alice) " + bufferedReader.readLine());

        System.out.println("(Bob) Il n'y a pas de quoi.");
        bufferedWriter.write("Il n'y a pas de quoi.");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
