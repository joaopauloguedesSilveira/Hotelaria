/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.funcionario;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo
 */
public class FuncionarioControl {
    
    public String inserirFuncionario(funcionario fun){
        String retorno = "";
        Conexao c = new Conexao();
        c.conectar();
        String sql = "insert into funcionario (id, cargo, cpf, nome, salario) values (?,?,?,?,?)";
        try {
            PreparedStatement sentenca = c.conexao.prepareStatement(sql);
            sentenca.setInt(1, fun.getId());
            sentenca.setString(2, fun.getCargo());
            sentenca.setString(3, fun.getCpf());
            sentenca.setString(4, fun.getNome());
            sentenca.setFloat(5, fun.getSalario());
            if(!sentenca.execute())
                retorno = "Dados Inseridos com sucesso";
            else retorno = "Inserção não efetuada";
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        c.desconectar();
        return retorno;
        
    }
    
    public funcionario selecionarFuncionario(funcionario fun){
        funcionario retorno = new funcionario();
        Conexao con = new Conexao();
        String sql = "Select * from funcionario where id = ?";

         try{
              PreparedStatement sentenca = con.conexao.prepareStatement(sql);
              sentenca.setInt(1, fun.getId());
              ResultSet rs = sentenca.executeQuery();
              if(rs.next()){
                  retorno = new funcionario();
                  //retorno.setCodClinte(rs.getInt());
                  retorno.setId(rs.getInt("id"));
                  retorno.setCargo(rs.getString("cargo"));
                  retorno.setCpf(rs.getString("cpf"));
                  retorno.setNome(rs.getString("nome"));
                  retorno.setSalario(rs.getFloat("salario"));
              }
          }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
          } 
         
         con.desconectar();
         return retorno;    
     }
    
    public String alterarFuncionario(funcionario fun){
        String retorno = "";
        Conexao c = new Conexao();
        c.conectar();
        String sql = "update cliente set cargo=?, cpf=?, nome=?, salario=? where id =? ";
        
        try {
            PreparedStatement sentenca = c.conexao.prepareStatement(sql);
            sentenca.setString(1, fun.getCargo());
            sentenca.setString(2, fun.getCpf());
            sentenca.setString(3, fun.getNome());
            sentenca.setFloat(4, fun.getSalario());
            sentenca.setInt(4, fun.getId());
            if(!sentenca.execute())
                retorno = "Dados alterados com sucesso";
            else retorno = "alteração não efetuada";
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro na sentença SQL: "+ ex.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public String deletarCliente(funcionario fun) {
        String retorno = "";
        Conexao c = new Conexao();
        c.conectar();
        String sql = "delete from funcionario where id=?";
        try {
            PreparedStatement sentenca = c.conexao.prepareStatement(sql);
            sentenca.setInt(1, fun.getId());
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
