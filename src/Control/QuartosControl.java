/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.cliente;
import Model.quartos;
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
public class QuartosControl {
    
    public String inserirQuarto(quartos cli){
        String retorno = "";
        Conexao c = new Conexao();
        
        String sql = "insert into quartos (id_quart, vazio_quart, tipo_quart, id_cli) values (?,?,?,?)";
        try {
            PreparedStatement sentenca = c.conexao.prepareStatement(sql);
            sentenca.setInt(1, cli.getId_quart());
            sentenca.setInt(2, cli.getVazio_quart());
            sentenca.setString(3, cli.getTipo_quart());
            sentenca.setObject(4, cli.getId_cli());
            if(!sentenca.execute())
                retorno = "Dados Inseridos com sucesso";
            else retorno = "Inserção não efetuada";
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public quartos selecionarQuarto(quartos quar){
        quartos retorno = new quartos();
        Conexao con = new Conexao();
        String sql = "Select * from quartos where id_quart = ?";

         try{
              PreparedStatement sentenca = con.conexao.prepareStatement(sql);
              sentenca.setInt(1, quar.getId_quart());
              ResultSet rs = sentenca.executeQuery();
              if(rs.next()){
                  //retorno.setCodClinte(rs.getInt());
                  retorno.setId_quart(rs.getInt("id_quart"));
                  retorno.setVazio_quart(rs.getInt("vazio_quart"));
                  retorno.setTipo_quart(rs.getString("Clinome"));
                  retorno.setId_cli((cliente) rs.getObject("id_cli"));
                  
              }
          }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
          } 

         con.desconectar();
         return retorno;    
     }
    
    public ArrayList<quartos> selecionarQuartoDisp(quartos quar){
        quartos retorno = new quartos();
        ArrayList<quartos> lista = new ArrayList<>();
        Conexao con = new Conexao();
        String sql = "Select * from quartos where vazio_quart = ?";

         try{
              PreparedStatement sentenca = con.conexao.prepareStatement(sql);
              sentenca.setInt(1, quar.getVazio_quart());
              ResultSet rs = sentenca.executeQuery();
              while(rs.next()){
                  retorno.setId_quart(rs.getInt("id_quart"));
                  retorno.setVazio_quart(rs.getInt("vazio_quart"));
                  retorno.setTipo_quart(rs.getString("Clinome"));
                  retorno.setId_cli((cliente) rs.getObject("id_cli"));
                  lista.add(retorno);
                  
              }
          }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
          } 

         con.desconectar();
         return lista;    
     }
}
