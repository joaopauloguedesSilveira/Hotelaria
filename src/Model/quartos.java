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
public class quartos {
    private int id_quart;
    private int vazio_quart;
    private String tipo_quart;
    private cliente id_cli;

    public quartos() {
    }

    public quartos(int id_quart, int vazio_quart, String tipo_quart, cliente id_cli) {
        this.id_quart = id_quart;
        this.vazio_quart = vazio_quart;
        this.tipo_quart = tipo_quart;
        this.id_cli = id_cli;
    }

    public int getId_quart() {
        return id_quart;
    }

    public void setId_quart(int id_quart) {
        this.id_quart = id_quart;
    }

    public int getVazio_quart() {
        return vazio_quart;
    }

    public void setVazio_quart(int vazio_quart) {
        this.vazio_quart = vazio_quart;
    }

    public String getTipo_quart() {
        return tipo_quart;
    }

    public void setTipo_quart(String tipo_quart) {
        this.tipo_quart = tipo_quart;
    }

    public cliente getId_cli() {
        return id_cli;
    }

    public void setId_cli(cliente id_cli) {
        this.id_cli = id_cli;
    }
    
}
