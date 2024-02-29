import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class App {
    public static void main(String[] args) throws Exception {
        String inputFile = "input.txt"; // Replace with your input file path
        String outputFile = "output.txt"; // Replace with your output file path

        try {
            Map<String, Integer> wordCountMap = new HashMap<>();

            // Reads input file
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+"); 
                    for (String word : words) {
                        word = word.toLowerCase(); // Convert to lowercase
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Write word counts to output file
            try (FileWriter writer = new FileWriter(outputFile)) {
                for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }

            System.out.println("Word counts written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
