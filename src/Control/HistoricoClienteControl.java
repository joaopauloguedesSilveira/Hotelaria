/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.historico_cliente;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo
 */
public class HistoricoClienteControl {
    
    public String CadastrarHistCliente( historico_cliente hc){
        String retorno = "";
        Conexao con = new Conexao();
        String sql = "insert into historico_cliente values(?,?,?,?,?,?)";
         try {
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            sentenca.setInt(1, hc.getId_hist());
            sentenca.setObject(2, hc.getId_cli());
            sentenca.setObject(3, hc.getId_quarto());
            sentenca.setString(4, hc.getDia_cheg());
            sentenca.setString(5, hc.getDia_part());
            sentenca.setFloat(6, hc.getTotal_diaria());
            if(!sentenca.execute())
            retorno = "Erro na inserção!";
            else
            retorno = "Dados inseridos com sucesso!";
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        con.desconectar();
        return retorno;
    }
    
    public String alterarHistCliente( historico_cliente hc){
        String retorno = "";
        Conexao con = new Conexao();
        String sql = "update historico_cliente id_cli=?,id_quarto=?,dia_cheg=?,dia_part=?,total_diaria=? where id_hist=?";
         try {
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            
            sentenca.setObject(1, hc.getId_cli());
            sentenca.setObject(2, hc.getId_quarto());
            sentenca.setString(3, hc.getDia_cheg());
            sentenca.setString(4, hc.getDia_part());
            sentenca.setFloat(5, hc.getTotal_diaria());
            sentenca.setInt(6, hc.getId_hist());
            
            if(!sentenca.execute())
            retorno = "Erro na alteração!";
            else
            retorno = "Dados inseridos com sucesso!";
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        con.desconectar();
        return retorno;
    }
    
    public String deletarHistCliente( historico_cliente hc){
        String retorno = "";
        Conexao con = new Conexao();
        String sql = "delete from historico_cliente where id_hist=?";
         try {
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            
            sentenca.setInt(1, hc.getId_hist());
            
            if(!sentenca.execute())
            retorno = "Erro na Exclusão!";
            else
            retorno = "Dados inseridos com sucesso!";
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        con.desconectar();
        return retorno;
    }
    
}
