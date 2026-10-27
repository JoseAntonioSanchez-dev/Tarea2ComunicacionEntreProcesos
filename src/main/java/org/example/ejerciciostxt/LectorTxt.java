package org.example.ejerciciostxt;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class LectorTxt {
    public static void main(String[] args) {
        try{
            ProcessBuilder pb = new ProcessBuilder("java","-cp",System.getProperty("java.class.path"),"org.example.ejerciciostxt.TransformadorTxt");
            Process p = pb.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            System.out.println("Introduce una línea de texto: ");
            String linea = Entrada.cadena();
            while(!linea.equalsIgnoreCase("fin")){
                //Enviarlo al hijo para que lo ponga en mayúsculas.
                bw.write(linea);
                bw.newLine();
                bw.flush();

                // Leo lo que devuelve el proceso hijo para mostrarlo.
                String respuesta = br.readLine();
                System.out.println(respuesta);
                //Vuelvo a leer desde teclado para la siguiente vuelta mientras se cumpla la condición.
                linea = Entrada.cadena();
            }
            // Cuando ponga "fin",cierro los flujos de lectura y escritura y finalizo el hijo.
            bw.close();
            br.close();
            p.destroy();
        }catch (IOException ex){
            System.out.println("Error en la entrada/salida del fichero "+ex.getMessage());
        }
    }
}
