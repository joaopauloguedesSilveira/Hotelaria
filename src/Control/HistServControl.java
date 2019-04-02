/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.cliente;
import Model.hist_serv;
import Model.servico_quar;
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
public class HistServControl {
    
    public String cadastrarFuncio( hist_serv hs){
        String retorno = "";
        Conexao con = new Conexao();
        String sql = "insert into hist_serv values(?,?,?,?)";
         try {
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            sentenca.setInt(1, hs.getId());
            sentenca.setObject(2, hs.getRea_serv());
            sentenca.setObject(3, hs.getId_cli());
            sentenca.setInt(4, hs.getRea_serv());
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
    
     public ArrayList<hist_serv>selecionaPCliente(hist_serv serv){
         
        ArrayList<hist_serv> lista = new ArrayList<>();
        Conexao con = new Conexao();
        String sql = "select * from hist_serv where id_cli=?";
        try{
            
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            sentenca.setObject(1, serv.getId_cli());
            ResultSet rs = sentenca.executeQuery();
            while(rs.next()){//aqui é um nó onde anda no final da lista ate achar null
                hist_serv retorno = new hist_serv();
               // retorno.getCodClinte(rs.getInt("codigo"));
                
                retorno.setId(rs.getInt("id"));
                retorno.setServico_quar(rs.getObject("id_ser", servico_quar.class));
                retorno.setId_cli(rs.getObject("id_cli", cliente.class));
                retorno.setRea_serv(rs.getInt("rea_serv"));
               
                lista.add(retorno);
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro na sentença "+ ex.getMessage());
        } 
        con.desconectar();
        return lista;
     }
     
     public ArrayList<hist_serv>selecionaPServ(hist_serv serv){
         
        ArrayList<hist_serv> lista = new ArrayList<>();
        Conexao con = new Conexao();
        String sql = "select * from hist_serv where rea_serv=?";
        try{
            
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            sentenca.setObject(1, serv.getRea_serv());
            ResultSet rs = sentenca.executeQuery();
            while(rs.next()){//aqui é um nó onde anda no final da lista ate achar null
                hist_serv retorno = new hist_serv();
               // retorno.getCodClinte(rs.getInt("codigo"));
                
                retorno.setId(rs.getInt("id"));
                retorno.setServico_quar(rs.getObject("id_ser", servico_quar.class));
                retorno.setId_cli(rs.getObject("id_cli", cliente.class));
                retorno.setRea_serv(rs.getInt("rea_serv"));
               
                lista.add(retorno);
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro na sentença "+ ex.getMessage());
        } 
        con.desconectar();
        return lista;
     }
}
