/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author joaop
 */
public class hist_serv {
    private int id;
    private servico_quar servico_quar;
    private cliente id_cli;
    private int rea_serv;

    public hist_serv() {
    }

    public hist_serv(int id, servico_quar servico_quar, cliente id_cli, int rea_serv) {
        this.id = id;
        this.servico_quar = servico_quar;
        this.id_cli = id_cli;
        this.rea_serv = rea_serv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public servico_quar getServico_quar() {
        return servico_quar;
    }

    public void setServico_quar(servico_quar servico_quar) {
        this.servico_quar = servico_quar;
    }

    public cliente getId_cli() {
        return id_cli;
    }

    public void setId_cli(cliente id_cli) {
        this.id_cli = id_cli;
    }

    public int getRea_serv() {
        return rea_serv;
    }

    public void setRea_serv(int rea_serv) {
        this.rea_serv = rea_serv;
    }
    
    
}
