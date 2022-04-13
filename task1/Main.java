package com.company;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
private static final String ABSOLUTE_PATH = "D:\\hw-9.1\\Number.txt";
    public static void main(String[] args) {
        File file = new File(ABSOLUTE_PATH);
        Pattern pattern1 = Pattern.compile("^\\d{3}[-]\\d{3}[-]\\d{4}");
        Pattern pattern2 = Pattern.compile("^[(]\\d{3}[)] \\d{3}[-]\\d{4}");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

            String line = bufferedReader.readLine();
            while (line!=null){
                if (pattern1.matcher(line).find() || pattern2.matcher(line).find()){
                    System.out.println(line);
                }
                line=bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
