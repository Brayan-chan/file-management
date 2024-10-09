import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Practica_java_archivos {

    // Variables estáticas para control y entrada de datos
    static Scanner SC = new Scanner(System.in);

    // Colores para personalizar la salida en consola
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    // Método de bienvenida
    public static void Bienvenida() {
        String datetime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                .format(LocalDateTime.now());
        System.out.println(ANSI_BLUE + "-- [Hola/Hello, Bienvenidos/Welcome] -- " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "La fecha y hora: " + datetime + ANSI_RESET);
        System.out.println(ANSI_BLUE + "-- [Manejo de Archivos] -- " + ANSI_RESET);
        System.out.println("");
    }

    // Menú principal
    public static void Menu() {
        System.out.println("1. Crear Archivo");
        System.out.println("2. Escribir en Archivo");
        System.out.println("3. Leer Archivo");
        System.out.println("4. Eliminar Archivo");
        System.out.println("5. Renombrar Archivo");
        System.out.println("6. Crear Directorio");  // Nueva opción para crear directorios
        System.out.println("7. Comprobar Directorio");
        System.out.println("8. Comprobar Acceso");
        System.out.println("Pulse 0 para finalizar");
    }

    // Métodos de manejo de archivos
    public static void Crear(String Ruta_name) {
        try {
            File file = new File(Ruta_name);
            if (file.createNewFile()) {
                System.out.println(ANSI_GREEN + "El archivo fue creado con éxito." + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Archivo no creado (ya existe)." + ANSI_RESET);
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error al crear el archivo: " + e.getMessage() + ANSI_RESET);
        }
    }

    public static void CrearI() {
        System.out.println(ANSI_BLUE + "--{Crear Archivo}--" + ANSI_RESET);
        System.out.println("Introduzca el nombre completo para el archivo (incluyendo la extensión, ej. archivo.txt):");
        String nameA = SC.nextLine();
        Crear(nameA);
    }

    public static void escribir(String nombre, String contenido, boolean concatenar) {
        File file = new File(nombre);
        if (!file.exists()) {
            System.out.println(ANSI_RED + "El archivo no existe." + ANSI_RESET);
            return;
        }

        try (FileWriter writer = new FileWriter(file, concatenar)) {
            writer.write(contenido + "\n");
            System.out.println(ANSI_GREEN + "Texto escrito en el archivo." + ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error al escribir en el archivo: " + e.getMessage() + ANSI_RESET);
        }
    }

    public static void escribirI() {
        System.out.println(ANSI_BLUE + "--{Escribir Archivo}--" + ANSI_RESET);
        System.out.println("Introduzca el nombre del archivo:");
        String nameB = SC.nextLine();
        System.out.println("Introduzca el texto a escribir:");
        String contenido = SC.nextLine();
        escribir(nameB, contenido, true);
    }

    public static void leer(String nombre) {
        File file = new File(nombre);
        if (!file.exists()) {
            System.out.println(ANSI_RED + "El archivo no existe." + ANSI_RESET);
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error al leer el archivo: " + e.getMessage() + ANSI_RESET);
        }
    }

    public static void leerI() {
        System.out.println(ANSI_BLUE + "--{Leer Archivo}--" + ANSI_RESET);
        System.out.println("Introduzca el nombre del archivo:");
        String nameB = SC.nextLine();
        leer(nameB);
    }

    public static void Eliminar(String nameRoute) {
        File archivo = new File(nameRoute);
        if (archivo.exists() && archivo.delete()) {
            System.out.println(ANSI_GREEN + "El archivo fue eliminado con éxito." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "El archivo no fue eliminado (no existe o está en uso)." + ANSI_RESET);
        }
    }

    public static void BorrarI() {
        System.out.println(ANSI_BLUE + "--{Borrar Archivo}--" + ANSI_RESET);
        System.out.println("Introduzca el nombre del archivo:");
        String nameB = SC.nextLine();
        Eliminar(nameB);
    }

    public static void RenombrarAcc(String NameR) {
        File archivo1 = new File(NameR);
        if (archivo1.exists()) {
            System.out.println("Introduzca el nuevo nombre para el archivo:");
            String NewN = SC.nextLine();
            File archivoSustituto = new File(NewN);
            if (archivo1.renameTo(archivoSustituto)) {
                System.out.println(ANSI_GREEN + "El archivo se renombró correctamente." + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "El archivo no se renombró." + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "El archivo no existe." + ANSI_RESET);
        }
    }

    // Métodos para verificar directorio y permisos
    public static void verificarDirectorio(String directorio) {
        File dir = new File(directorio);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println(ANSI_GREEN + "El directorio existe." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "El directorio no existe o no es un directorio válido." + ANSI_RESET);
        }
    }

    public static void verificarDirectorioI() {
        System.out.println(ANSI_BLUE + "--{Verificar Directorio}--" + ANSI_RESET);
        System.out.println("Introduzca la ruta del directorio:");
        String directorio = SC.nextLine();
        verificarDirectorio(directorio);
    }

    public static void ReenombrarI() {
        System.out.println(ANSI_BLUE + "--{Renombrar Archivo}--" + ANSI_RESET);
        System.out.println("Introduzca el nombre del archivo:");
        String nameB = SC.nextLine();
        RenombrarAcc(nameB);
    }

    // Mkdir para crear directorios
    public static void CrearDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println(ANSI_GREEN + "El directorio se ha creado con éxito." + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "No se pudo crear el directorio." + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "El directorio ya existe." + ANSI_RESET);
        }
    }

    public static void CrearDirectorioI() {
        System.out.println(ANSI_BLUE + "--{Crear Directorio}--" + ANSI_RESET);
        System.out.println("Introduzca la ruta completa del directorio a crear:");
        String rutaDirectorio = SC.nextLine();
        CrearDirectorio(rutaDirectorio);
    }

    public static void verificarAcceso(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            System.out.println(ANSI_GREEN + "Permisos del archivo/directorio:" + ANSI_RESET);
            System.out.println("Lectura: " + archivo.canRead());
            System.out.println("Escritura: " + archivo.canWrite());
            System.out.println("Ejecución: " + archivo.canExecute());
        } else {
            System.out.println(ANSI_RED + "El archivo o directorio no existe." + ANSI_RESET);
        }
    }

    public static void verificarAccesoI() {
        System.out.println(ANSI_BLUE + "--{Comprobar Acceso}--" + ANSI_RESET);
        System.out.println("Introduzca la ruta del archivo o directorio:");
        String ruta = SC.nextLine();
        verificarAcceso(ruta);
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Bienvenida();
        while (true) {
            Menu();
            System.out.println("Seleccione una opción:");
            int opcion = SC.nextInt();
            SC.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    CrearI();
                    break;
                case 2:
                    escribirI();
                    break;
                case 3:
                    leerI();
                    break;
                case 4:
                    BorrarI();
                    break;
                case 5:
                    ReenombrarI();
                    break;
                case 6:
                    CrearDirectorioI();  // Nueva opción para crear directorios
                    break;
                case 7:
                    verificarDirectorioI();
                    break;
                case 8:
                    verificarAccesoI();
                    break;
                case 0:
                    System.out.println(ANSI_BLUE + "Finalizando programa..." + ANSI_RESET);
                    System.exit(0);
                default:
                    System.out.println(ANSI_RED + "Opción no válida." + ANSI_RESET);
            }
        }
    }
}
