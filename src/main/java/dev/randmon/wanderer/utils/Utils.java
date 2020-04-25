package dev.randmon.wanderer.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Helper functions
public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String number) {
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return 0;
        }
    }
}
