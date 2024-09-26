import java.io.*;

public class claseFileReader_FileWriter {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("C:/Users/chanp/OneDrive/Escritorio/archivo/EjemploFileRW.txt");
            fw.write("Texto de prueba FileReader y FileWriter");
            fw.close();

            FileReader fr = new FileReader("C:/Users/chanp/OneDrive/Escritorio/archivo/EjemploFileRW.txt");
            int valor = fr.read();

            while (valor!=-1) {
                System.out.println((char)valor);
                valor = fr.read();
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error e/S " + e);
        }
    }
}