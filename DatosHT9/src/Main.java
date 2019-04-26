
import Clases.*;
import java.util.Scanner;

/*
 *
 * @author Marco Fuentes y Andy Castillo
 */
public class Main {
    public static void main (String[] args){
        String menu = "\t Bienvenido al Traductor de palabras\n¿Que estructura deseas usar?\n"
                + "1. Splay\n2. RBT";
        System.out.println(menu);
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        int respuesta = Integer.parseInt(res);
        Factory f = new Factory(respuesta);
        
        BST arbol = f.getArbol();
        //Ya tengo la estructura con diseño FACTORY
    }
}
