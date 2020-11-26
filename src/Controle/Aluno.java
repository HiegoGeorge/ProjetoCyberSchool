/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModAluno;
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
public class Aluno {
    
    
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ModAluno mod = new ModAluno();
    
    
    ///////// metodo para salvar no banco de dados ///////////////
     public void Salvar(ModAluno mod){
        //fazer conexao com o banco para poder salvar 
        
        conecta.Conexao();
        //////////////// DENTRO DO TRY CATH ELE INSERE OS DADOS E TESTA SE FOI INSERIDO////////////////////////////////
        try {
            PreparedStatement pst;

            pst = conecta.conex.prepareStatement("insert into aluno (nome,sexo,nascimento,nomepai,nomemae,endereco) values(?,?,?,?,?,?)");
            
            // Envia informações para o Banco
            pst.setString(1, mod.getNome()              );
            pst.setString(2, mod.getSexo()              );
            pst.setString(3, mod.getNascimento()        );
            pst.setString(4, mod.getNomepai()          );
            pst.setString(5, mod.getNomemae()          );
            pst.setString(6, mod.getEndereco()          );

            
             

            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            
        } catch (SQLException ex) {
           // Logger.getLogger(ControleEnfermeiro.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO ao inserir dados !!" + ex.getMessage());
        }
        
        
        conecta.Desconecta();
     }
    
    ///////// metodo para Editar dados do aluno no banco de dados ///////////////
      public void Editar (ModAluno edp){
        conecta.Conexao();
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("update aluno set nome=?,sexo=?,nascimento=?,nomepai=?,nomemae=?,endereco=? where codigo=?");
                                                                    
            pst.setString(1, edp.getNome()              );
            pst.setString(2, edp.getSexo()              );
            pst.setString(3, edp.getNascimento()    );
            pst.setString(4, edp.getNomepai()          );
            pst.setString(5, edp.getNomemae()          );
            pst.setString(6, edp.getEndereco()          );
            pst.setInt(7, edp.getCodigo()               );

            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");       
                    
  
             } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Alterar Dados \n " + ex.getMessage());
        }

        
        conecta.Desconecta();
    }
    
      
      ///////// metodo para excluir dados do aluno  ///////////////
      public void Excluir(ModAluno mdp){
            
            conecta.Conexao();
            
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("delete from aluno where codigo=?");
            
             pst.setInt(1, mdp.getCodigo());
             pst.execute();
             JOptionPane.showMessageDialog(null, "Dados Excluido com sucesso");       
                    
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados" + ex.getMessage());     
        }
            
   
            conecta.Desconecta();
            
        }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean CheckLogin(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
     
   public ModAluno BuscaAluno(ModAluno mdp){
                
        conecta.Conexao();
        
        //String sql = "select * from paciente,cartao ilike '%"+mdp.getPesquisa()+"%'";
        String sql = "select * from aluno where nome ilike '%"+mdp.getPesquisa()+"%'";
        ResultSet rs = conecta.ExecutaPesquisa(sql);
                     
        try {
           
            while(rs.next()){
                
            mdp.setCodigo(rs.getInt("codigo"));
            mdp.setNome(rs.getString("nome"));
            mdp.setNomepai(rs.getString("nomepai")); 
            mdp.setNomemae(rs.getString("nomemae"));
            mdp.setSexo(rs.getString("sexo"));
            mdp.setNascimento(rs.getString("nascimento"));
            mdp.setEndereco(rs.getString("endereco"));

            

            }
                       
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Paciente \n " + ex.getMessage());

        }
               
        conecta.Desconecta();
        return mdp;
               
    }  
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
}
