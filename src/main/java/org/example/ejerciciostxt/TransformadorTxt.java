package org.example.ejerciciostxt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformadorTxt {
    public static void main(String[] args) {
        try{
            //Leo desde el padre la cadena que me mande.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            while((linea = br.readLine())!= null){
                //La convierto a mayúsculas y la muestro.
                linea = linea.toUpperCase();
                System.out.println(linea);
            }
            //Cierro el flujo de lectura.
            br.close();
        }catch (IOException ex){
            System.out.println("Error de entrada/salida en el fichero txt "+ex.getMessage());
        }
    }
}
