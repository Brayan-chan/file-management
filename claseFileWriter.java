import java.io.*;

public class claseFileWriter {
    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("Miarchivo.txt");
            escritor.write("Esto es un ejemplo de escritura.\n");
            escritor.close();
            System.out.println("Escritura completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
