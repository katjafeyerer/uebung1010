package Splittisplit;

import java.io.*;
import java.util.ArrayList;

public class FileSplitter {
    public void split(String path){

        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {

            String line;
            ArrayList<String> lines = new ArrayList<>();
            ArrayList<String> geradeListe = new ArrayList<>();
            ArrayList<String> ungeradeListe = new ArrayList<>();
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            int value = 0;
            for (String s: lines) {
                value++;
                if(value % 2 == 0){
                    geradeListe.add(s);

                }
                else{
                    ungeradeListe.add(s);

                }
            }
            System.out.println("Gerade liste");
            for (String strings: geradeListe) {
                System.out.println(strings);
            }
            System.out.println();
            System.out.println("Ungerade Liste");
            for (String strings2: ungeradeListe) {
                System.out.println(strings2);
            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
