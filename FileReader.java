package edu.bsu.cs222;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static String[] readArray(String file) {

        int count = 0;

        try {
            Scanner scan = new Scanner(new File(file));
            while(scan.hasNextLine()) {
                count = count + 1;
                scan.nextLine();
            }
            String[] words = new String[count];

            Scanner scan2 = new Scanner(new File(file));
            for(int i = 0; i < count; i = i + 1) {
                words[i] = scan2.nextLine();
            }
            return words;
        }
        catch(FileNotFoundException e) {

        }
        return null;
    }
}
