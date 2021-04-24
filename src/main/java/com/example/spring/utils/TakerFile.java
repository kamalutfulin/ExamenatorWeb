package com.example.spring.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class TakerFile {
    public TakerFile() throws FileNotFoundException {
    }

    ArrayList<String> arrayList = new ArrayList<>();
    FileInputStream fileInputStream = new FileInputStream("Test.txt");
    BufferedReader readerFile = new BufferedReader(new InputStreamReader(fileInputStream));


    public ArrayList toMakeRandom() throws IOException {

        String line;
        while ((line = readerFile.readLine()) != null) {
            arrayList.add(line);
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }
}
