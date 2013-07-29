/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.model;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Cinema extends Sala{
    
    private ArrayList<Sala> cinema = new ArrayList<>();
    
    public void setCinema(ArrayList<Sala> list) {
        this.cinema = list;
    }
    
    public ArrayList<Sala> getCinema() {
        return this.cinema;
    }
    
    public void add(Sala s) {
        cinema.add(s);
    }
    
    public int size() {
        return cinema.size();
    }
    
    public Sala get(int index) {
        return cinema.get(index);
    }
    
    public void remove(Sala s) {
        cinema.remove(s);
    }
}
