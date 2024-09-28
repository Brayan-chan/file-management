import java.io.*;

public class claseFileReader_FileWriter {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("/Users/brayanchan/Desktop/EjemploFileRW.txt");
            fw.write("Texto de prueba FileReader y FileWriter");
            fw.close();

            FileReader fr = new FileReader("/Users/brayanchan/Desktop/EjemploFileRW.txt");
            fr.read();

            fr.close();
        } catch (IOException e) {
            System.out.println("Error e/S " + e);
        }
    }
}