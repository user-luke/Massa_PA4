import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Luke\\IdeaProjects\\Massa_PA4\\Massa_p1\\src\\problem1.txt";
        String output = "C:\\Users\\Luke\\IdeaProjects\\Massa_PA4\\Massa_p1\\src\\unique_words.txt";

        DuplicateRemover file = new DuplicateRemover();

        file.remove(input);
        file.write(output);
    }
}