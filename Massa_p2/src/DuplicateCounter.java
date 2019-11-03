import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.String;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class DuplicateCounter {

    public ArrayList<String> uniqueWords = new ArrayList<String>();
    public ArrayList<Integer> wordCounter = new ArrayList<Integer>();


    public void count(String dataFile) {
        try {
            FileInputStream fileByteStream = null;
            Scanner inFS = null;
            String curLine = "";
            fileByteStream = new FileInputStream(dataFile);
            inFS = new Scanner(fileByteStream);


            int i = 0;
            int j = 0;
            boolean isduplicate = false;
            while (inFS.hasNext()) {

                curLine = inFS.next();

                for (j = 0; j < this.uniqueWords.size(); j++) {
                    if (curLine.equals(this.uniqueWords.get(j))) {
                        isduplicate = true;
                        int temp = (int) this.wordCounter.get(j);
                        temp = temp + 1;
                        this.wordCounter.add(j, this.wordCounter.get(j) + 1);
                        System.out.println("current count of " + this.uniqueWords.get(j) + " is: " + this.wordCounter.get(j) + " and j is: " + j);

                    } else if (!curLine.equals(this.uniqueWords.get(j))) {

                        this.wordCounter.add(j, 1);
                        System.out.println("current count of " + this.uniqueWords.get(j) + " is: " + this.wordCounter.get(j));
                    }


                }
                if (isduplicate == false) {
                    this.uniqueWords.add(curLine);

                }
                i++;
                isduplicate = false;
            }
    /*
    System.out.println("list of unique words:");
    i = 0;
    while (i < this.uniqueWords.size()) {
        System.out.print(this.uniqueWords.get(i));
        System.out.println(" " + this.wordCounter.get(i));
        i++;
    }
    */


            fileByteStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException occurred");
        }


    }

    public void write(String outputFile) {
        try {
            FileOutputStream fileByteStream = null;
            PrintWriter outFS = null;

            fileByteStream = new FileOutputStream(outputFile);
            outFS = new PrintWriter(fileByteStream);

            // File is open and valid if we got this far (otherwise exception thrown)
            for (int i = 0; i < this.uniqueWords.size(); i++) {
                outFS.print(this.uniqueWords.get(i));
                outFS.println(" " + this.wordCounter.get(i));
                //outFS.println("1 2 3");
                outFS.flush();
            }

            // Done with file, so try to close it
            fileByteStream.close(); // close() may throw IOException if fails
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException occurred");
        }
    }

}
