/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModUniversidades;
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
public class Universidade {
    
    
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ModUniversidades mod = new ModUniversidades();
    
    
    
    public void Salvar(ModUniversidades mod){
        
        conecta.Conexao();
        try {
            PreparedStatement pst;
            pst = conecta.conex.prepareStatement("insert into universidades (nomeunv,cursounv,enderecounv,cnpjunv) values(?,?,?,?)");
            
            pst.setString(1, mod.getNomeunv()       );
            pst.setString(2, mod.getCursounv()      );
            pst.setString(3, mod.getEnderecounv()   );
            pst.setString(4, mod.getCnpjunv()       );
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Usuario inserido com sucesso!!" );
        } catch (Exception ex) {
            
           Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados!!" + ex.getMessage());
            
            
        }
        
    }
   
    
    /// faz a busca no banco pelo nome do enfermeiro 
    public ModUniversidades BuscaEnf(ModUniversidades md1){
        conecta.Conexao();
        String sql = "select * from universidades where nomeunv ilike '%"+md1.getPesquisa()+"%'";
        //String sql = "select * from funcionario";
        
        ResultSet rs = conecta.ExecutaPesquisa(sql);
        

        try {
            while(rs.next()){
            md1.setCodigounv(rs.getInt("codigounv"));
            md1.setNomeunv(rs.getString("nomeunv"));
            md1.setCursounv("cursounv");
            md1.setEnderecounv("enderecounv");
            md1.setCnpjunv("cnpjunv");
            }             
        } catch (SQLException ex) {
            Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "??????????????" + ex.getMessage());
        }

        conecta.Desconecta();
        return md1;
    }

     public void Editar (ModUniversidades edp){
        conecta.Conexao();
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("update universidades set nomeunv=?,cursounv=?,enderecounv=?,cnpjunv=?  where codigounv=?");
             pst.setString(1, edp.getNomeunv());
             pst.setString(2, edp.getCursounv());
             pst.setString(3, edp.getEnderecounv());
             pst.setString(4, edp.getCnpjunv());
             pst.setInt(5, edp.getCodigounv());
             pst.execute();
             JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");       
                    
  
             } catch (SQLException ex) {
            Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Alterar Dados \n " + ex.getMessage());
        }

        
        conecta.Desconecta();
    }
    
    
    
    
        
        public void Excluir(ModUniversidades mdp){
            
            conecta.Conexao();
            
        try {
            PreparedStatement pst = conecta.conex.prepareStatement("delete from universidades where codigounv=?");
            
             pst.setInt(1, mdp.getCodigounv());
             pst.execute();
            
             JOptionPane.showMessageDialog(null, "Dados Excluido com sucesso");       
                    
        } catch (SQLException ex) {
            Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados" + ex.getMessage());     
        }
            
   
            conecta.Desconecta();
            
        }
    

    
    
    
    
    
}
