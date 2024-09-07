import java.io.*;

public class ejercicio2 {
    public static void main(String[] args) {
        File archivoTemporal = new File("C:/Users/chanp/OneDrive/Escritorio/archivo/archivoTemporal.txt");

        if (archivoTemporal.exists()) {
            System.out.println("El archivo " + archivoTemporal.getName() + " existe.");
        } else {
            System.out.println("El archivo no existe");
            try {
                System.out.println("Creando archivo..." + archivoTemporal.createNewFile());
                System.out.println("Se creo el archivo " + archivoTemporal.getName());

                //Comprobar que el archivo se puede escribir
                System.out.println("¿Se puede escribir?: " + archivoTemporal.canWrite());
                System.out.println("El nombre del archivo es: " + archivoTemporal.getName());
                if (archivoTemporal.canWrite()) {
                    //Renombrar el archivo Temporal a archivoFinal.txt
                    archivoTemporal.renameTo(new File("C:/Users/chanp/OneDrive/Escritorio/archivo/archivoFinal.txt"));
                    System.out.println("Se renombro el archivo temporal a archivoFinal.txt correctamente");
                } else {
                    System.out.println("No se pudo renombrar el archivo temporal");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
