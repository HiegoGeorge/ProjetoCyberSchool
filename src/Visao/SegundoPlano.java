/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

/**
 *
 * @author Hiêgo
 */
public class SegundoPlano extends javax.swing.JFrame {

    /**
     * Creates new form PesquisarPaciente
     */
    public SegundoPlano() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fudotelaPesq = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        menuCadAluno = new javax.swing.JMenuItem();
        menuCadUsuarios = new javax.swing.JMenuItem();
        menuCadEscola = new javax.swing.JMenuItem();
        menuCadUniversidades = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        fudotelaPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teladois.jpeg"))); // NOI18N
        getContentPane().add(fudotelaPesq);
        fudotelaPesq.setBounds(0, 0, 670, 430);

        MenuCadastro.setText("Cadastros ");

        menuCadAluno.setText("Cadastrar Alunos");
        menuCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadAlunoActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuCadAluno);

        menuCadUsuarios.setText("Cadastro de Usuarios");
        menuCadUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadUsuariosActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuCadUsuarios);

        menuCadEscola.setText("Cadastro Escola");
        menuCadEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadEscolaActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuCadEscola);

        menuCadUniversidades.setText("Cadastro Universidade");
        MenuCadastro.add(menuCadUniversidades);

        jMenuBar2.add(MenuCadastro);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(686, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadAlunoActionPerformed
        CadastroAlunosAll cadaln = new CadastroAlunosAll();
        cadaln.setVisible(true);
        
        
        
    }//GEN-LAST:event_menuCadAlunoActionPerformed

    private void menuCadUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadUsuariosActionPerformed
        
        CadastroUsuario cadusario = new CadastroUsuario();
        cadusario.setVisible(true);

                
    }//GEN-LAST:event_menuCadUsuariosActionPerformed

    private void menuCadEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadEscolaActionPerformed
       
        CadastroEscola cadescola = new CadastroEscola();
        cadescola.setVisible(true);



    }//GEN-LAST:event_menuCadEscolaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SegundoPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SegundoPlano().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JLabel fudotelaPesq;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem menuCadAluno;
    private javax.swing.JMenuItem menuCadEscola;
    private javax.swing.JMenuItem menuCadUniversidades;
    private javax.swing.JMenuItem menuCadUsuarios;
    // End of variables declaration//GEN-END:variables
}