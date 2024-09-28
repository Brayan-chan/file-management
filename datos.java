import java.io.*;

public class datos {
    public static void main(String[] args) {
        File datos = new File("/Users/brayanchan/Desktop/MisDocumentos/datos.txt");

        if (datos.exists()) {
            System.out.println("El archivo " + datos.getName() + " existe.");
        } else {
            System.out.println("El archivo no existe");
            try {
                System.out.println("Creando archivo..." + datos.createNewFile());
                System.out.println("Se creo el archivo " + datos.getName() + " correctamente.");

                FileWriter escritor = new FileWriter(datos);
                escritor.write("Linea 1: Esta es mi primera linea ingresado en Java. \n");
                escritor.write("Linea 2: Esta es mi segunda linea. \n");
                escritor.write("Linea 3: Esta es mi tercera linea. \n");
                escritor.close();
                System.out.println("Escritura completada.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        try {
            BufferedReader lector = new BufferedReader(new FileReader(datos));
            String linea = lector.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = lector.readLine();
            }
            lector.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}