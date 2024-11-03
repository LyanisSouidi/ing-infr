import java.io.*;

public class Ex3 {
    /**
     * Nombre maximum de lignes lues dans le fichier
     */
    public static final int MAX_LINES = 100;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Donnez un chemin de fichier à lire en argument");
            System.exit(1);
        }

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        BufferedReader stdinReader = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = new String[MAX_LINES];
        String line;
        int readLines = 0;
        while (((line = fileReader.readLine()) != null) && readLines < MAX_LINES) {
            lines[readLines] = line;
            readLines++;
        }

        if (readLines == 0) {
            System.err.println("Le fichier '" + args[0] + "' est vide");
            System.exit(1);
        }

        System.out.println("Lignes accessibles : 1-" + readLines);

        int lineNumber;
        do {
            lineNumber = prompt(stdinReader);
            if (lineNumber > 0 && lineNumber <= readLines) {
                System.out.println("Contenu de la ligne n°" + lineNumber + " :");
                System.out.println(lines[lineNumber - 1]);
            } else if (lineNumber != -1) {
                System.err.println("numéro de ligne incorrect");
            }
        } while (lineNumber > 0 && lineNumber <= readLines);

        fileReader.close();
        stdinReader.close();
    }

    /**
     * Demande à l'utilisateur un numéro de ligne
     * @param stdinReader le BufferedReader correspondant à l'entrée standard
     * @return int le numéro de ligne à lire ou -1 si l'utilisateur souhaite quitter le programme
     * @throws IOException si une erreur survient lors de la lecture de l'entrée standard
     */
    public static int prompt(BufferedReader stdinReader) throws IOException {
        System.out.println("Numéro de ligne à lire (-1 pour quitter) :");
        try {
            return Integer.parseInt(stdinReader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("input incorrect");
            return -1;
        }
    }
}
