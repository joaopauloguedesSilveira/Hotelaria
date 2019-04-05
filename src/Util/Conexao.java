package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cris
 */
public class Conexao {

    public Connection conexao;

    public Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotelaria?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "Emerald2291";
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException erro) {
            System.out.println("Erro na conexao com Banco de Dados" + erro.getMessage());
        } catch (ClassNotFoundException erro) {
            System.out.println("Driver não encontrado!");
        }
    }

    public void desconectar() {
        try {
            conexao.close();
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
