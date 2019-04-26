
import Clases.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
        Factory factory = new Factory(respuesta);
        
        BST arbol = factory.getArbol();
        //Ya tengo la estructura con diseño FACTORY
        
        String archivo = "freedict-eng-spa.txt";
        String cadena;
        
        try{
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            
            while((cadena = b.readLine()) != null){
                String[] temp = cadena.split("");
                ArrayList<String> cosas = new ArrayList(); //[key,value]
                String a = "";
                for (int i = 0; i<temp.length;i++){
                    if ((!temp[i].equals(" ") || !(temp[i].equals(",")) || !(temp[i].equals(";")))){
                        a+=temp[i];
                    }
                    else if(temp[i].equals(" ") && !a.equals("")){
                        cosas.add(a);
                        a="";
                    }
                }
            }
        }catch(Exception E){
            
        }
    }
}
