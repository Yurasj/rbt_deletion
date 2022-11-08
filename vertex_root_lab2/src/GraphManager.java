import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class GraphManager {

    public void writeToFile(int root) {
        try (FileWriter writer = new FileWriter("output.txt", Charset.defaultCharset())) {
            writer.write("The root vertex is: " + root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}