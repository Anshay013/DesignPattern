package javaprac;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class AnyFileReader {

    public static void main(String[] args) {

// use bufferReader for
   /*     // for csv file
        String line = "";
        String csvSplit = ",";

        try(BufferedReader br = new BufferedReader(new FileReader("my file"))){

            while((line = br.readLine()) != null) {
                String []data = line.split(csvSplit);

                for (String datum : data) {
                    System.out.println(datum);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // use path and Stream<String> to collect fomr Files.lines for .txt files

        Path path = Paths.get("data.txt");
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(x -> System.out.println(x));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        */
        String x = UUID.randomUUID().toString();
        System.out.println(x);

    }
}
