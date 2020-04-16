/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7ej3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yann
 */
public class Practica7ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] campos = {"Alumno: ", "Módulo ", "Nota ", "Lenguaje de marcas                    ", "Entornos de desarrollo ", "Base de datos ", "Sistemas informáticos ", "FOL ", "Nº de módulos aprobados: ", "Nº de módulos suspendidos: ", "Nº de módulos convalidados: ", "Fecha: "};
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime la ruta de entrada");
        String entrada = lector.next();
        System.out.println("Dime la ruta de salida");
        String salida = lector.next();
        int i = 1;
        try(BufferedReader lectorMejorado = new BufferedReader(new FileReader(entrada)); /*BufferedWriter escritorMejorado = new BufferedWriter(new FileWriter(salida))*/){
            boolean eof = false;
            String lineaLeida = lectorMejorado.readLine();
            //System.out.println(lineaLeida);
            while (lineaLeida != null) {
                String nombreAlumno =  "";
                boolean seguirObteniendoNombre =  true;
                int j = 0;
                int contadorEspaciosNombre = 0;
                while(seguirObteniendoNombre){
                    char c = lineaLeida.charAt(j);
                    if (c!=' '){
                        nombreAlumno+=c;
                    }
                    if (c==' '){
                        contadorEspaciosNombre++; 
                    }
                    j++;
                    if( contadorEspaciosNombre==3){
                        seguirObteniendoNombre = false;
                    }
                }
                BufferedWriter escritorMejorado = new BufferedWriter(new FileWriter(salida+nombreAlumno+".txt"));
                escritorMejorado.append("\n---------------------------------------------\n" +
"Boletín de notas CIFP FBMOLL\n" +
"---------------------------------------------\n");
                
                escritorMejorado.append(campos[0]);
                //System.out.println("");
                boolean seguirImprimiendo =  true;
                int n = 0;
                int contadorEspacios = 0;
                while(seguirImprimiendo){
                    char c = lineaLeida.charAt(n);
                    if (c==' '){
                       contadorEspacios++; 
                    }
                    escritorMejorado.append(c);
                    n++;
                    if(contadorEspacios==3){
                        seguirImprimiendo = false;
                    }
                }
                escritorMejorado.append("\n------------------------------   -------\n"+campos[1]+"                            "+campos[2]+"\n------------------------------   -------\n");
                escritorMejorado.append(campos[3]);
                
                /*boolean seguirBuscandoNota = true;
                int y = 0;
                while(seguirBuscandoNota){

                    char c = lineaLeida.charAt(y);
                    
                    if (Character.isDigit(c)){
                        escritorMejorado.append(c);
                        seguirBuscandoNota=false;
                    }
                    y++;
                }*/
                
                int modulosAprobados = 0;
                int modulosSuspendidos = 0;
                int modulosConvalidados = 0;
                
                boolean seguirBuscandoNota = true;
                int y = 0;
                int contadorEspaciosNota = 0;
                while(seguirBuscandoNota){
                    char c = lineaLeida.charAt(y);
                    if(contadorEspaciosNota==3){
                        seguirBuscandoNota = false;
                        if(Character.isDigit(c)){
                            escritorMejorado.append(c);
                            if(c<5){
                                modulosSuspendidos++;
                            }
                            else{
                                modulosAprobados++;
                            }
                        }
                        else{
                            char d = lineaLeida.charAt(y+2);
                            escritorMejorado.append("c-"+d);
                            modulosConvalidados++;
                            modulosAprobados++;
                        }
                    }
                    if(c==' '){
                       contadorEspaciosNota++; 
                    }
                    
                    y++;
                }
                
                /*for (int n = 0; n<lineaLeida.length(); n++) { 
                    char c = lineaLeida.charAt (n); 
                    //if()
                    System.out.print (c); 
                }*/
                
                //boolean nombreCompleto = false;
                //int letra = lectorMejorado.read();
                
                /*int value;
                    while ((value = lineaLeida.read()) != -1) {
                        //content.append((char) value);
                        System.out.print((char) value);
                }*/
                
                /*while(lectorMejorado.read()!=-1){
                    
                    System.out.print((char) lectorMejorado.read());
                    //content.append((char) value);
                }*/
                /*for (int j = 0; j < campos.length; j++) {
                    System.out.println(campos[j]);
                }*/
                //System.out.println(lineaLeida);
                // read next line
                escritorMejorado.close();
                i++;
                lineaLeida = lectorMejorado.readLine();
            }
        }
        catch(FileNotFoundException exc){
            System.out.println("Error, el archivo de origen no existe");
        }
        catch(IOException exc) {
            System.out.println("Error al leer el archivo");
            System.out.println(exc.getMessage());
        }
    }
    
}
