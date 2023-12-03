/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antonydiaz_prueba2;

import java.util.Random;

/**
 *
 * @author antob
 */
public class libro {
 private String nombre;
    private String autor;
    private int id;
    private String estado;
    private String dueno;

    public libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
        this.id = generarId();
        this.estado = "disponible";
        this.dueno = "";
    }

    private int generarId() {
        Random rand = new Random();
        return rand.nextInt(9000) + 1000;
    }

    public void prestar(String dueno) {
        if (estado.equals("disponible")) {
            estado = "prestado";
            this.dueno = dueno;
            System.out.println("Libro prestado a " + dueno + ".");
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    public void regresar() {
        if (estado.equals("prestado")) {
            estado = "disponible";
            dueno = "";
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("El libro no estaba prestado.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getDueno() {
        return dueno;
    }
}
