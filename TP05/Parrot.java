import java.io.*;

public class Parrot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.log")));

        String line = null;
        while ((line = reader.readLine()) != null && !line.equals("Done")) {
            writer.write(line);
            writer.newLine();
            writer.flush();
            System.out.println(line);
        }

        reader.close();
        writer.close();
    }
}
