import java.io.*;

public class ejercicio3 {
    public static void main(String[] args) {
        File archivoEliminar = new File("C:/Users/chanp/OneDrive/Escritorio/archivo/archivoParaEliminar.txt");

        if (archivoEliminar.exists()) {
            System.out.println("El archivo " + archivoEliminar.getName() + " existe.");
        } else {
            System.out.println("El archivo no existe");
            try {
                System.out.println("Creando archivo..." + archivoEliminar.createNewFile());
                System.out.println("Se creo el archivo " + archivoEliminar.getName());
                System.out.println("El nombre del archivo es: " + archivoEliminar.getName());
                System.out.println("El archivo: " + archivoEliminar.getName() + " sera eliminado");
                System.out.println("Eliminando archivo...");
                if (archivoEliminar.delete()) {
                    System.out.println("Se elimino el arcivo correctamente");
                } else {
                    System.out.println("No se pudo eliminar el archivo");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
