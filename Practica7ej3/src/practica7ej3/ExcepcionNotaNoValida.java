/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7ej3;

/**
 *
 * @author Yann
 */
public class ExcepcionNotaNoValida extends Exception{
    private String mensaje;

    public ExcepcionNotaNoValida(String alumno) {
        this.mensaje = alumno+"no puede tener un 0 en el módulo Programación. Debes poner una nota";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
