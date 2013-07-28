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
    
    public boolean iguaisData(int i, int j) {
        String str1 = ((String)(viewI.getComboData().getItemAt(i)));
        String str2 = ((String)(viewI.getComboData().getItemAt(j)));
        if (str1 == null || str2 == null) return false;
        boolean iguais = (str1).equals(str2);
        return iguais;
    }
    
    public boolean iguaisFilme(int i, int j) {
        String str1 = ((String)(viewI.getComboFilme().getItemAt(i)));
        String str2 = ((String)(viewI.getComboFilme().getItemAt(j)));
        if (str1 == null || str2 == null) return false;
        boolean iguais = (str1).equals(str2);
        return iguais;
    }
    
    public boolean iguaisSala(int i, int j) {
        int a = ((Integer)(viewI.getComboSala().getItemAt(i)));
        int b = ((Integer)(viewI.getComboSala().getItemAt(j)));
        if (a == 0 || b == 0) return false;
        return a == b;
    }
    
    public boolean iguaisHorario(int i, int j) {
        String str1 = ((String)(viewI.getComboHorario().getItemAt(i)));
        String str2 = ((String)(viewI.getComboHorario().getItemAt(j)));
        if (str1 == null || str2 == null) return false;
        boolean iguais = (str1).equals(str2);
        return iguais;
    }
    
    public void updateFrame() {
        int i, j; 
        viewI.getComboData().setEnabled(true);
        viewI.getComboData().removeAllItems();
        viewI.getComboFilme().removeAllItems();
        viewI.getComboSala().removeAllItems();
        viewI.getComboHorario().removeAllItems();
        for (i = 0; i < model.size(); i++) {
            (viewI.getComboData()).addItem(model.get(i).getData());
            //(viewI.getComboFilme()).addItem(model.get(i).getFilme());
            (viewI.getComboSala()).addItem(model.get(i).getSala());
            (viewI.getComboHorario()).addItem(model.get(i).getHorario());
        }
        for (i = 0; i < viewI.getComboData().getItemCount(); i++) {
            for (j = 0; j < viewI.getComboData().getItemCount(); j++) {
                if (iguaisData(i, j) && i != j)  (viewI.getComboData()).removeItemAt(j);
                //if (iguaisFilme(i, j) && i != j)  (viewI.getComboFilme()).removeItemAt(j);
                if (iguaisSala(i, j) && i != j)  (viewI.getComboSala()).removeItemAt(j);
                if (iguaisHorario(i, j) && i != j)  (viewI.getComboHorario()).removeItemAt(j);
            }
        }
    }
    
    public void openSessoes () {
        CriaSessoesView viewS = new CriaSessoesView(model);
        viewS.setVisible(true);
        viewS.updateFrame();
        viewI.setVisible(false);
    }
   
    public void updateFilme() {
        int i, j;
        viewI.getComboFilme().removeAllItems();
        String str = (String) viewI.getComboData().getSelectedItem();
        for (i = 0; i < model.size(); i++) {
            if (str.equals(model.get(i).getData())) {
                (viewI.getComboFilme()).addItem(model.get(i).getFilme());
            }
        }
        for (i = 0; i < viewI.getComboData().getItemCount(); i++) {
            for (j = 0; j < viewI.getComboData().getItemCount(); j++) {
                if (iguaisFilme(i, j) && i != j)  {
                    (viewI.getComboFilme()).removeItemAt(j);
                }
            }
        }
        viewI.getComboFilme().setEnabled(true);
    }
  /*  
    public void updateSala() {
        int i = 0, j;
        String sd = (String)(viewI.getComboData().getSelectedItem());
        String sf = (String)(viewI.getComboFilme().getSelectedItem());
        while (model.size() > i) {
            if ((model.get(i).getData()).equals(sd) && (model.get(i).getFilme()).equals(sf)) {
                for (j=0; j <= model.size(); j++) {
                        if ((viewI.getComboSala()).getItemAt(j)!= null && !(model.get(i).getSala() == ((Integer)(viewI.getComboSala()).getItemAt(j)))) {
                            viewI.getComboSala().addItem(model.get(i).getSala());
                            break;
                        }
                        if ((viewI.getComboSala()).getItemAt(0)== null) {
                            (viewI.getComboSala()).addItem(model.get(i).getSala());
                        }
                }
            }
            i++;
        }
        viewI.getComboSala().setEnabled(true);
    }
    public void updateHorario() {
        int i = 0, j;
        String sd = (String)(viewI.getComboData().getSelectedItem());
        String sf = (String)(viewI.getComboFilme().getSelectedItem());
        int ss = (Integer)(viewI.getComboSala().getSelectedItem());
        while (model.size() > i) {
            if (model.get(i).getSala() == ss && (model.get(i).getData()).equals(sd) && (model.get(i).getFilme()).equals(sf)) {
                for (j=0; j <= model.size(); j++) {
                        if ((viewI.getComboHorario()).getItemAt(j)!= null && !(model.get(i).getHorario().equals((String)(viewI.getComboHorario()).getItemAt(j)))) {
                            viewI.getComboHorario().addItem(model.get(i).getHorario());
                            break;
                        }
                        if ((viewI.getComboHorario()).getItemAt(0)== null) {
                            (viewI.getComboHorario()).addItem(model.get(i).getHorario());
                        }
                }
            }
            i++;
        }
        viewI.getComboHorario().setEnabled(true);
    }*/
    
}
