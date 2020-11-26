
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hiego
 */

public class ConexaoBancoDados {
    
   public Statement stm;  // realiza pesquisa no BD
   public ResultSet rs;  // Armazena o resultado da pesquisa
   private String driver = "org.postgresql.Driver"; // Identifica o serviço de BD / padao do postgre
   private String caminho = "jdbc:postgresql://localhost:5432/postgres" ; // qual caminho do BD onde esta alocado
   private String usuario = "postgres"; // Usuario padrao
   private String senha = "dev12";   // Senha do BD
   Connection conex; // variavel responsavel por fazer a conexao com Banco
    
   // metodo para realizar conexao com Banco de Dados
   public void Conexao(){
       System.setProperty("jdbc.Drivers", driver); //Responsavel por setar a propriedade do drive de conexao
       try { // caaso consiga fazer a conexao com BD exibe mensagem na tela
           conex=DriverManager.getConnection(caminho, usuario, senha);
       } catch (SQLException ex) {
           Logger.getLogger(ConexaoBancoDados.class.getName()).log(Level.SEVERE, null, ex.getErrorCode());
           JOptionPane.showMessageDialog(null, "Erro ao se conectar no Banco De Dados: \n " + ex.getErrorCode() );// ex a menssagem de erro que o banco informa
 
       }
   }
   
   
   /////////// metodo para utilizar o botao pesquisa//////////////
   public ResultSet ExecutaPesquisa(String sql){
       // TYPE_SCROLL_INSENSITIVE DIFERENCIA PESQUISA DE MAIUCULO PARA
//CONCUR_READ_ONLY faz com que a lista do primeiro registo ate o ultimo do banco 
       try {
           stm = conex.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
           return stm.executeQuery(sql);
           
       } catch (SQLException ex) {
           Logger.getLogger(ConexaoBancoDados.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Erro ao Executar Pesquisa no Banco: \n " + ex.getErrorCode() );
       }
       return null;
   }   
   
   

   
   // metodo para fazer a desconexao com Banco de Dados
   public void Desconecta(){
       try {
           conex.close();
       } catch (SQLException ex) {
           Logger.getLogger(ConexaoBancoDados.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            JOptionPane.showMessageDialog(null, " Erro ao fechar a conexao com Banco de Dados \n " + ex.getMessage());
       }
   }
 
   // lembra de com bodao direito do mouse clicar em biblioteca e adicionar "DRIVER JDBC DO POSTGRESQL"
}
