import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.sql.Time;
import java.time.LocalTime;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encryption {

    static File encryptionPath = new File("C:\\JavaEncryption\\");
    static String fileExtention = ".txt";
    static int fileCount = 0;

    static int charAtt = 0;
    static int charSel = 0;

    static String baseSet[] = {
        "a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F",
        "g", "G", "h", "H", "i", "I", "j", "J", "k", "K", "l", "L",
        "m", "M", "n", "N", "o", "O", "p", "P", "q", "Q", "r", "R",
        "s", "S", "t", "T", "u", "U", "v", "V", "w", "W", "x", "X",
        "y", "Y", "z", "Z", ".", ",", "!", "?", ";", ":", "\'", "\"",
        "{", "}", "[", "]", "@", "#", "$", "%", "^", "&", "*", "(",
        ")", "-", "_", "+", "=", "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "0", "/", "\\", "|", " "
    };
    static ArrayList<String> encryptionSet = new ArrayList<>();
    static ArrayList<String> keySet = new ArrayList<>();

    public static void Generate() {
        int num = (int)(Math.random() * baseSet.length);
        Check(baseSet[num]);
    }

    public static void Check(String value) {
        if (encryptionSet.contains(value) == false) {
            encryptionSet.add(value);
            charSel++;
           System.out.println(value + " - " + charSel + "/" + baseSet.length);
        } else {
            charAtt++;
           //System.out.println("Already used > " + charAtt);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ReadFiles();
        KeyGeneration();
    }

    public static void KeyGeneration() {
        System.out.println("Generating key...");
        while (encryptionSet.size() < baseSet.length) { 
            Generate();
            
        }
        System.out.println("Encryption key has been formed.");
        // System.out.println(encryptionSet);
        Write();
    }

    public static void Write() {
       try {
        FileWriter writer = new FileWriter(encryptionPath + "\\key" + fileCount + fileExtention, false);
        for (int a = 0; a < encryptionSet.size(); a++) {
            writer.write(encryptionSet.get(a));
        }
        writer.close();
        System.out.println("Encyption key successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFiles() {
        File[] files = encryptionPath.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    //System.out.println("[DIR]  " + f.getName());
                } else {
                    //System.out.println("       " + f.getName());
                    fileCount++;
                }
            }
        }
    }
}