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
public class historico_cliente {
    private int id_hist;
    private cliente id_cli;
    private int id_quarto;
    private String dia_cheg;
    private String dia_part;
    private float total_diaria;

    public historico_cliente() {
    }

    public historico_cliente(int id_hist, cliente id_cli, int id_quarto, String dia_cheg, String dia_part, float total_diaria) {
        this.id_hist = id_hist;
        this.id_cli = id_cli;
        this.id_quarto = id_quarto;
        this.dia_cheg = dia_cheg;
        this.dia_part = dia_part;
        this.total_diaria = total_diaria;
    }

    public int getId_hist() {
        return id_hist;
    }

    public void setId_hist(int id_hist) {
        this.id_hist = id_hist;
    }

    public cliente getId_cli() {
        return id_cli;
    }

    public void setId_cli(cliente id_cli) {
        this.id_cli = id_cli;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public String getDia_cheg() {
        return dia_cheg;
    }

    public void setDia_cheg(String dia_cheg) {
        this.dia_cheg = dia_cheg;
    }

    public String getDia_part() {
        return dia_part;
    }

    public void setDia_part(String dia_part) {
        this.dia_part = dia_part;
    }

    public float getTotal_diaria() {
        return total_diaria;
    }

    public void setTotal_diaria(float total_diaria) {
        this.total_diaria = total_diaria;
    }
    
}
