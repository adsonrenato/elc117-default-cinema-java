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
    
    public void openSessoes () {
        CriaSessoesView viewS = new CriaSessoesView(model);
        viewS.setVisible(true);
        viewI.setVisible(false);
    }
   
    public void updateFilme() {
        /*int i, j;
        viewI.getComboFilme().removeAllItems();
        viewI.getComboFilme().setEnabled(true);
        String str = (String) viewI.getComboData().getSelectedItem();
        for (i = 0; i < model.size(); i++) {
            if (str.equals(model.get(i).getData())) {
                (viewI.getComboFilme()).addItem(model.get(i).getFilme());
            }
        }
        for (i = 0; i < model.size(); i++) {
            for (j = i+1; j < model.size(); j++) {   
                if (model.get(i).getFilme().equals(model.get(j).getFilme()))
                    (viewI.getComboFilme()).removeItem(model.get(j).getFilme());
            }
        }*/
    }
    public void updateData() {
        int i, j;
        String strs = (String) (viewI.getComboSala()).getSelectedItem();
        for (i = 0; i < model.get(i).size(); i++) {
            for (j = i+1; j < model.size(); j++) {   
                if (model.get(i).getSala() == (model.get(j).getSala()))
                    (viewI.getComboSala()).removeItem(model.get(j).getSala());
            }
        }
    }
    public void updateHorario() {
        /*int i, j;
        viewI.getComboHorario().removeAllItems();
        viewI.getComboHorario().setEnabled(true);
        String strd = (String) viewI.getComboData().getSelectedItem();
        String strf = (String) viewI.getComboFilme().getSelectedItem();
        int sala;
        if (viewI.getComboSala().getSelectedItem() != null) sala = (int) viewI.getComboSala().getSelectedItem();
        else return;
        for (i = 0; i < model.size(); i++) {
            if (strd.equals(model.get(i).getData()) && strf.equals(model.get(i).getFilme()) && sala == model.get(i).getSala()) {
                (viewI.getComboHorario()).addItem(model.get(i).getHorario());
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