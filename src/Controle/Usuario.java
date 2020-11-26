/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

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
public class Usuario {
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ModUsuario mod = new ModUsuario();
    
    
    
    public void Salvar(ModUsuario mod){
        
        conecta.Conexao();
        try {
            PreparedStatement pst;
            pst = conecta.conex.prepareStatement("insert into usuario (nome,cargo,senha) values(?,?,?)");
            
            pst.setString(1, mod.getNome()  );
            pst.setString(2, mod.getCargo() );
            pst.setString(3, mod.getSenha() );
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Usuario inserido com sucesso!!" );
        } catch (Exception ex) {
            
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados!!" + ex.getMessage());
            
            
        }
        
    }
   
    
    /// faz a busca no banco pelo nome do enfermeiro 
    public ModUsuario BuscaEnf(ModUsuario md1){
        conecta.Conexao();
        String sql = "select * from usuario where nome ilike '%"+md1.getPesquisa()+"%'";
        //String sql = "select * from funcionario";
        
        ResultSet rs = conecta.ExecutaPesquisa(sql);
        

        try {
            while(rs.next()){
            md1.setCodigouser(rs.getInt("codigouser"));
            md1.setNome(rs.getString("nome"));
            md1.setSenha("senha");
            md1.setCargo(rs.getString("cargo"));
            }             
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "??????????????" + ex.getMessage());
        }

        conecta.Desconecta();
        return md1;
    }

     public void Editar (ModUsuario edp){
        conecta.Conexao();
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("update usuario set nome=?,cargo=?,senha=?  where codigouser=?");
             pst.setString(1, edp.getNome());
             pst.setString(2, edp.getCargo());
             pst.setString(3, edp.getSenha());
             pst.setInt(4, edp.getCodigouser());
             pst.execute();
             JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");       
                    
  
             } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Alterar Dados \n " + ex.getMessage());
        }

        
        conecta.Desconecta();
    }
    
    
    
    
        
        public void Excluir(ModUsuario mdp){
            
            conecta.Conexao();
            
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("delete from usuario where Codigouser=?");
            
             pst.setInt(1, mdp.getCodigouser());
             pst.execute();
            
             JOptionPane.showMessageDialog(null, "Dados Excluido com sucesso");       
                    
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados" + ex.getMessage());     
        }
            
   
            conecta.Desconecta();
            
        }
    
    //////////////////VERIFICA se FUNCIONARIO esta cadastrado no Banco /////////
    public boolean CheckLogin(String login,String senha){
            conecta.Conexao();
            PreparedStatement pst = null;
            ResultSet rs=null;       
            boolean check = false;
        
        try {
            pst = conecta.conex.prepareStatement("select *  from usuario where nome=? and senha=?");
            
            pst.setString(1, login);
            pst.setString(2, senha);
            
            rs = pst.executeQuery();
            
            
            if(rs.next()){
                check = true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        conecta.Desconecta();
        
        return check;
            
    
    
    
}
    
    
}
