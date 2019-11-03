import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Luke\\IdeaProjects\\Massa_PA4\\Massa_p2\\src\\problem2.txt";
        String output = "C:\\Users\\Luke\\IdeaProjects\\Massa_PA4\\Massa_p2\\src\\unique_words_counts.txt";

        DuplicateCounter duplicateCounter = new DuplicateCounter();

        duplicateCounter.count(input);
        duplicateCounter.write(output);
    }
}
