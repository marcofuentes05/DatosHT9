package Clases;

/**
 * @author Marco Fuentes
 */
public class Factory {
    BST arbol;
    public Factory(int i){
        if (i==1){
            //SPLAY
            arbol = new SplayBST();
        }else{
            arbol = new RedBlackBST();
        }
    }
    
    public BST getArbol(){
        return arbol;
    }
}
