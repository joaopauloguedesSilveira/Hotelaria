/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.login;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo
 * 
    private int id;
    private String login;
    private String senha;
    private String tipo_usu;

 */
public class LoginControl {
    
    public String CadastraLogin( login log){
        String retorno = "";
        Conexao con = new Conexao();
        String sql = "insert into login (id,login,senha) values(?,?,?)";
         try {
            PreparedStatement sentenca = con.conexao.prepareStatement(sql);
            sentenca.setInt(1, log.getId());
            sentenca.setString(2, log.getLogin());
            sentenca.setString(3, log.getSenha());
            
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
    
    public login AutenticaLogin(login l){
        login retorno = new login();
        Conexao con = new Conexao();
        String sql = "Select * from login where login=?";

         try{
              PreparedStatement sentenca = con.conexao.prepareStatement(sql);
              sentenca.setString(1, l.getLogin());
              ResultSet rs = sentenca.executeQuery();
              if(rs.next()){
                  retorno = new login();
                  //retorno.setCodClinte(rs.getInt());
                  retorno.setId(rs.getInt("id"));
                  retorno.setLogin(rs.getString("login"));
                  retorno.setSenha(rs.getString("senha"));
              }
          }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
          } 
         
         con.desconectar();
         return retorno;    
     }
}
