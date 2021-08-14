//make a java program to show creating a file, writing data in file and reading data from file
import java.io.*;

public class fileHandling{
    public static void main(String[] args){
        try{
            File file = new File("test.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("This is a test file with different content");
            bw.close();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("Error in creating file");
        }
    }
};