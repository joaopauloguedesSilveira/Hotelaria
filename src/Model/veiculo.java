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
public class veiculo {
    private int id_vei;
    private String placa_vei;
    private String modelo_vei;
    private String ano_vei;
    private cliente id_cli;

    public veiculo() {
    }

    public veiculo(int id_vei, String placa_vei, String modelo_vei,String ano_vei, cliente id_cli) {
        this.id_vei = id_vei;
        this.placa_vei = placa_vei;
        this.modelo_vei = modelo_vei;
        this.ano_vei = ano_vei;
        this.id_cli = id_cli;
    }

    public int getId_vei() {
        return id_vei;
    }

    public void setId_vei(int id_vei) {
        this.id_vei = id_vei;
    }

    public String getPlaca_vei() {
        return placa_vei;
    }

    public void setPlaca_vei(String placa_vei) {
        this.placa_vei = placa_vei;
    }

    public String getModelo_vei() {
        return modelo_vei;
    }

    public void setModelo_vei(String modelo_vei) {
        this.modelo_vei = modelo_vei;
    }

    public cliente getId_cli() {
        return id_cli;
    }

    public String getAno_vei() {
        return ano_vei;
    }

    public void setAno_vei(String ano_vei) {
        this.ano_vei = ano_vei;
    }
    

    public void setId_cli(cliente id_cli) {
        this.id_cli = id_cli;
    }
    
}
