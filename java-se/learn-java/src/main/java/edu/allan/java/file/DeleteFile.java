package edu.allan.java.file;

import java.io.File;  // Import the File class

public class DeleteFile {
    public static void main(String[] args) {
        File myObj = FileCreation.createFile("file.txt");

        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}