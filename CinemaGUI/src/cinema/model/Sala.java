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
public class Sala extends Sessao {
    
    private ArrayList<Sessao> sala = new ArrayList<>();
    private int id;
    private int capacidade;
    
    public void setSala(ArrayList<Sessao> list) {
        this.sala = list;
    }
    
    public ArrayList<Sessao> getSala() {
        return this.sala;
    }
    
    public void add(Sessao s) {
        sala.add(s);
    }
    
    public int size() {
        return sala.size();
    }
    
    public Sessao get(int index) {
        return sala.get(index);
    }
    
    public void remove(Sessao s) {
        sala.remove(s);
    }
    
     public void setSalaID (int sala) {
        this.id = sala;
    }
    
    public int getSalaID () {
        return this.id;
    }
    
    
    public void setCapacidade (int capacidade) {
        this.capacidade = capacidade;
    }
    
    public int getCapacidade () {
        return capacidade;
    }
}
