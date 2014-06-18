/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.view;

import br.senai.controller.ProfessorController;
import br.senai.model.Aluno;
import br.senai.model.Professor;
import br.senai.util.Utils;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno_andrade
 */
public class CadastraProfessorUI extends javax.swing.JInternalFrame {

    private Professor professorAlteracao;

    /**
     * Creates new form Professor
     */
    public CadastraProfessorUI(Professor professor) {
        initComponents();
        checkAtivoProfessor.setSelected(true);
        rbSexoMasc.setSelected(true);
        if (professor != null) {
            this.professorAlteracao = professor;
            preencheProfessor(professor);
        }

    }

    private void preencheProfessor(Professor professor) {
        txtNomeProfessor.setText(professor.getDscNome().toString());
        txtCPF.setText(professor.getDscCPF().toString());

        if (professor.getSexo() == 1) {
            rbSexoMasc.isSelected();
        } else {
            rbSexoFem.isSelected();
        }

        if (professor.getStatus() == 1) {
            checkAtivoProfessor.setSelected(true);
        } else {
            checkAtivoProfessor.setSelected(false);
        }

        txtEndereco.setText(professor.getDscEndereco().toString());
        txtNum.setText(professor.getNunNumero().toString());
        txtComplemento.setText(professor.getDscComplemento().toString());
        txtBairro.setText(professor.getDscBairro().toString());
        txtEmail.setText(professor.getDscEmail().toString());
        txtTelefone.setText(professor.getTelefone().toString());
        txtCEP.setText(professor.getDscCEP().toString());
        txAreaObs.setText(professor.getDscObservacao().toString());
        //txtDtNasc.setDate(professor.getDtDataNasc());
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (this.professorAlteracao != null) {
                this.professorAlteracao.setDscNome(txtNomeProfessor.getText());
                this.professorAlteracao.setDscCEP(txtCEP.getText());
                this.professorAlteracao.setDscBairro(txtBairro.getText());
                this.professorAlteracao.setDscComplemento(txtComplemento.getText());
                this.professorAlteracao.setDscEmail(txtEmail.getText());
                this.professorAlteracao.setDscEndereco(txtEndereco.getText());
                this.professorAlteracao.setDscObservacao(txAreaObs.getText());
                this.professorAlteracao.setDscCPF(txtCPF.getText());
                if (!txtNum.getText().equals("")) {
                    this.professorAlteracao.setNunNumero(Integer.parseInt(txtNum.getText()));
                }
                this.professorAlteracao.setStatus(1); //Ativo
                this.professorAlteracao.setSexo(1);
                if (rbSexoFem.isSelected()) {
                    this.professorAlteracao.setSexo(2);
                }

                //this.professorAlteracao.setDtDataNasc(txtDtNasc.getDate());

                ProfessorController.obterInstancia().alterar(this.professorAlteracao);
                JOptionPane.showMessageDialog(this, "Professor alterado com sucesso");
                this.dispose();
            } else {
                Professor professor = new Professor();
                professor.setDscNome(txtNomeProfessor.getText());
                professor.setDscCEP(txtCEP.getText());
                professor.setDscBairro(txtBairro.getText());
                professor.setDscComplemento(txtComplemento.getText());
                professor.setDscEmail(txtEmail.getText());
                professor.setDscEndereco(txtEndereco.getText());
                professor.setDscObservacao(txAreaObs.getText());
                professor.setDscCPF(txtCPF.getText());
                professor.setTelefone(txtTelefone.getText());
                if (!txtNum.getText().equals("")) {
                    professor.setNunNumero(Integer.parseInt(txtNum.getText()));
                }
                professor.setStatus(1); //Ativo
                professor.setSexo(1);
                if (rbSexoFem.isSelected()) {
                    professor.setSexo(2);
                }
                //professor.setDtDataNasc(txtDtNasc.getDate());

                ProfessorController.obterInstancia().inserir(professor);
                JOptionPane.showMessageDialog(this, "Professor cadastrado com sucesso", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                this.limpaCamposTelas();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void txtCPFAlunoFocusLost(java.awt.event.FocusEvent evt) {
        try {
            Icon i = null;
            //CPF:
            String cpf = txtCPF.getText().replace("-", "").replace(".", "").replace("_", "").toString();
            //Valida se CPF informado é Valido e verifica se realmente foi informado algum CPF.
            if (Utils.validarCPF(cpf)) {
                i = new ImageIcon("src/imagens/Check_16x16.png");
                lbValidado.setIcon(i);
                txtCPF.setBackground(Color.WHITE);

                //Entra no else caso CPF invalido.
            } else {
                i = new ImageIcon("src/imagens/Delete_16x16.png");
                lbValidado.setIcon(i);
                //   txtCPFCNPJ.setBackground(Color.red);
                txtCPF.selectAll();
                txtCPF.setBackground(Color.LIGHT_GRAY);
            }

        } catch (StringIndexOutOfBoundsException e) {
            lbValidado.setIcon(new ImageIcon("src/imagens/Delete_16x16.png"));
            txtCPF.setBackground(Color.LIGHT_GRAY);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            lbValidado.setIcon(new ImageIcon("src/imagens/Delete_16x16.png"));
            txtCPF.setBackground(Color.LIGHT_GRAY);
            System.out.println(e.getMessage());
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.limpaCamposTelas();
    }

    private void limpaCamposTelas() {
        txtNomeProfessor.setText("");
        txtCPF.setText("");
        rbSexoMasc.isSelected();
        checkAtivoProfessor.isSelected();
        txtEndereco.setText("");
        txtNum.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtCEP.setText("");
        txAreaObs.setText("");
        lbValidado.setIcon(null);
        txtCPF.setBackground(Color.WHITE);
        //txtDtNasc.setDate(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeProfessor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskDtNascProf = null;
        try{
            maskDtNascProf = new javax.swing.text.MaskFormatter("##/##/####");
            maskDtNascProf.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtDtNasc = new javax.swing.JFormattedTextField(maskDtNascProf);
        jLabel4 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskCPFProf = null;
        try{
            maskCPFProf = new javax.swing.text.MaskFormatter("###.###.###.-##");
            maskCPFProf.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtCPF = new javax.swing.JFormattedTextField(maskCPFProf);
        jLabel10 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rbSexoMasc = new javax.swing.JRadioButton();
        rbSexoFem = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txAreaObs = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        checkAtivoProfessor = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        javax.swing.text.MaskFormatter maskTelProf = null;
        try{
            maskTelProf = new javax.swing.text.MaskFormatter("(##) ####-####");
            maskTelProf.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtTelefone = new javax.swing.JFormattedTextField(maskTelProf);
        jLabel8 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskCEPProf = null;
        try{
            maskCEPProf = new javax.swing.text.MaskFormatter("#####-###");
            maskCEPProf.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtCEP = new javax.swing.JFormattedTextField(maskCEPProf);
        jLabel13 = new javax.swing.JLabel();
        lbValidado = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Professor");

        btnSalvar.setText("Salvar");

        btnCancelar.setText("Cancelar");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Nome:");

        txtNomeProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProfessorActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de Nasc.:");

        jLabel4.setText("CPF:");

        jLabel10.setText("Endereço:");

        jLabel11.setText("Nº:");

        jLabel12.setText("Bairro:");

        jLabel14.setText("Complemento:");

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        jLabel17.setText("Obs:");

        jLabel19.setText("Sexo:");

        rbSexoMasc.setText("Masculino");

        rbSexoFem.setText("Feminino");

        txAreaObs.setColumns(20);
        txAreaObs.setRows(5);
        jScrollPane3.setViewportView(txAreaObs);

        jLabel5.setText("Ativo:");

        jLabel6.setText("E-mail: ");

        jLabel8.setText("Telefone:");

        jLabel13.setText("CEP:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(rbSexoMasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbSexoFem)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbValidado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(24, 24, 24)
                                        .addComponent(checkAtivoProfessor))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel17))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(71, 71, 71))
                                            .addComponent(jScrollPane3)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(rbSexoMasc)
                    .addComponent(rbSexoFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lbValidado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addComponent(checkAtivoProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProfessorActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox checkAtivoProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbValidado;
    private javax.swing.JRadioButton rbSexoFem;
    private javax.swing.JRadioButton rbSexoMasc;
    private javax.swing.JTextArea txAreaObs;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtDtNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeProfessor;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
