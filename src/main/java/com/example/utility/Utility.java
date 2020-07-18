package com.example.utility;

import java.io.File;

public class Utility {
    public static boolean createDir(String name){
         boolean success = false;
         File directory = new File(name);
         if (directory.exists()) {
             System.out.println("Directory already exists ...");
         } else {
             System.out.println("Directory not exists, creating now");
             success = directory.mkdir();
             if (success) {
                 System.out.printf("Successfully created new directory : %s%n", name);
             } else {
                 System.out.printf("Failed to create new directory: %s%n", name);
             }
         }
        return success;
    }
    public static boolean isDirExists(String name){
        File directory = new File(name);
        return directory.exists();
    }
}
