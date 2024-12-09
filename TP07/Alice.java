import java.io.*;
import java.net.Socket;

public class Alice {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        System.out.println("(Alice) Excusez-moi !");
        bufferedWriter.write("Excusez-moi !");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("(Bob) " + bufferedReader.readLine());

        System.out.println("(Alice) Pouvez-vous me dire comment aller à la station de métro ?");
        bufferedWriter.write("Pouvez-vous me dire comment aller à la station de métro ?");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("(Bob) " + bufferedReader.readLine());

        System.out.println("(Alice) Excellent, merci beaucoup !");
        bufferedWriter.write("Excellent, merci beaucoup !");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("(Bob) " + bufferedReader.readLine());

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
