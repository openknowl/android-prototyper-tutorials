package com.openknowl.tutorials;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        printLines("test.txt");
        readLines("test.dat");
    }

    public static void printLines(String fileName) {
        // Input stream
        try {
            BufferedReader stream = new BufferedReader(new FileReader(fileName));
//            stream.lines().forEach((line) -> {
//                System.out.println(line);
//            });

            List<String> list = stream.lines().collect(Collectors.toList());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLines(String fileName) {
        // Ouput stream
        try {
            FileOutputStream stream = new FileOutputStream(fileName);
            for (int i = 0; i < 11; i++) {
                String data = i + " 번쨰 줄입니다.\n";
                stream.write(data.getBytes());
            }
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
