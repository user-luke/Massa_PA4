import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DuplicateRemover {
    public static FileOutputStream fileOutByteStream = null;
    public static FileInputStream fileByteStream = null;
    public static PrintWriter outFS = null;
    public static Scanner inFS = null;
    public ArrayList<String> uniqueWords = new ArrayList<String>();
    //public ArrayList<Object> words = new ArrayList<Object>();


    public void remove(String dataFile) {
        try {
            FileInputStream fileByteStream = null;
            Scanner inFS = null;
            int fileNum;
            String curLine = "";

            //System.out.println("Opening file problem1.txt.");
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
                    }

                }
                if (isduplicate == false) {
                    this.uniqueWords.add(curLine);
                }
                //System.out.println(this.words.get(i));
                i++;
                isduplicate = false;
            }
        /*
        System.out.println("list of unique words:");
        i = 0;
        while (i < this.uniqueWords.size()){
            System.out.println(this.uniqueWords.get(i));
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
                outFS.println(this.uniqueWords.get(i));
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