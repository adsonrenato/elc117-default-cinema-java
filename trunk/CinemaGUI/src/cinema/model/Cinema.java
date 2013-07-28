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
public class Cinema extends Sessao{
    
    private ArrayList<Sessao> cinema = new ArrayList<>();
    
    public void setCinema(ArrayList<Sessao> list) {
        this.cinema = list;
    }
    
    public ArrayList<Sessao> getCinema() {
        return this.cinema;
    }
    
    public void add(Sessao s) {
        cinema.add(s);
    }
    
    public int size() {
        return cinema.size();
    }
    
    public Sessao get(int index) {
        return cinema.get(index);
    }
}
