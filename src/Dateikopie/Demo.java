package Dateikopie;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        String source = ".\\data\\address.csv";
        String destination = ".\\data\\addressCopy.csv";

        copyFile(source, destination);
    }
    public static void copyFile(String source, String destination){

        File sourceFile = new File(source);
        File destinationFile = new File(destination);

        try(FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile)){

            int byteRead;
            while((byteRead = fis.read()) != -1){
                char c = (char) byteRead;
                fos.write(c);
                fos.flush();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
