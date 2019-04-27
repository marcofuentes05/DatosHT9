
import Clases.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String traducir = "texto.txt";
        String cadena;
        String oracion;
        try{
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            
            while((cadena = b.readLine()) != null){
                //System.out.println(cadena);
                cadena = cadena.toLowerCase();
                String[] temp = cadena.split("");
                ArrayList<String> cosas = new ArrayList(); //[key,value]
                String a = "";
                for (int i = 0; i<temp.length;i++){
                    if ((!temp[i].equals(" ") && !(temp[i].equals("\t")) && !(temp[i].equals(",")) && !(temp[i].equals(";")))){
                        a+=temp[i];
                    }
                    if((temp[i].equals("\t") || temp[i].equals(" ")) && !a.equals("")){
                        cosas.add(a);
                        a="";
                        //System.out.println("hola");
                    }
                    if(i == temp.length-1){
                        cosas.add(a);
                    }
                    //System.out.println(cosas.size());
                }
                arbol.put(cosas.get(0),cosas.get(1));
            }
            System.out.println("Tamanno es: "+arbol.size());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            FileReader fr = new FileReader(traducir);
            BufferedReader br = new BufferedReader(fr);
            
            while((oracion = br.readLine()) != null){
                String traduccion = ""; 
                oracion = oracion.toLowerCase();
                String [] palabras = oracion.split(" ");
                for(int i =0;i<palabras.length;i++){
                    String palabra = palabras[i];
                    if(arbol.contains(palabra)){
                        
                        traduccion += arbol.get(palabra);
                    }else{
                        traduccion += "*"+palabra+"*";
                    }
                    traduccion += " ";
                }
                System.out.println(traduccion);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
