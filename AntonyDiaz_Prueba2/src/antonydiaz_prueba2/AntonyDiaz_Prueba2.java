/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package antonydiaz_prueba2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author antob
 */
public class AntonyDiaz_Prueba2 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<libro> biblioteca = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
         while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Nuevo libro a la biblioteca");
            System.out.println("2. Solicitar libro");
            System.out.println("3. Regresar libro");
            System.out.println("4. Buscar libro por nombre");
            System.out.println("5. Listar libros disponibles");
            System.out.println("6. Listar libros prestados");
            System.out.println("7. Salir");

            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el nombre del autor: ");
                    String autor = scanner.nextLine();
                    agregarLibro(biblioteca, nombre, autor);
                    break;
                case 2:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese el nombre de la persona que solicita el libro: ");
                    String dueno = scanner.nextLine();
                    System.out.print("Ingrese la posición del libro que desea solicitar: ");
                    int posicionSolicitud = scanner.nextInt();
                    solicitarLibro(biblioteca, dueno, posicionSolicitud);
                    break;
                case 3:
                    System.out.print("Ingrese la posición del libro que está devolviendo: ");
                    int posicionDevolucion = scanner.nextInt();
                    regresarLibro(biblioteca, posicionDevolucion);
                    break;
                case 4:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese el nombre del libro a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    buscarLibroPorNombre(biblioteca, nombreBusqueda);
                    break;
                case 5:
                    listarLibrosDisponibles(biblioteca);
                    break;
                case 6:
                    listarLibrosPrestados(biblioteca);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    private static void agregarLibro(ArrayList<libro> biblioteca, String nombre, String autor) {
        libro libro = new libro(nombre, autor);
        biblioteca.add(libro);
        System.out.println("Libro '" + nombre + "' agregado a la biblioteca.");
    }

    private static void solicitarLibro(ArrayList<libro> biblioteca, String dueno, int posicion) {
        if (posicion >= 0 && posicion < biblioteca.size()) {
            libro libro = biblioteca.get(posicion);
            libro.prestar(dueno);
        } else {
            System.out.println("Posición inválida.");
        }
    }

    private static void regresarLibro(ArrayList<libro> biblioteca, int posicion) {
        if (posicion >= 0 && posicion < biblioteca.size()) {
            libro libro = biblioteca.get(posicion);
            libro.regresar();
        } else {
            System.out.println("Posición inválida.");
        }
    }

    private static void buscarLibroPorNombre(ArrayList<libro> biblioteca, String nombre) {
        ArrayList<libro> encontrados = new ArrayList<>();
        for (libro libro : biblioteca) {
            if (libro.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(libro);
            }
        }

        if (!encontrados.isEmpty()) {
            System.out.println("Libros encontrados:");
            for (libro libro : encontrados) {
                System.out.println(libro.getNombre() + " - " + libro.getAutor());
            }
        } else {
            System.out.println("No se encontraron libros con el nombre '" + nombre + "'.");
        }
    }

    private static void listarLibrosDisponibles(ArrayList<libro> biblioteca) {
        ArrayList<libro> disponibles = new ArrayList<>();
        for (libro libro : biblioteca) {
            if (libro.getEstado().equals("disponible")) {
                disponibles.add(libro);
            }
        }

        if (!disponibles.isEmpty()) {
            System.out.println("Libros disponibles:");
            for (libro libro : disponibles) {
                System.out.println(libro.getNombre() + " - " + libro.getAutor());
            }
        } else {
            System.out.println("No hay libros disponibles en este momento.");
        }
    }

    private static void listarLibrosPrestados(ArrayList<libro> biblioteca) {
        ArrayList<libro> prestados = new ArrayList<>();
        for (libro libro : biblioteca) {
            if (libro.getEstado().equals("prestado")) {
                prestados.add(libro);
            }
        }

        if (!prestados.isEmpty()) {
            System.out.println("Libros prestados:");
            for (libro libro : prestados) {
                System.out.println(libro.getNombre() + " - " + libro.getAutor() + " (Prestado a " + libro.getDueno() + ")");
            }
        } else {
            System.out.println("No hay libros prestados en este momento.");
        }
    }

    
}
