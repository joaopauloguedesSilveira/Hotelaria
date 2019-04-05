/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.cliente;
import Model.veiculo;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo
 * private int id;
    private String Clinome;
    private String CliCpf;
    private veiculo id_vei;
 */
public class ClienteControl {
    
    public String inserirCliente(cliente cli){
        String retorno = "";
        Conexao c = new Conexao();
        
        String sql = "insert into cliente (id, Clinome, Clicpf) values (?,?,?,?)";
        try {
            PreparedStatement sentenca = c.conexao.prepareStatement(sql);
            sentenca.setInt(1, cli.getId());
            sentenca.setString(2, cli.getClinome());
            sentenca.setString(3, cli.getCliCpf());
            sentenca.setInt(4, cli.getId_vei());
            if(!sentenca.execute())
                retorno = "Dados Inseridos com sucesso";
            else retorno = "Inserção não efetuada";
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        c.desconectar();
        return retorno;
        
    }
    
    public cliente selecionarCliente(cliente Cliente){
        cliente retorno = new cliente();
        Conexao con = new Conexao();
        String sql = "Select * from cliente where id = ?";

         try{
              PreparedStatement sentenca = con.conexao.prepareStatement(sql);
              sentenca.setInt(1, Cliente.getId());
              ResultSet rs = sentenca.executeQuery();
              if(rs.next()){
                  retorno = new cliente();
                  //retorno.setCodClinte(rs.getInt());
                  retorno.setId(rs.getInt("id"));
                  retorno.setCliCpf(rs.getString("Clicpf"));
                  retorno.setClinome(rs.getString("Clinome"));
                  retorno.setId_vei(rs.getInt("id_vei"));
                  
              }
          }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
          } 

         con.desconectar();
         return retorno;    
     }
    
    public String alterarCliente(cliente cli){
        String retorno = "";
        Conexao c = new Conexao();
        
        String sql = "update cliente set Clinome=?, Clicpf=?, id_vei=? where id =? ";
        
        try {
            PreparedStatement sentenca = c.conexao.prepareStatement(sql);
            sentenca.setString(1, cli.getClinome());
            sentenca.setString(2, cli.getCliCpf());
            sentenca.setInt(3, cli.getId_vei());
            sentenca.setInt(4, cli.getId());
            if(!sentenca.execute())
                retorno = "Dados alterados com sucesso";
            else retorno = "alteração não efetuada";
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public String deletarCliente(cliente cli) {
        String retorno = "";
        Conexao c = new Conexao();
        String sql = "delete from cliente where id=?";
        try {
            PreparedStatement sentenca = c.conexao.prepareStatement(sql);
            sentenca.setInt(1, cli.getId());
            if(!sentenca.execute())
                retorno = "Dados deletados com sucesso";
            else retorno = "Exclusão não efetuada";
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
}
