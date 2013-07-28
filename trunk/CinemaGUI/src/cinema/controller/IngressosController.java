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
        viewI.getComboFilme().removeAllItems();
        viewI.getComboSala().removeAllItems();
        viewI.getComboHorario().removeAllItems();
        viewI.getComboData().removeAllItems();
        int i = 0;
        int j;
        viewI.getComboData().setEnabled(true);
        while (model.size() > i) {
            for (j=0; j <= model.size(); j++) {
                if ((viewI.getComboData()).getItemAt(j)!= null && !(model.get(i).getData().equals((String)(viewI.getComboData()).getItemAt(j)))) {
                    (viewI.getComboData()).addItem(model.get(i).getData());
                    j=0;
                }
                if ((viewI.getComboData()).getItemAt(0)== null) {
                    (viewI.getComboData()).addItem(model.get(i).getData());
                }
            }
            i++;
        }
        updateFilme();
        updateSala();
    }
    
    public void openSessoes () {
        CriaSessoesView viewS = new CriaSessoesView(model);
        viewS.setVisible(true);
        viewS.updateFrame();
        viewI.setVisible(false);
    }
    
        public void updateFilme() {
        int i = 0, j;
        String sd = (String)(viewI.getComboData().getSelectedItem());
        while (model.size() > i) {
            if ((model.get(i).getData()).equals(sd)) {
                for (j=0; j <= model.size(); j++) {
                    if ((viewI.getComboFilme()).getItemAt(j)!= null && !(model.get(i).getFilme().equals((String)(viewI.getComboFilme()).getItemAt(j)))) {
                        (viewI.getComboFilme()).addItem(model.get(i).getFilme());
                        j=0;
                    }
                    if ((viewI.getComboFilme()).getItemAt(0)== null) {
                        (viewI.getComboFilme()).addItem(model.get(i).getFilme());
                    }
                }
                i++;
            }
        }
        viewI.getComboFilme().setEnabled(true);
    }
    
    public void updateSala() {
        int i = 0, j;
        String sd = (String)(viewI.getComboData().getSelectedItem());
        String sf = (String)(viewI.getComboFilme().getSelectedItem());
        while (model.size() > i) {
            if ((model.get(i).getData()).equals(sd) && (model.get(i).getFilme()).equals(sf)) {
                for (j=0; j <= model.size(); j++) {
                        if ((viewI.getComboSala()).getItemAt(j)!= null && !(model.get(i).getSala() == ((Integer)(viewI.getComboSala()).getItemAt(j)))) {
                            viewI.getComboSala().addItem(model.get(i).getSala());
                            j=0;
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
}
