/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.view;

import br.senai.controller.AlunoController;
import br.senai.model.Aluno;
import br.senai.model.Aula;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno_andrade
 */
public class ConsultaAlunoUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form PesquisarAluno
     */
    AlunoController contAluno;
    private ArrayList<Aluno> listaAluno;
    private boolean controleAluno;

    public ConsultaAlunoUI(boolean controle) {
        initComponents();
        rbPesquisaNome.setSelected(true);
        checkAtivo.setSelected(true);
        this.controleAluno = controle;
        if (this.controleAluno) {
            btnAlterarAluno.setText("Selecionar");
            btnNovoAluno.setVisible(false);
        }
        atualizarTabelaAluno();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroupPesquisa = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnNovoAluno = new javax.swing.JButton();
        btnAlterarAluno = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuscaAlunos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        rbPesquisaNome = new javax.swing.JRadioButton();
        rbPesquisaCPF = new javax.swing.JRadioButton();
        txtPesquisaAlunos = new javax.swing.JTextField();
        btnBuscarAlunos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        checkAtivo = new javax.swing.JCheckBox();
        btnLimparAlunos = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pesquisa de Alunos");

        btnNovoAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnNovoAluno.setText("Novo");
        btnNovoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAlunoActionPerformed(evt);
            }
        });

        btnAlterarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gtk_edit.png"))); // NOI18N
        btnAlterarAluno.setText("Alterar");
        btnAlterarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarAlunoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(478, 261));

        tableBuscaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Data Nasc.", "Sexo", "Status"
            }
        ));
        jScrollPane1.setViewportView(tableBuscaAlunos);

        jLabel2.setText("Pesquisar:");

        rbGroupPesquisa.add(rbPesquisaNome);
        rbPesquisaNome.setText("Nome");

        rbGroupPesquisa.add(rbPesquisaCPF);
        rbPesquisaCPF.setText("CPF");

        btnBuscarAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        btnBuscarAlunos.setText("Buscar");
        btnBuscarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlunosActionPerformed(evt);
            }
        });

        jLabel5.setText("Somente Ativos: ");

        btnLimparAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit-clear.png"))); // NOI18N
        btnLimparAlunos.setText("Limpar");
        btnLimparAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAlunosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPesquisaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbPesquisaNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbPesquisaCPF)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkAtivo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnBuscarAlunos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimparAlunos)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkAtivo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbPesquisaNome)
                        .addComponent(rbPesquisaCPF)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAlunos)
                    .addComponent(btnLimparAlunos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovoAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterarAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoAluno)
                    .addComponent(btnAlterarAluno)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAlunoActionPerformed
        try {
            contAluno = new AlunoController();
            CadastroAlunoUI cadasAluno = new CadastroAlunoUI(null, null);
            this.hide();
            cadasAluno.show();
            FormPrincipal.getPainelPrincipal().add(cadasAluno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "bla");
        }

    }//GEN-LAST:event_btnNovoAlunoActionPerformed

    private void btnAlterarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarAlunoActionPerformed
        int linhaSelecionada = tableBuscaAlunos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Aluno");
        } else {
            Aluno aluno = new Aluno();
            try {
                for (int i = 0; i < listaAluno.size(); i++) {
                    if (tableBuscaAlunos.getSelectedRow() == i) {
                        aluno = this.listaAluno.get(i);
                        break;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            ArrayList<Aula> listaAulas = AlunoController.obterInstancia().listarTodasAulasPorAluno(aluno.getId());
            CadastroAlunoUI cadastroAluno = new CadastroAlunoUI(aluno, listaAulas);
            cadastroAluno.show();
            this.hide();
            FormPrincipal.getPainelPrincipal().add(cadastroAluno);
            tableBuscaAlunos.getSelectedRow();
            atualizarTabelaAluno();
        }
    }//GEN-LAST:event_btnAlterarAlunoActionPerformed

    private void btnBuscarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlunosActionPerformed
        contAluno = new AlunoController();
        String coluna = "";
        Integer status = 0;
        if (rbPesquisaCPF.isSelected()) {
            coluna = "dsc_CPF";
        } else if (rbPesquisaNome.isSelected()) {
            coluna = "dsc_Nome";
        }
        if (checkAtivo.isSelected()) {
            status = 1;
        } else {
            status = 0;
        }
        atualizarTabelaAluno(contAluno.getAlunoPesquisa(coluna.toString(), txtPesquisaAlunos.getText().toString(), status));
    }//GEN-LAST:event_btnBuscarAlunosActionPerformed

    private void btnLimparAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAlunosActionPerformed
       rbPesquisaNome.setSelected(true);
       checkAtivo.setSelected(true);
       txtPesquisaAlunos.setText("");
       atualizarTabelaAluno();
    }//GEN-LAST:event_btnLimparAlunosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void atualizarTabelaAluno() {
        DefaultTableModel modelo = new DefaultTableModel();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        modelo.setColumnIdentifiers(new String[]{"Nome", "CPF", "Data Nasc.", "Sexo", "Status"});
        this.listaAluno = AlunoController.obterInstancia().listarTodos();
        for (int i = 0; i < this.listaAluno.size(); i++) {
            String sexo = "";
            String status = "";
            if (this.listaAluno.get(i).getSexo() == 0) {
                sexo = "Masculino";
            } else {
                sexo = "Feminino";
            }
            if (this.listaAluno.get(i).getStatus() == 1) {
                status = "Ativo";
            } else {
                status = "Inativo";
            }
            modelo.addRow(new Object[]{this.listaAluno.get(i).getDscNome(),
                this.listaAluno.get(i).getDscCPF(),
                formatador.format(this.listaAluno.get(i).getDtDataNasc()),
                sexo,
                status});
        }
        tableBuscaAlunos.setModel(modelo);
    }

    private void atualizarTabelaAluno(ArrayList<Aluno> alunoPesquisa) {
        DefaultTableModel modelo = new DefaultTableModel();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        modelo.setColumnIdentifiers(new String[]{"Nome", "CPF", "Data Nasc.", "Sexo", "Status"});
        for (int i = 0; i < alunoPesquisa.size(); i++) {
            String sexo = "";
            String status = "";
            if (alunoPesquisa.get(i).getSexo() == 0) {
                sexo = "Masculino";
            } else {
                sexo = "Feminino";
            }
            if (alunoPesquisa.get(i).getStatus() == 1) {
                status = "Ativo";
            } else {
                status = "Inativo";
            }
            modelo.addRow(new Object[]{alunoPesquisa.get(i).getDscNome(),
                alunoPesquisa.get(i).getDscCPF(),
                formatador.format(alunoPesquisa.get(i).getDtDataNasc()),
                sexo,
                status});
        }
        tableBuscaAlunos.setModel(modelo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarAluno;
    private javax.swing.JButton btnBuscarAlunos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimparAlunos;
    private javax.swing.JButton btnNovoAluno;
    private javax.swing.JCheckBox checkAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup rbGroupPesquisa;
    private javax.swing.JRadioButton rbPesquisaCPF;
    private javax.swing.JRadioButton rbPesquisaNome;
    private javax.swing.JTable tableBuscaAlunos;
    private javax.swing.JTextField txtPesquisaAlunos;
    // End of variables declaration//GEN-END:variables

}
