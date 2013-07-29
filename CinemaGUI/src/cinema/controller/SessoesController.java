/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.controller;

import cinema.model.Cinema;
import cinema.model.Sala;
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
    
    
    public void criarSessao() {
        Sessao s = newFromViewS();
        if (s == null) return;
        int id, i;
        id = (Integer.parseInt(viewS.getTextSala().getText()));
        for (i = 0; i < model.size(); i++) {
                if (model.get(i).getSalaID() == id) {
                    /*if (!checaHorario()) {
                        viewS.showError("Essa sala não estará disponível no horário escolhido!");
                        return;
                    }*/
                    model.get(i).add(s);
                    break;
                    }
                }
        if (i == model.size()) {
            Sala sala = new Sala();
            int capacidade = Integer.parseInt(viewS.getTextCapacidade().getText());
            sala.setSalaID(id);
            sala.setCapacidade(capacidade);
            /*if (!checaHorario()) {
                viewS.showError("Essa sala não estará disponível no horário escolhido!");
                return;
            }*/
            model.add(sala);
        }
        //updateFrame();
    }
    
    
    /*public void updateFrame() {
        int i, j;
        String str;
        for (i = 0; i < viewS.getComboFilme().getItemCount(); i++) {
            for (j = 0; j < model.size(); j++) {
                str = (String)(viewS.getComboFilme().getItemAt(i));
                if ((str == null) || !((model.get(j).getFilme()).equals(str))) {
                    (viewS.getComboFilme()).addItem(model.get(i).getFilme());
                }
            }
        }
    }*/
    
    /*public boolean checaHorario() {
        if (model.size() > 0) { 
            String horarioDesejado, dataDesejada;
            int salaDesejadaID;
            Sessao desejada = newFromViewS();
            horarioDesejado = desejada.getHorario();
            dataDesejada = desejada.getData();
            int hAnt, minAnt, hDes, minDes, i;
            hDes = Integer.parseInt((horarioDesejado.split("h"))[0]);
            minDes = Integer.parseInt((((horarioDesejado.split("h"))[1]).split("min"))[0]);
            int hDurDes = desejada.getDuracao()/60;
            int minDurDes = desejada.getDuracao()%60;
            Sessao s;
            for (i=0; i < (model.size()); i++) {
                s = model.get(i);
                if (s.getSala() == salaDesejada && (s.getData()).equals(dataDesejada)) {
                    int h = s.getDuracao()/60;
                    int min = s.getDuracao()%60;
                    String horarioAnterior = s.getHorario();
                    hAnt = Integer.parseInt((horarioAnterior.split("h"))[0]);
                    minAnt = Integer.parseInt((((horarioAnterior.split("h"))[1]).split("min"))[0]);
                    h += hAnt;
                    min += minAnt;
                    while (min >= 60)
                    {
                        h++;
                        min -= 60;
                    }
                    if (hAnt == hDes && minAnt <= minDes) return false;
                    if (hAnt < hDes && h > hDes) return false;
                    if (h == hDes && min > minDes) return false;
                    hDurDes += hDes;
                    minDurDes += minDes;
                    while (minDurDes >= 60)
                    {
                        hDurDes++;
                        minDurDes -= 60;
                    }
                    if (hAnt > hDes && hDurDes > hAnt) return false;
                    if (hAnt >= hDes && hDurDes == hAnt && minDurDes > minAnt) return false;
                    
                }
            }
        }
        return true;
    }*/
    
    public void openIngressos () {
        VendaIngressosView viewI = new VendaIngressosView(model);
        viewI.updateFrame();
        viewI.setVisible(true);
        viewS.setVisible(false);
    }
    
    private Sessao newFromViewS() {
        try {
            Sessao s = new Sessao();
            s.setFilme(viewS.getTextFilme().getText());
            s.setHorario((String)(viewS.getComboHorario().getSelectedItem()));
            s.setDuracao(Integer.parseInt(viewS.getTextDuracao().getText()));
            s.setData(viewS.getTextDia().getText(), viewS.getTextMes().getText());
            int i, id = (Integer.parseInt(viewS.getTextSala().getText()));
            for (i = 0; i < model.size(); i++) {
                if (model.get(i).getSalaID() == id) {
                    break;
                    }
                }
            if (i == model.size()) {
                int capacidade = Integer.parseInt(viewS.getTextCapacidade().getText());
                }
            return s;
            } catch (NumberFormatException e) {
                viewS.showError("Dado(s) de entrada invalido(s)!");
                return null;
            }
    }
}
