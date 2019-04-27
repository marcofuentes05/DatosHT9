/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fuent
 */
public interface BST <Key extends Comparable<Key>, Value> {
    public void put(Key k, Value v);
    public int size();
    public boolean contains(Key key);
    public Value get(Key key);
}
