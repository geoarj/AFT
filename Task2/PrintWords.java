package com.company;

import java.io.File;
import java.util.*;

public class PrintWords {

    public static void main(String[] args) throws Exception {

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        try {
            Scanner in = new Scanner(new File("file.txt"));
            String line;
            while ((line = in.nextLine()) != null) {

                String[] words = line.split("[\\p{Punct}\\s]+");


                for (int i = 0; i < words.length; i++) {
                    words[i] = words[i].toLowerCase();
                    if (treeMap.containsKey(words[i])) {
                        treeMap.put(words[i], treeMap.get(words[i]) + 1);
                    } else {
                        treeMap.put(words[i], 1);
                    }
                }
            }
        } catch (Exception ex) {

        }

        System.out.println("\nPrint words in ascending order:");

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }

        int i = -1;
        String pair;

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() > i)
                i = entry.getValue();
        }

        System.out.println("\nPrint value with max times:");

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() == i)
                System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}