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
public class cliente {
    private int id;
    private String Clinome;
    private String CliCpf;
    private veiculo id_vei;
    
    public cliente(){
        
    }

    public cliente(int id, String Clinome, String CliCpf, veiculo id_vei) {
        this.id = id;
        this.Clinome = Clinome;
        this.CliCpf = CliCpf;
        this.id_vei = id_vei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClinome() {
        return Clinome;
    }

    public void setClinome(String Clinome) {
        this.Clinome = Clinome;
    }

    public String getCliCpf() {
        return CliCpf;
    }

    public void setCliCpf(String CliCpf) {
        this.CliCpf = CliCpf;
    }

    public veiculo getId_vei() {
        return id_vei;
    }

    public void setId_vei(veiculo id_vei) {
        this.id_vei = id_vei;
    }
    
}
