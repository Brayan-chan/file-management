import java.io.*;

public class ejercicio1 {
    public static void main(String[] args) {
        File file = new File("C:/Users/chanp/OneDrive/Escritorio/archivo/miEjercicio1.txt");

        if (file.exists()) {
            System.out.println("El archivo " + file.getName() + " existe.");
        } else {
            System.out.println("El archivo no existe");
            try {
                System.out.println("Creando archivo..." + file.createNewFile());
                System.out.println("Se creo el archivo " + file.getName());

                //Comprobar que el archivo se puede leer y escribir
                System.out.println("¿Se puede leer?: " + file.canRead());
                System.out.println("¿Se puede escribir?: " + file.canWrite());
                System.out.println("El nombre del archivo es: " + file.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
