/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yann
 */
public class Practica7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean seguirMostrandoMenu = true;
        while(seguirMostrandoMenu){
            System.out.println("1. Lectura y escritura del fichero de cartelera byte a byte (byte Streams).");
            System.out.println("2. Lectura y escritura de fichero de cartelera carácter a carácter (character Streams).");
            System.out.println("3. Lectura y escritura de fichero línea a línea con buffers (character Streams).");
            System.out.println("4. Salir");
            Scanner lector = new Scanner(System.in);
            int opcion = lector.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("1. Lectura y escritura del fichero de cartelera byte a byte (byte Streams).");
                    System.out.println("Dime la ruta de entrada");
                    String entrada = lector.next();
                    System.out.println("Dime la ruta de salida");
                    String salida = lector.next();
                    //int i;
                    try(FileInputStream fin = new FileInputStream(entrada);
                        FileOutputStream fout = new FileOutputStream(salida)){
                        
                        int i;
                        int contadorPeliculas = 1;
                        do{
                            i = fin.read();
                            if(i != -1){
                                if(i == '{'){
                                    contadorPeliculas++;
                                }
                            }
                        }
                        while(i != -1);
                        
                        //System.out.println(contadorPeliculas);
                                
                        for(int j = 0;j<contadorPeliculas;j++){
                            escribirCabecera(fout);
                            escribirTitulo(fin, fout);
                            escribirAño(fin, fout);
                        }
                        
                   
                        
                        
                    }
                    catch(FileNotFoundException exc){
                        System.out.println("Error, el archivo de origen no existe");
                    }
                    catch(IOException exc) {
                        System.out.println("Error al leer el archivo");
                        System.out.println(exc.getMessage());
                    }
                    break;
            }
        }
    }

    public static void escribirCabecera(final FileOutputStream fout) throws IOException {
        String cabecera = "-------------------------------------- \n Cartelera de CineFBMoll \n--------------------------------------";
        fout.write(cabecera.getBytes());
    }
    
    public static void escribirTitulo(final FileInputStream fin, final FileOutputStream fout) throws IOException {
        int i;
        String titulo = "\n-----";
        fout.write(titulo.getBytes());
        boolean seguirEscribiendo = true;
        do{
            i = fin.read();
            if(i == '#'){
                seguirEscribiendo = false;
            }
            else{
                fout.write(i);
            }
        }
        while(seguirEscribiendo);
        String titulo2 = "-----";
        fout.write(titulo2.getBytes());
    }
    
    public static void escribirAño(final FileInputStream fin, final FileOutputStream fout) throws IOException {
        int i;
        String titulo = "\nAño: ";
        fout.write(titulo.getBytes());
        boolean seguirEscribiendo = true;
        do{
            i = fin.read();
            if(i == '#'){
                while(i != '#'){
                    fout.write(i);
                }  
            }
            /*else{
                fout.write(i);
            }*/
        }
        while(seguirEscribiendo);
        String titulo2 = "-----";
        fout.write(titulo2.getBytes());
    }
}
