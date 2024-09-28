import java.io.*;

public class ExplicandoArchivos {

    public static void main(String[] args) {
        File arcivo1 = new File("/Users/brayanchan/Desktop/MisDocumentos/prueba.txt");
        //Comprobar que el archivo existe con el método exist()
        //System.out.println("Existe:" + arcivo1.exists());

        if (arcivo1.exists()) {
            System.out.println("El archivo " + arcivo1.getName() + " existe.");
        } else {
            System.out.println("El archivo no existe");
            try {
                System.out.println("Creando archivo..." + arcivo1.createNewFile());
                System.out.println("Se creo el archivo " + arcivo1.getName());

                //Comprobar que el archivo se puede leer y escribir
                System.out.println("¿Se puede leer?: " + arcivo1.canRead());
                System.out.println("¿Se puede escribir?: " + arcivo1.canWrite());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    
}