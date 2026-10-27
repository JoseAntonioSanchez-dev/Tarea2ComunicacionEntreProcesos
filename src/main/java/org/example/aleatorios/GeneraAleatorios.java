package org.example.aleatorios;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class GeneraAleatorios {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "org.example.aleatorios.Aleatorios");
            Process p = pb.start();

            //Escribo las peticiones en el hijo.
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            //Leer el número que me devuelve el hijo.
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String cadena = Entrada.cadena();
            //Bucle que se ejecutará mientras el usuario no ponga fin
            while(!cadena.equalsIgnoreCase("fin")) {
                bw.write(cadena);
                bw.newLine();
                bw.flush();

                // Leo el número aleatorio generado por el hijo y lo muestro.
                String respuesta = br.readLine();
                System.out.println(respuesta);

                //Solicito la siguiente cadena al usuario.
                cadena = Entrada.cadena();
            }
            //Finalizo la ejecución del hijo y cierro los flujos.
            bw.close();
            br.close();
            p.destroy();
            p.waitFor();
        } catch (IOException ex) {
            System.out.println("Error en la entrada/salida " + ex.getMessage());

        }catch (InterruptedException ex){
            System.out.println("Proceso interrumpido "+ex.getMessage());
        }
    }
}
