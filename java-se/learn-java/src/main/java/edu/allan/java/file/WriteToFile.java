package edu.allan.java.file;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("history.txt");

            myWriter.write("HISTORY: Succession ============\n\n");

            myWriter.write("Joshua succeeded Moses as leader of Israel\n");
            myWriter.write("Elisha succeeded Elijah as prophet of Israel");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

