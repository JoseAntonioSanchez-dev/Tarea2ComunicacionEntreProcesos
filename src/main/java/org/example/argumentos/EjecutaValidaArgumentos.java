package org.example.argumentos;

import java.io.*;
import java.util.ArrayList;

public class EjecutaValidaArgumentos {
    public static void main(String[] args){
        String classpath= System.getProperty("java.class.path");
        ArrayList <String> comando = new ArrayList<>();
        comando.add("java");
        comando.add("-cp");
        comando.add(classpath);
        comando.add("org.example.argumentos.ValidaArgumentos");

        //Me aseguro de que los argumentos recibidos NO sean  null y que NO estén vacíos para añadirlos.
        String argumentos = "";
        if (argumentos != null && !argumentos.isEmpty()) {
            comando.add(argumentos);
        }
        try{
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();
            // Según el código de salida del hijo entrará al case correspondiente.
            int codigoSalida = p.waitFor();
            System.out.println("Valor de salida: "+codigoSalida);
            switch (codigoSalida){
                case 1:
                    System.out.println("No hay argumentos...");
                    break;
                case 2:
                    System.out.println("Es una cadena... ");
                    break;
                case 3:
                    System.out.println("Número menor que 0... ");
                    break;
                case 4:
                    System.out.println("Número mayor o igual a 0... ");
                    break;
            }

        }catch (IOException ex){
            System.out.println("Error en la entrada/salida de datos "+ex.getMessage());
        }catch (InterruptedException ex){
            System.out.println("Proceso interrumpido por el error "+ex.getMessage());
        }

    }
}
