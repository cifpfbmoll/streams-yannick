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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        String[] campos = {"Alumno: ", "Módulo ", "Nota ", "Nº de módulos aprobados: ", "Nº de módulos suspendidos: ", "Nº de módulos convalidados: ", "Fecha: "};
        String[] notas = {"Lenguaje de marcas                   ", "Programación                         ", "Entornos de desarrollo               ", "Base de datos                        ", "Sistemas informáticos                ", "FOL                                  "};
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
                
                int modulosAprobados = 0;
                int modulosSuspendidos = 0;
                int modulosConvalidados = 0;
                int contadorEspaciosNota = 0;
                int posicionNota = 3;
                int y = 0;
                
                for(int q = 0; q<notas.length; q++){
                    escritorMejorado.append(notas[q]);
                    boolean seguirBuscandoNota = true;
                    
                    while(seguirBuscandoNota){
                        char c = lineaLeida.charAt(y);
                        if(contadorEspaciosNota==posicionNota){
                            seguirBuscandoNota = false;
                            posicionNota++;
                            if(Character.isDigit(c)){
                                escritorMejorado.append(c);
                                int s = y+1;
                                char caracterSiguiente = lineaLeida.charAt(s);
                                escritorMejorado.append(caracterSiguiente+"\n");
                                
                                if(Character.isDigit(caracterSiguiente)){
                                    String numeroCompleto = new StringBuilder().append(c).append(caracterSiguiente).toString();
                                    //String numeroFinal = c+""+caracterSiguiente;
                                    int numeroFinalint = Integer.parseInt(numeroCompleto);
                                    //escritorMejorado.append(numeroFinal);

                                    if(numeroFinalint>=5){
                                        modulosAprobados++;
                                    }
                                    else{
                                        modulosSuspendidos++;
                                    }
                                }
                                else{
                                    int d=Character.getNumericValue(c);
                                    if(d>=5){
                                        modulosAprobados++;
                                    }
                                    else{
                                        modulosSuspendidos++;
                                    }
                                }
                                
                            }
                            else{
                                escritorMejorado.append("c-5 \n");
                                modulosConvalidados++;
                                modulosAprobados++;
                            }
                        }
                        if(c==' '){
                           contadorEspaciosNota++; 
                        }
                        
                        y++;
                    }
                    
                }
                
                escritorMejorado.append("------------------------------------------\n");
                escritorMejorado.append("Nº de módulos aprobados:                "+modulosAprobados+"\nNº de módulos suspendidos:              "+modulosSuspendidos+"\nNº de módulos convalidados:             "+modulosConvalidados+"\n");
                escritorMejorado.append("------------------------------------------\n");
                
                /*Calendar c1 = Calendar.getInstance();
                Calendar c2 = new GregorianCalendar();
                
                dia = Integer.toString(c.get(Calendar.DATE));
                mes = Integer.toString(c.get(Calendar.MONTH));
                annio = Integer.toString(c.get(Calendar.YEAR));*/
                
                Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
 
                //System.out.println(objDate); 
                String strDateFormat = "dd/MM/yyyy"; // El formato de fecha está especificado  
                SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
                escritorMejorado.append("\nFecha: "+objSDF.format(objDate)+"\nLugar: Palma de Mallorca\n"); // El formato de fecha se aplica a la fecha actual
                
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
