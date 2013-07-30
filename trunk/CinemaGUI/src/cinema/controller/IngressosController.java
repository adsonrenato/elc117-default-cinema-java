/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.controller;

import cinema.model.Cinema;
import cinema.model.Sessao;
import cinema.view.CriaSessoesView;
import cinema.view.VendaIngressosView;

/**
 *
 * @author Felipe
 */
public class IngressosController {
    private VendaIngressosView viewI;
    private Cinema model;
    
    public IngressosController(VendaIngressosView view, Cinema model) {
        this.viewI = view;
        this.model = model;
        viewI.getComboData().setEnabled(false);
        viewI.getButtonRelatorio().setEnabled(false);
        viewI.getButtonVenda().setEnabled(false);
        viewI.getTextVendidos().setEnabled(false);
        viewI.getComboData().setEnabled(false);
        viewI.getComboFilme().setEnabled(false);
        viewI.getComboSala().setEnabled(false);
        viewI.getComboHorario().setEnabled(false);
    }
    
    public void updateFrame() {
        int i, j; 
        viewI.getComboSala().setEnabled(true);
        for (i = 0; i < model.size(); i++) {
               (viewI.getComboSala()).addItem(model.get(i).getSalaID());
        }
    }
    
    public boolean iguaisData(int i, int j) {
        String str1 = ((String)(viewI.getComboData().getItemAt(i)));
        String str2 = ((String)(viewI.getComboData().getItemAt(j)));
        if (str1 == null || str2 == null) return false;
        boolean iguais = (str1).equals(str2);
        return iguais;
    }
    
    public void openSessoes () {
        CriaSessoesView viewS = new CriaSessoesView(model);
        viewS.setVisible(true);
        viewI.setVisible(false);
    }
   
    public void updateFilme() {
        /*int i, j;
        viewI.getComboFilme().setEnabled(true);
        String str1 = (String)viewI.getComboData().getSelectedItem();
        int s = (int) ((viewI.getComboSala()).getSelectedItem());
        for (i = 0; i < model.size(); i++) {
            for (j = 0; j < model.get(i).size(); j++) {
                if (str1.equals(model.get(i).get(j).getData())) viewI.getComboFilme().addItem(model.get(i).get(j).getFilme());
            }
        }*/
    }
    public void updateData() {
        int i, j;
        viewI.getComboData().setEnabled(true);
        viewI.getComboData().removeAllItems();
        int salaID = (int)viewI.getComboSala().getSelectedItem();
        for (i = 0; i < model.size(); i++) {
            if (salaID == model.get(i).getSalaID()) break;
        }
        for (j = 0; j < model.get(i).size(); j++) {
            viewI.getComboData().addItem(model.get(i).get(j).getData());
        }
        int tam = viewI.getComboData().getItemCount();
        for (i = 0; i < tam; i++) {
            for (j = i+1; j < tam; j++) {
                if (iguaisData(i, j)) {
                    viewI.getComboData().removeItemAt(j);
                    tam = viewI.getComboData().getItemCount();
                    i = 0;
                    j = i+1;
                }
            }
        }
    }
    
    public void updateHorario() {
       /* int i, j;
        viewI.getComboHorario().setEnabled(true);
        String str1 = (String)viewI.getComboData().getSelectedItem();
        String str2 = (String)viewI.getComboFilme().getSelectedItem();
        int s = (int) ((viewI.getComboSala()).getSelectedItem());
        for (i = 0; i < model.size(); i++) {
            for (j = 0; j < model.get(i).size(); j++) {
                if ((str2).equals(model.get(i).get(j).getFilme())) {
                    if ((str1).equals(model.get(i).get(j).getData())) {
                        viewI.getComboHorario().addItem(model.get(i).get(j).getHorario());
                    }
                }
            }
        }*/
    }
 
    private Sessao newFromViewI() {
        try {
            Sessao s = new Sessao();
            s.setFilme((String) viewI.getComboFilme().getSelectedItem());
            s.setHorario((String) (viewI.getComboHorario().getSelectedItem()));
            s.setData((String) viewI.getComboData().getSelectedItem());
            s.setVendidos(Integer.parseInt((String)viewI.getComboData().getSelectedItem()));
            return s;
        } catch (NumberFormatException e) {
            viewI.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
    }


}