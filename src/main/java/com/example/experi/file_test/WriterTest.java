package com.example.experi.file_test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTest {

    public static void main(String[] args) throws IOException {




        File file = new File("C:\\Users\\fidoqin\\Desktop\\test3.txt");

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("111");

        fileWriter.close();


    }


}
