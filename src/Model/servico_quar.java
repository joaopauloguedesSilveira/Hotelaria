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
public class servico_quar {
    private int id_serv;
    private String tipo_serv;
    private float preco_serv;

    public servico_quar() {
    }

    public servico_quar(int id_serv, String tipo_serv, float preco_serv) {
        this.id_serv = id_serv;
        this.tipo_serv = tipo_serv;
        this.preco_serv = preco_serv;
    }

    public int getId_serv() {
        return id_serv;
    }

    public void setId_serv(int id_serv) {
        this.id_serv = id_serv;
    }

    public String getTipo_serv() {
        return tipo_serv;
    }

    public void setTipo_serv(String tipo_serv) {
        this.tipo_serv = tipo_serv;
    }

    public float getPreco_serv() {
        return preco_serv;
    }

    public void setPreco_serv(float preco_serv) {
        this.preco_serv = preco_serv;
    }
    
}
