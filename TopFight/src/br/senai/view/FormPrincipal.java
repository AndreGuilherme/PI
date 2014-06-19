/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.view;

import br.senai.DAO.TesteDAO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author bruno_andrade
 */
public class FormPrincipal extends javax.swing.JFrame {

    private static FormPrincipal instanciaRep;

    /*SINGLETON*/
    public static FormPrincipal obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new FormPrincipal();
        }
        return instanciaRep;
    }

    public static JDesktopPane getPainelPrincipal() {
        return obterInstancia().jdpPainelPrincipal;
    }

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        jMenuItem7 = new javax.swing.JMenuItem();
        jdpPainelPrincipal = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadAluno = new javax.swing.JMenuItem();
        jMenuCadAula = new javax.swing.JMenuItem();
        jMenuCadProfessor = new javax.swing.JMenuItem();
        jMenuPesquisa = new javax.swing.JMenu();
        jMenuPesAluno = new javax.swing.JMenuItem();
        jMenuPesAula = new javax.swing.JMenuItem();
        jMenuPesProfessor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpPainelPrincipal.setBackground(new java.awt.Color(0, 102, 153));

        jButton1.setText("Inserir Aluno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Listar Alunos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdpPainelPrincipalLayout = new javax.swing.GroupLayout(jdpPainelPrincipal);
        jdpPainelPrincipal.setLayout(jdpPainelPrincipalLayout);
        jdpPainelPrincipalLayout.setHorizontalGroup(
            jdpPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpPainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdpPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(565, Short.MAX_VALUE))
        );
        jdpPainelPrincipalLayout.setVerticalGroup(
            jdpPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpPainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jdpPainelPrincipal.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPainelPrincipal.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuCadastro.setText("Cadastro");

        jMenuCadAluno.setText("Aluno");
        jMenuCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadAlunoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadAluno);

        jMenuCadAula.setText("Aula");
        jMenuCadAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadAulaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadAula);

        jMenuCadProfessor.setText("Professor");
        jMenuCadProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadProfessorActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadProfessor);

        jMenuBar1.add(jMenuCadastro);

        jMenuPesquisa.setText("Pesquisa");

        jMenuPesAluno.setText("Aluno");
        jMenuPesAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPesAlunoActionPerformed(evt);
            }
        });
        jMenuPesquisa.add(jMenuPesAluno);

        jMenuPesAula.setText("Aula");
        jMenuPesAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPesAulaActionPerformed(evt);
            }
        });
        jMenuPesquisa.add(jMenuPesAula);

        jMenuPesProfessor.setText("Professor");
        jMenuPesProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPesProfessorActionPerformed(evt);
            }
        });
        jMenuPesquisa.add(jMenuPesProfessor);

        jMenuBar1.add(jMenuPesquisa);

        jMenu3.setText("Sair");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPainelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPainelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadAlunoActionPerformed
        CadastroAlunoUI aluno = new CadastroAlunoUI(null);
        aluno.setVisible(true);
        jdpPainelPrincipal.add(aluno);
    }//GEN-LAST:event_jMenuCadAlunoActionPerformed

    private void jMenuCadAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadAulaActionPerformed
        CadastroAulaUI aula = new CadastroAulaUI();
        aula.setVisible(true);
        jdpPainelPrincipal.add(aula);
    }//GEN-LAST:event_jMenuCadAulaActionPerformed

    private void jMenuCadProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadProfessorActionPerformed
        CadastraProfessorUI prof = new CadastraProfessorUI(null);
        prof.setVisible(true);
        jdpPainelPrincipal.add(prof);
    }//GEN-LAST:event_jMenuCadProfessorActionPerformed

    private void jMenuPesAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPesAlunoActionPerformed
        ConsultaAlunoUI pesqAluno = new ConsultaAlunoUI(false);
        pesqAluno.setVisible(true);
        jdpPainelPrincipal.add(pesqAluno);
    }//GEN-LAST:event_jMenuPesAlunoActionPerformed

    private void jMenuPesAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPesAulaActionPerformed
        ConsultaAulaUI pesqAula = new ConsultaAulaUI();
        pesqAula.setVisible(true);
        jdpPainelPrincipal.add(pesqAula);
    }//GEN-LAST:event_jMenuPesAulaActionPerformed

    private void jMenuPesProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPesProfessorActionPerformed
        ConsultaProfessorUI pesqProf = new ConsultaProfessorUI(false);
        pesqProf.setVisible(true);
        jdpPainelPrincipal.add(pesqProf);
    }//GEN-LAST:event_jMenuPesProfessorActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TesteDAO teste = new TesteDAO();
        teste.ListarAlunos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TesteDAO teste = new TesteDAO();
        teste.InserirAluno();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                obterInstancia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadAluno;
    private javax.swing.JMenuItem jMenuCadAula;
    private javax.swing.JMenuItem jMenuCadProfessor;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuPesAluno;
    private javax.swing.JMenuItem jMenuPesAula;
    private javax.swing.JMenuItem jMenuPesProfessor;
    private javax.swing.JMenu jMenuPesquisa;
    private javax.swing.JDesktopPane jdpPainelPrincipal;
    // End of variables declaration//GEN-END:variables
}
