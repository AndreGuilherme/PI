package br.senai.view;

import br.senai.controller.ProfessorController;
import br.senai.model.Professor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaProfessorUI extends javax.swing.JInternalFrame {

    boolean controleProfessor;

    public ConsultaProfessorUI(boolean controle) {
        initComponents();
        rbNome.setSelected(true);
        checkAtivo.setSelected(true);
        this.controleProfessor = controle;
        if (this.controleProfessor) {
            btnAlterar.setText("Selecionar");
            btnNovo.setVisible(false);
        }
        atualizarTabelaProfessor();
    }
    ProfessorController profController;
    private ArrayList<Professor> listaProf;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProfessor = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        checkAtivo = new javax.swing.JCheckBox();
        txtBuscaProfessor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rbNome = new javax.swing.JRadioButton();
        rbCPf = new javax.swing.JRadioButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pesquisa de Professor");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(478, 261));

        tableProfessor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableProfessor);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit-clear.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Somente Ativos: ");

        jLabel2.setText("Pesquisar:");

        buttonGroup1.add(rbNome);
        rbNome.setText("Nome");

        buttonGroup1.add(rbCPf);
        rbCPf.setText("CPF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbCPf)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkAtivo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimpar)))))
                        .addGap(0, 162, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkAtivo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNome)
                        .addComponent(rbCPf)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gtk_edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        profController = new ProfessorController();
        String coluna = "";
        Integer status = 0;
        if (rbCPf.isSelected()) {
            coluna = "dsc_CPF";
        } else if (rbNome.isSelected()) {
            coluna = "dsc_Nome";
        }
        if (checkAtivo.isSelected()) {
            status = 1;
        } else {
            status = 0;
        }
        atualizarTabelaProfessor(profController.getProfPesquisa(coluna.toString(), txtBuscaProfessor.getText().toString(), status));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhaSelecionada = tableProfessor.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um professor");
        } else {
            Professor prof = new Professor();
            try {
                for (int i = 0; i < listaProf.size(); i++) {
                    if (tableProfessor.getSelectedRow() == i) {
                        prof = this.listaProf.get(i);
                        break;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            if (this.controleProfessor) {
                ProfessorController.obterInstancia().preencheFormAula(prof);
                this.dispose();
            } else {
                CadastraProfessorUI cadastroProfessorUI = new CadastraProfessorUI(prof);
                cadastroProfessorUI.setVisible(true);
                FormPrincipal.getPainelPrincipal().add(cadastroProfessorUI);
                this.dispose();
                //Função de alteração do professor        
            }
            tableProfessor.getSelectedRow();
            atualizarTabelaProfessor();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        try {
            profController = new ProfessorController();
            CadastraProfessorUI cadProf = new CadastraProfessorUI(null);
            this.hide();
            cadProf.show();
            FormPrincipal.getPainelPrincipal().add(cadProf);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tente novamente!");
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
        atualizarTabelaProfessor();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void atualizarTabelaProfessor(ArrayList<Professor> profPesquisa) {
        DefaultTableModel modelo = new DefaultTableModel();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        modelo.setColumnIdentifiers(new String[]{"Nome", "CPF", "Data Nasc.", "Sexo", "Status"});
        for (int i = 0; i < profPesquisa.size(); i++) {
            String sexo = "";
            String status = "";
            if (profPesquisa.get(i).getSexo() == 0) {
                sexo = "Masculino";
            } else {
                sexo = "Feminino";
            }
            if (profPesquisa.get(i).getStatus() == 0) {
                status = "Inativo";
            } else {
                status = "Ativo";
            }

            modelo.addRow(new Object[]{profPesquisa.get(i).getDscNome(),
                profPesquisa.get(i).getDscCPF(),
                formatador.format(profPesquisa.get(i).getDtDataNasc()),
                sexo,
                status});
        }
        tableProfessor.setModel(modelo);
    }

    private void atualizarTabelaProfessor() {
        DefaultTableModel modelo = new DefaultTableModel();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        modelo.setColumnIdentifiers(new String[]{"Nome", "CPF", "Data Nasc.", "Sexo", "Status"});
        this.listaProf = ProfessorController.obterInstancia().listarTodos();
        for (int i = 0; i < this.listaProf.size(); i++) {
            String sexo = "";
            String status = "";
            if (this.listaProf.get(i).getSexo() == 0) {
                sexo = "Masculino";
            } else {
                sexo = "Feminino";
            }
            if (this.listaProf.get(i).getStatus() == 0) {
                status = "Inativo";
            } else {
                status = "Ativo";
            }

            modelo.addRow(new Object[]{this.listaProf.get(i).getDscNome(),
                this.listaProf.get(i).getDscCPF(),
                formatador.format(this.listaProf.get(i).getDtDataNasc()),
                sexo,
                status});
        }
        tableProfessor.setModel(modelo);
    }

    private void limparTela() {
        txtBuscaProfessor.setText("");
        rbNome.setSelected(true);
        checkAtivo.setSelected(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCPf;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JTable tableProfessor;
    private javax.swing.JTextField txtBuscaProfessor;
    // End of variables declaration//GEN-END:variables
}
