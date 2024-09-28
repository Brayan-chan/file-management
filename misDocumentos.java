import java.io.*;

public class misDocumentos {
    public static void main(String[] args) {
        File miArchivo = new File("/Users/brayanchan/Desktop/MisDocumentos/miArchivo.txt");

        if (miArchivo.exists()) {
            System.out.println("El archivo " + miArchivo.getName() + " existe.");
        } else {
            System.out.println("El archivo no existe");
            try {
                System.out.println("Creando archivo..." + miArchivo.createNewFile());
                System.out.println("Se creo el archivo " + miArchivo.getName() + " correctamente.");

                FileWriter escritor = new FileWriter(miArchivo);
                escritor.write("Nombre de los integrantes de mi equipo: \n" +
                        "Brayan Chan Pacheco\n" +
                        "Josue Hernandez Lopez");
                escritor.close();
                System.out.println("Escritura completada.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}