import java.io.*;

public class Reader {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Provide a file name");
            System.exit(1);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
