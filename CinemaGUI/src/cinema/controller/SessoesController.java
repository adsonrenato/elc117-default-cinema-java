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
public class SessoesController {
    
    private CriaSessoesView viewS;
    private Cinema model;
    
    public SessoesController(CriaSessoesView viewS, Cinema model) {
        this.viewS = viewS;
        this.model = model;
    }
    
    public Cinema criarSessao() {
        Sessao s = newFromViewS(); 
        if (!checaHorario()) {
            viewS.showError("Essa sala não estará disponível no horário escolhido!");
            return model;
        }
        if (s != null) model.add(s);
        updateFrame();
        return model;
    }
    
    public void updateFrame() {
        int i = 0;
        while (model.size() > i) {
            (viewS.getComboFilme()).addItem(model.get(i).getFilme());
            i++;
        }
    }
    
    public boolean checaHorario() {
        if (model.size() > 0) { 
            String horarioDesejado, dataDesejada;
            int salaDesejada;
            Sessao desejada = newFromViewS();
            horarioDesejado = desejada.getHorario();
            salaDesejada = desejada.getSala();
            dataDesejada = desejada.getData();
            int hAnt, minAnt, hDes, minDes, i;
            hDes = Integer.parseInt((horarioDesejado.split("h"))[0]);
            minDes = Integer.parseInt((((horarioDesejado.split("h"))[1]).split("min"))[0]);
            for (i=0; i < (model.size()); i++) {
                Sessao s = model.get(i);
                if (s.getSala() == salaDesejada && (s.getData()).equals(dataDesejada)) {
                    int h = s.getDuracao()/60;
                    int min = s.getDuracao()%60;
                    String horarioAnterior = s.getHorario();
                    hAnt = Integer.parseInt((horarioAnterior.split("h"))[0]);
                    minAnt = Integer.parseInt((((horarioAnterior.split("h"))[1]).split("min"))[0]);
                    System.out.printf("%d: %d, %d, %d, %d\n", s.getSala(), h, min, hAnt, minAnt);
                    h += hAnt;
                    min += minAnt;
                    while (min >= 60)
                    {
                        h++;
                        min -= 60;
                    }
                    System.out.printf("%d: %d, %d, %d, %d\n", salaDesejada, h, min, hDes, minDes);
                    if (hAnt <= hDes && hDes <= h) {
                       if (h == hDes && min == minDes) return true;
                       if (hAnt <= hDes && minDes <= minAnt) return false;
                       if (h >= hDes && min < minDes) return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void openIngressos () {
        VendaIngressosView viewI = new VendaIngressosView(model);
        viewI.updateFrame();
        viewI.setVisible(true);
        viewS.setVisible(false);
    }
    
    private Sessao newFromViewS() {
        try {
            Sessao s = new Sessao();
            s.setFilme((String)(viewS.getComboFilme().getSelectedItem()));
            s.setHorario((String)(viewS.getComboHorario().getSelectedItem()));
            s.setSala(Integer.parseInt(viewS.getTextSala().getText()));
            s.setData(viewS.getTextDia().getText(), viewS.getTextMes().getText());
            s.setDuracao(Integer.parseInt(viewS.getTextDuracao().getText()));
            return s;
        } catch (NumberFormatException e) {
            viewS.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
    }
}
