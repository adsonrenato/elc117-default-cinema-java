/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.model;

/**
 *
 * @author Felipe
 */
public class Sessao {
    
    private String filme;
    private String horario;
    private String data;
    private int sala;
    private int capacidade;
    private int duracao;
    private int vendidos;
    private boolean esgotada;

    public Sessao() {
        this.filme = "";
        this.horario = "14h30min";
        this.data = "";
        this.capacidade = 40;
        this.vendidos = 0;
        this.esgotada = false;
    }
    
    public void setFilme (String filme) {
        this.filme = filme;
    }
    
    public String getFilme () {
        return this.filme;
    }
    
    public void setHorario (String horario) {
        this.horario = horario;
    }
    
    public String getHorario () {
        return this.horario;
    }
    
    public void setData (String dia, String mes) {
        this.data = (dia + "/" + mes);
    }
    
    public String getData () {
        return this.data;
    }
    
    public void setSala (int sala) {
        this.sala = sala;
    }
    
    public int getSala () {
        return this.sala;
    }
    
    public void setCapacidade (int capacidade) {
        this.capacidade = capacidade;
    }
    
    public void setDuracao (int duracao) {
        this.duracao = duracao;
    }
    
    public int getDuracao () {
        return duracao;
    }
    
}
