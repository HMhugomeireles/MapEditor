package org.ac.mapeditor.stream;

import java.io.*;
import java.util.LinkedList;

public class FileManager {

    private static final String PATH_FILE = "recourses/mapeditor.txt";
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public void save(String[] lines) {

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(PATH_FILE));

            for (int i = 0; i < lines.length; i++) {

                bufferedWriter.write(lines[i]);
                bufferedWriter.newLine();

            }


        } catch (IOException ex) {
            System.out.println("Error on stream -> " + ex.getMessage());
        } finally {
            try {

                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

            } catch (IOException ex) {
                System.out.println("Error on close stream -> " + ex.getMessage());
            }
        }

    }

    public String open() {

        String file = "";

        try {

            bufferedReader = new BufferedReader(new FileReader(PATH_FILE));

            String line;

            while ((line = bufferedReader.readLine()) != null){
                file += line + "\n";
            }


        } catch (IOException ex) {
            System.out.println("Error on stream -> " + ex.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.out.println("Error on close stream -> " + ex.getMessage());
            }
        }

        return file;
    }
}
