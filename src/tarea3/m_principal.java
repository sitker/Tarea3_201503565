/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import java.util.Scanner;

/**
 *
 * @author Merari
 */
public class m_principal {
    
    int opcion;
    Scanner lector;
    String usuarios[];
    boolean bandera;
    boolean compUsuarios;
    
    public m_principal(){
        opcion = 0;
        lector = new Scanner(System.in);  //se inicia aqui en el constructor porque es global
        usuarios = new String[5];
        bandera = false;
        compUsuarios = false;
        
    }
    
    public void menuPrincipal(){
        do{
        System.out.println("***********************************");
        System.out.println("Tarea 3");
        System.out.println("201503565");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Usuarios");
        System.out.println("2. Palabras Palíndromas");
        System.out.println("3. Salir");
        System.out.println("***********************************");
 
            opcion = lector.nextInt();
            switch(opcion){
                case 1:
                    usuarios();
                    break;
                case 2:
                    palabras_palindromas();
                    break;
                case 3:
                    System.exit(0);
            }        
        }while(opcion != 3);
    }

    private void usuarios() {
       do{
           System.out.println("***********************************");
           System.out.println("Menú de Usuarios");
           System.out.println("1. Ingresar Usuarios");
           System.out.println("2. Mostrar todos los Usuarios");
           System.out.println("3. Mostrar un Usuario Personalizado");
           System.out.println("4. Menú Principal");
           System.out.println("5. Salir");
           System.out.println("***********************************");
           
           opcion = lector.nextInt();
           switch(opcion){
               case 1:
                   creaUsuario();
                   break;
               case 2:
                   muestraUsuarios();
                   break;
               case 3:
                   persUsuario();
                   break;
               case 4:
                   menuPrincipal();
                   break;
               case 5:
                   System.exit(0);
           }
           
       }while(opcion != 5);
    }

    private void palabras_palindromas() {
        String lect = lector.nextLine(); //para limpiar el lector de nextInt anterior porque imprime un \n
        String palabra;
        System.out.println("Ingrese una palabra: ");
        palabra = this.lector.nextLine().toLowerCase().replace(" ", "");
        StringBuffer palabraRev = new StringBuffer(palabra);
        palabraRev = palabraRev.reverse();
        if(palabra.equals(palabraRev.toString())){
            System.out.println("¡SI ES PALINDROMA!!!!!");
        }else{
            System.out.println("¡NO ES PALINDROMA!!!!!");
        }
    }

    private void creaUsuario() {
        int actual;
        for(actual = 0; actual < 5; actual++ ){
            System.out.println("Ingrese el nombre del usuario " + (actual+1) + ":");
            usuarios[actual] = this.lector.next().toUpperCase();
        }
        System.out.println("Usuarios creados exitosamente.");
        bandera = true;
    }

    private void muestraUsuarios() {
      if(bandera){
        System.out.println("Los usuarios actuales son: ");
        int actual;
        for(actual = 0; actual < 5; actual++){
            System.out.println("Usuario " + (actual+1) + " :");
            System.out.println(usuarios[actual] + "\n");
        }
      }else{
          System.out.println("Aún no se han creado usuarios.");
      }
    }

    private void persUsuario() {
      if(bandera){
        String nombreUs;
        int actual;
        System.out.println("Ingrese un usuario");
        nombreUs = this.lector.next().toUpperCase();
        for(actual = 0; actual < 5; actual++){
          if(!compUsuarios){
                if(nombreUs.equals(usuarios[actual])){
                    System.out.println("Usuario \n" + usuarios[actual]);
                    compUsuarios = true;
                }
          }
        }
        if(!compUsuarios){
            System.out.println("ERROR!! No existe ningún usuario con esa coincidencia");
        }
        compUsuarios = false;
      }else{
          System.out.println("Aún no se han creado usuarios.");
      }
    }
    
}