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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo
 */
public class VeiculoControl {
    
    public String cadastrarVeiculo( veiculo vei){
        String retorno = "";
        Conexao con = new Conexao();
        String sql = "insert into veiculo values(?,?,?,?,?)";
         try {
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            sentenca.setInt(1,vei.getId_vei());
            sentenca.setString(2, vei.getPlaca_vei());
            sentenca.setString(3, vei.getModelo_vei());
            sentenca.setString(4, vei.getAno_vei());
            sentenca.setObject(5, vei.getId_cli());
            if(sentenca.execute())
            retorno = "Dados inseridos com sucesso!";
            else
            retorno = "Erro na inserção!";
        
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        con.desconectar();
        return retorno;
    }
    
     public String editarVeiculo( veiculo vei){
        String retorno = "";
        Conexao con = new Conexao ();
        String sql = "update Funcionario set placa_vei=? , modelo_vei=?, ano_vei, id_cli=? where id_vei =? ";
        
       try {
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            
            sentenca.setString(1, vei.getPlaca_vei());
            sentenca.setString(2, vei.getModelo_vei());
            sentenca.setString(3, vei.getAno_vei());
            sentenca.setObject(4, vei.getId_cli());
            if(sentenca.execute())
            retorno = "Dados editados com sucesso!";
            else
            retorno = "Erro na inserção!";
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        con.desconectar();
        return retorno;
     }
     
      public String deletarVei( veiculo vei){
        String retorno = "";
        Conexao con = new Conexao ();
        String sql = "delete from veiculo where id_vei=? ";
       
        try{
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            sentenca.setInt(1, vei.getId_vei());
        
            if(!    sentenca.execute())
                retorno = "Erro na sentença de DELETE!";
            else
            retorno = "Dados excluidos com sucesso!";
        
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        } 
       
       con.desconectar();
       return retorno;   
     }
      
      public veiculo selecionarFuncio(veiculo vei){
         veiculo retorno = new veiculo();
        Conexao con = new Conexao();
        String sql = "Select * from veiculo where id_vei = ?";//qdo faz select BD manda dados par aplicaçao, ai precisa usar executeQuery

         try{//é tratamento de excessao no sql
              PreparedStatement sentenca = con.conexao.prepareStatement(sql);
              sentenca.setInt(1, vei.getId_vei());
              ResultSet rs = sentenca.executeQuery();
              if(rs.next()){//aqui é um nó onde anda no final da lista ate achar null
                  retorno = new veiculo();
                  retorno.setAno_vei(rs.getString("ano_vei"));
                  retorno.setModelo_vei(rs.getString("modelo_vei"));
                  retorno.setPlaca_vei(rs.getString("placa_vei"));
                  retorno.setId_cli(rs.getObject("id_cli", cliente.class));

              }
          }catch(SQLException ex){
              JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
          } 

         con.desconectar();
         return retorno;    
     }
      
       public ArrayList<veiculo>selecionaTodosCarrosCli(){
         
        ArrayList<veiculo> lista = new ArrayList<>();
        Conexao con = new Conexao();
        String sql = "select * from veiculos where id_vei=?";
        try{
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while(rs.next()){//aqui é um nó onde anda no final da lista ate achar null
                veiculo retorno = new veiculo();
                retorno.setId_vei(rs.getInt("id_vei"));
                retorno.setAno_vei(rs.getString("ano_vei"));
                retorno.setModelo_vei(rs.getString("modelo_vei"));
                retorno.setModelo_vei(rs.getString("modelo_vei"));
                retorno.setId_cli(rs.getObject("id_cli", cliente.class));
                

                lista.add(retorno);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro na sentença "+ ex.getMessage());
        } 
        con.desconectar();
        return lista;
     }
}
