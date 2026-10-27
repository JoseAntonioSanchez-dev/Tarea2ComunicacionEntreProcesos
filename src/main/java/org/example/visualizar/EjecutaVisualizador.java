package org.example.visualizar;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

public class EjecutaVisualizador {
    public static void main(String[] args) {
        System.out.print("Introduce una cadena: ");
        String cadena = Entrada.cadena();
        try{
            //Configuro el ProcessBuilder pasandolé la cadena y el número de repeticiones
            ProcessBuilder pb = new ProcessBuilder("java","-cp",
                    System.getProperty("java.class.path"),
                    "org.example.visualizar.Visualizador",cadena,"5");
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while((linea = br.readLine())!= null){
                System.out.println(linea);
            }
            //Cierro el flujo de lectura.
            br.close();

            //Espero a que el hijo acabe y muestro el código de salida.
            int codigoSalida = p.waitFor();
            System.out.println("Valor de salida: "+codigoSalida);

            //Según sea el codigo de salida será correcto 0 o incorrecto 1.
            if(codigoSalida == 0){
                System.out.println("Final Correcto");
            }else{
                System.out.println("Final Incorrecto");
            }
        }catch (IOException ex){
            System.out.println("Error en la entrada/salida de datos "+ex.getMessage());
        }catch (InterruptedException ex){
            System.out.println("Proceso interrumpido por el error "+ex.getMessage());
        }
    }
}
