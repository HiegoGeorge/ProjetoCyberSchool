/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModAluno;
import Modelo.ModEscolas;
import Modelo.ModUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hiego
 */
public class Escolas {
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ModEscolas  mod = new ModEscolas();
    
    
    ///////// metodo para salvar no banco de dados ///////////////
     public void Salvar(ModEscolas mod){
        //fazer conexao com o banco para poder salvar 
        
        conecta.Conexao();
        //////////////// DENTRO DO TRY CATH ELE INSERE OS DADOS E TESTA SE FOI INSERIDO////////////////////////////////
        try {
            PreparedStatement pst;

            pst = conecta.conex.prepareStatement("insert into escolas (nomeesc,enderecoesc,cnpjesc) values(?,?,?)");
            
            // Envia informações para o Banco
            pst.setString(1, mod.getNomeesc()              );
            pst.setString(2, mod.getEnderecoesc()          );
            pst.setString(3, mod.getCnpjesc()              );
 
             

            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            
        } catch (SQLException ex) {
           // Logger.getLogger(ControleEnfermeiro.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO ao inserir dados !!" + ex.getMessage());
        }
        
        
        conecta.Desconecta();
     }
    
     
       public void Editar (ModEscolas edp){
        conecta.Conexao();
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("update escolas set nomeesc=?,enderecoesc=?,cnpjesc=?  where codigoesc=?");
            pst.setString(1, edp.getNomeesc()              );
            pst.setString(2, edp.getEnderecoesc()          );
            pst.setString(3, edp.getCnpjesc()              );
            pst.setInt(4, edp.getCodigoesc()               );

            pst.execute();
             JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");       
                    
  
             } catch (SQLException ex) {
            Logger.getLogger(Escolas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Alterar Dados \n " + ex.getMessage());
        }

        
        conecta.Desconecta();
    }

       
       
       public void Excluir(ModEscolas mdp){
            
            conecta.Conexao();
            
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("delete from escolas where codigoesc=?");
            
             pst.setInt(1, mdp.getCodigoesc());
             pst.execute();
            
             JOptionPane.showMessageDialog(null, "Dados Excluido com sucesso");       
                    
        } catch (SQLException ex) {
            Logger.getLogger(Escolas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados" + ex.getMessage());     
        }
            
   
            conecta.Desconecta();
            
        }
     
     
     
     
     
      public ModEscolas BuscaEnf(ModEscolas md1){
        conecta.Conexao();
        String sql = "select * from escolas where nomeesc ilike '%"+md1.getPesquisa()+"%'";
        //String sql = "select * from funcionario";
        
        ResultSet rs = conecta.ExecutaPesquisa(sql);
        

        try {
            while(rs.next()){
            md1.setCodigoesc(rs.getInt("codigoesc"));
            md1.setNomeesc(rs.getString("nomeesc"));
            md1.setEnderecoesc(rs.getString("enderecoesc"));
            md1.setCnpjesc(rs.getString("cnpjesc"));
            }             
        } catch (SQLException ex) {
            Logger.getLogger(Escolas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "??????????????" + ex.getMessage());
        }

        conecta.Desconecta();
        return md1;
    }
     
     
     
     
     
    
}
