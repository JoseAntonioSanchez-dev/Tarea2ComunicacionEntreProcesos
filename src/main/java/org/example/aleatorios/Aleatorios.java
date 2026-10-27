package org.example.aleatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Aleatorios {
    public static void main(String[] args) {
        try{
            //Lector que recibirá las peticiones del padre.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Random r = new Random();
            String linea;
            while((linea = br.readLine())!= null){
                //Genero el número entre 0 y 10 incluyendo ambos.
                int numero = r.nextInt(11);
                //Envio el número al padre imprimiendoló en su salida.
                System.out.println(numero);
            }
            //Cierro el flujo de lectura.
            br.close();
        }catch (IOException ex){
            System.out.println("Error de entrada/salida "+ex.getMessage());
        }
    }
}
