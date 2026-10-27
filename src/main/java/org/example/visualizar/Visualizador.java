package org.example.visualizar;

public class Visualizador {
    public static void main(String[] args) {
        //Compruebo que haya argumentos y que la cadena NO esté vacía,además quito sus espacios.
        if(args.length < 2 || args[0].trim().isEmpty()){
            System.out.println("Cadena introducida vacía");
            System.exit(1);
        }else{
            // Obtengo el número de repeticiones desde el segundo argumento.
            int repeticiones = Integer.parseInt(args[1]);
            for(int i = 1;i <= repeticiones; i++){
                System.out.println(i+". "+args[0]);
            }
            //Salida exitosa al finalizar.
            System.exit(0);
        }
    }
}
