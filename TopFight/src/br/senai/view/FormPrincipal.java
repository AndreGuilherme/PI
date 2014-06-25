/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.view;

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

        jdpPainelPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadAluno = new javax.swing.JMenuItem();
        jMenuCadAula = new javax.swing.JMenuItem();
        jMenuCadProfessor = new javax.swing.JMenuItem();
        jMenuPesquisa = new javax.swing.JMenu();
        jMenuPesAluno = new javax.swing.JMenuItem();
        jMenuPesAula = new javax.swing.JMenuItem();
        jMenuPesProfessor = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jGerarRelatorios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Academia TopFight");
        setIconImages(null);

        jdpPainelPrincipal.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jdpPainelPrincipalLayout = new javax.swing.GroupLayout(jdpPainelPrincipal);
        jdpPainelPrincipal.setLayout(jdpPainelPrincipalLayout);
        jdpPainelPrincipalLayout.setHorizontalGroup(
            jdpPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );
        jdpPainelPrincipalLayout.setVerticalGroup(
            jdpPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        jMenuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        jMenuCadastro.setText("Cadastro");

        jMenuCadAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        jMenuCadAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Boxing_Gloves.png"))); // NOI18N
        jMenuCadAluno.setText("Aluno");
        jMenuCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadAlunoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadAluno);

        jMenuCadAula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        jMenuCadAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/WeightTraining_Bench.png"))); // NOI18N
        jMenuCadAula.setText("Aula");
        jMenuCadAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadAulaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadAula);

        jMenuCadProfessor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        jMenuCadProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Boss.png"))); // NOI18N
        jMenuCadProfessor.setText("Professor");
        jMenuCadProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadProfessorActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadProfessor);

        jMenuBar1.add(jMenuCadastro);

        jMenuPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jMenuPesquisa.setText("Pesquisa");

        jMenuPesAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPesAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Boxing_Gloves.png"))); // NOI18N
        jMenuPesAluno.setText("Aluno");
        jMenuPesAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPesAlunoActionPerformed(evt);
            }
        });
        jMenuPesquisa.add(jMenuPesAluno);

        jMenuPesAula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPesAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/WeightTraining_Bench.png"))); // NOI18N
        jMenuPesAula.setText("Aula");
        jMenuPesAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPesAulaActionPerformed(evt);
            }
        });
        jMenuPesquisa.add(jMenuPesAula);

        jMenuPesProfessor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPesProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Boss.png"))); // NOI18N
        jMenuPesProfessor.setText("Professor");
        jMenuPesProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPesProfessorActionPerformed(evt);
            }
        });
        jMenuPesquisa.add(jMenuPesProfessor);

        jMenuBar1.add(jMenuPesquisa);

        jMenuRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sync.png"))); // NOI18N
        jMenuRelatorios.setText("Relatórios");

        jGerarRelatorios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
        jGerarRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sync.png"))); // NOI18N
        jGerarRelatorios.setText("Relatórios");
        jGerarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGerarRelatoriosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jGerarRelatorios);

        jMenuBar1.add(jMenuRelatorios);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jMenu3.setText("Sair");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jMenuSair.setText("Sair");
        jMenu3.add(jMenuSair);

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
            .addComponent(jdpPainelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadAlunoActionPerformed
        CadastroAlunoUI aluno = new CadastroAlunoUI(null, null);
        aluno.setVisible(true);
        jdpPainelPrincipal.add(aluno);
    }//GEN-LAST:event_jMenuCadAlunoActionPerformed

    private void jMenuCadAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadAulaActionPerformed
        CadastroAulaUI aula = new CadastroAulaUI(null);
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
        ConsultaAulaUI pesqAula = new ConsultaAulaUI(false);
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

    private void jGerarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGerarRelatoriosActionPerformed
        Relatorios rel = new Relatorios();
        rel.setVisible(true);
        jdpPainelPrincipal.add(rel);
    }//GEN-LAST:event_jGerarRelatoriosActionPerformed

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
    private javax.swing.JMenuItem jGerarRelatorios;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadAluno;
    private javax.swing.JMenuItem jMenuCadAula;
    private javax.swing.JMenuItem jMenuCadProfessor;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuPesAluno;
    private javax.swing.JMenuItem jMenuPesAula;
    private javax.swing.JMenuItem jMenuPesProfessor;
    private javax.swing.JMenu jMenuPesquisa;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JDesktopPane jdpPainelPrincipal;
    // End of variables declaration//GEN-END:variables
}
