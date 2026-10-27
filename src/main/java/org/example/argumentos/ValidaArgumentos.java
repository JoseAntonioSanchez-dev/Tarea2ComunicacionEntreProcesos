package org.example.argumentos;


public class ValidaArgumentos {
    public static void main(String[] args) {
        //Compruebo si se ha pasado al menos un argumento.
        if(args.length < 1){
            System.exit(1);
        }else{
         try {
             //Intento convertir el primer argumento a entero.
             int numero = Integer.parseInt(args[0]);
             //Si es menor que 0, sino cualquier otra situación.
             if (numero < 0) {
                 System.exit(3);
             } else {
                 System.exit(4);
             }
             //La excepción saltará si no es un entero,es una cadena.
            }catch(NumberFormatException ex){
             System.exit(2);
            }
        }
    }
}

