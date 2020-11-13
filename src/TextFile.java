import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFile {
    private String filePath;

    public TextFile(String filePath) {
        this.filePath = filePath;
    }

    public void Write(String text) {
        try ( FileWriter f = new FileWriter(filePath) ) {
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter writer = new PrintWriter(b);
            writer.println( text );
        } catch (Exception e) {
            System.err.println("[ERROR] Cannot write to file: " + filePath);
            e.printStackTrace();
        }
    }

    public String Read() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get( filePath ))) {
            String line = br.readLine();
            while ( line != null ) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
        } catch (Exception e) {
            System.err.println("[ERROR] Cannot read from file: " + filePath);
            e.printStackTrace();
        }

        return sb.toString();
    }
}
