/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7ej3;

import java.io.Serializable;

/**
 *
 * @author Yann
 */
public class Notas implements Serializable{
    private String nombre;
    private String[] notas;
    private int modulosAprobados;
    private int modulosSuspendidos;
    private int modulosConvalidados;
    private String fecha;
    private String lugar;

    public Notas(String nombre, String[] notas, int modulosAprobados, int modulosSuspendidos, int modulosConvalidados, String fecha, String lugar) {
        this.nombre = nombre;
        this.notas = notas;
        this.modulosAprobados = modulosAprobados;
        this.modulosSuspendidos = modulosSuspendidos;
        this.modulosConvalidados = modulosConvalidados;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getNotas() {
        return notas;
    }

    public void setNotas(String[] notas) {
        this.notas = notas;
    }

    public int getModulosAprobados() {
        return modulosAprobados;
    }

    public void setModulosAprobados(int modulosAprobados) {
        this.modulosAprobados = modulosAprobados;
    }

    public int getModulosSuspendidos() {
        return modulosSuspendidos;
    }

    public void setModulosSuspendidos(int modulosSuspendidos) {
        this.modulosSuspendidos = modulosSuspendidos;
    }

    public int getModulosConvalidados() {
        return modulosConvalidados;
    }

    public void setModulosConvalidados(int modulosConvalidados) {
        this.modulosConvalidados = modulosConvalidados;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
}
