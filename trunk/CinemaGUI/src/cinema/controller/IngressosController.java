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
        int i = 0;
        Sessao aux;
        viewI.getComboData().setEnabled(true);
        String str = (String) viewI.getComboData().getSelectedItem();
        while (model.size() > i) {
            (viewI.getComboData()).addItem(model.get(i).getData());
            i++;
        }
        updateSala();
        //updateFilme();
    }
    
    public void openSessoes () {
        CriaSessoesView viewS = new CriaSessoesView(model);
        viewS.setVisible(true);
        viewS.updateFrame();
        viewI.setVisible(false);
    }
    
    public void updateSala() {
        int i = 0;
        String s = (String)(viewI.getComboData().getSelectedItem());
        while (model.size() > i) {
            if ((model.get(i).getData()).equals(s)) viewI.getComboSala().addItem(model.get(i).getData());
            i++;
        }
        viewI.getComboSala().setEnabled(true);
    }
}
