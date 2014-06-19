package br.senai.view;

import br.senai.controller.AlunoController;
import br.senai.model.Aluno;
import br.senai.util.Utils;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CadastroAlunoUI extends javax.swing.JInternalFrame {

    private Aluno alunoAlteracao;

    /**
     *
     * @param aluno
     */
    public CadastroAlunoUI(Aluno aluno) {
        initComponents();
        //centralizar();
        checkAtivoAluno.setSelected(true);
        checkAtivoAluno.setEnabled(false);
        rbSexoMascAluno.setSelected(true);
        if (aluno != null) {
            this.alunoAlteracao = aluno;
            preencheAluno(aluno);
            checkAtivoAluno.setEnabled(true);
        }
    }

    private void preencheAluno(Aluno aluno) {
        txtNomeAluno.setText(aluno.getDscNome().toString());
        txtCPFAluno.setText(aluno.getDscCPF().toString());

        if (aluno.getSexo() == 1) {
            rbSexoMascAluno.isSelected();
        } else {
            rbSexoFemAluno.isSelected();
        }

        if (aluno.getStatus() == 1) {
            checkAtivoAluno.setSelected(true);
        } else {
            checkAtivoAluno.setSelected(false);
        }

        txtAlturaAluno.setText(aluno.getAltura().toString());
        txtPesoAluno.setText(aluno.getPeso().toString());
        txtEnderecoAluno.setText(aluno.getDscEndereco().toString().isEmpty() ? aluno.getDscEndereco().toString() : "");
        txtNumAluno.setText(aluno.getNunNumero().toString());
        txtComplementoAluno.setText(aluno.getDscComplemento().toString());
        txtBairroAluno.setText(aluno.getDscBairro().toString());
        txtEmailAluno.setText(aluno.getDscEmail().toString());
        txtTelefoneAluno.setText(aluno.getTelefone().toString().isEmpty() ? aluno.getTelefone().toString() : "");
        txtCepAluno.setText(aluno.getDscCEP().toString());
        txAreaObs.setText(aluno.getDscObservacao().toString());
        jDateNasc.setDate(aluno.getDtDataNasc());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroupSexAluno = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskCPFAluno = null;
        try{
            maskCPFAluno= new javax.swing.text.MaskFormatter("###.###.###-##");
            maskCPFAluno.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtCPFAluno = new javax.swing.JFormattedTextField(maskCPFAluno);
        jLabel6 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskPesoAluno = null;
        try{
            maskPesoAluno= new javax.swing.text.MaskFormatter("###.#");
            maskPesoAluno.setPlaceholderCharacter(' ');

        }
        catch (java.text.ParseException exc) {}
        txtPesoAluno = new javax.swing.JFormattedTextField(maskPesoAluno);
        jLabel7 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskAlturaAluno = null;
        try{
            maskAlturaAluno= new javax.swing.text.MaskFormatter("#.##");
            maskAlturaAluno.setPlaceholderCharacter(' ');

        }
        catch (java.text.ParseException exc) {}
        txtAlturaAluno = new javax.swing.JFormattedTextField(maskAlturaAluno);
        jLabel10 = new javax.swing.JLabel();
        txtEnderecoAluno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNumAluno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBairroAluno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskCEPAluno = null;
        try{
            maskCEPAluno = new javax.swing.text.MaskFormatter("#####-###");
            maskCEPAluno.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtCepAluno = new javax.swing.JFormattedTextField(maskCEPAluno);
        jLabel14 = new javax.swing.JLabel();
        txtComplementoAluno = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rbSexoMascAluno = new javax.swing.JRadioButton();
        rbSexoFemAluno = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAulasAluno = new javax.swing.JTable();
        btnPesquisaAula = new javax.swing.JButton();
        btnRemoverAulas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        checkAtivoAluno = new javax.swing.JCheckBox();
        lblImcAluno = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txAreaObs = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtEmailAluno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskTelAluno = null;
        try{
            maskTelAluno = new javax.swing.text.MaskFormatter("(##) ####-####");
            maskTelAluno.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtTelefoneAluno = new javax.swing.JFormattedTextField(maskTelAluno);
        jDateNasc = new com.toedter.calendar.JDateChooser();
        lbValidado = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Aluno");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Nome:");

        jLabel3.setText("Data de Nasc.:");

        jLabel4.setText("CPF:");

        txtCPFAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPFAlunoFocusLost(evt);
            }
        });

        jLabel6.setText("Peso:");

        jLabel7.setText("Altura:");

        txtAlturaAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlturaAlunoFocusLost(evt);
            }
        });

        jLabel10.setText("Endereço:");

        jLabel11.setText("Nº:");

        jLabel12.setText("Bairro:");

        jLabel13.setText("CEP:");

        jLabel14.setText("Complemento:");

        jLabel17.setText("Obs:");

        jLabel19.setText("Sexo:");

        rbGroupSexAluno.add(rbSexoMascAluno);
        rbSexoMascAluno.setText("Masculino");

        rbGroupSexAluno.add(rbSexoFemAluno);
        rbSexoFemAluno.setText("Feminino");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aulas"));

        tableAulasAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Horários", "Dias da Semana"
            }
        ));
        jScrollPane2.setViewportView(tableAulasAluno);

        btnPesquisaAula.setText("Aulas");

        btnRemoverAulas.setText("Remover");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisaAula, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverAulas))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPesquisaAula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoverAulas))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setText("Ativo:");

        txAreaObs.setColumns(20);
        txAreaObs.setRows(5);
        jScrollPane3.setViewportView(txAreaObs);

        jLabel16.setText("E-mail: ");

        jLabel8.setText("Telefone:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(txtCPFAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValidado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3))
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtTelefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtNumAluno)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel14)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtComplementoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel12)))
                                            .addGap(21, 21, 21)
                                            .addComponent(txtBairroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEmailAluno))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtCepAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addGap(25, 25, 25)
                                .addComponent(rbSexoMascAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbSexoFemAluno)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(txtPesoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAlturaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImcAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkAtivoAluno)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(rbSexoMascAluno)
                    .addComponent(rbSexoFemAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPFAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jDateNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValidado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAlturaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblImcAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(checkAtivoAluno)
                        .addComponent(jLabel5)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtBairroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtComplementoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(txtNumAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCepAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlturaAlunoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlturaAlunoFocusLost
        Double altura = Double.parseDouble(txtAlturaAluno.getText());
        Double peso = Double.parseDouble(txtPesoAluno.getText());
        String valorIMC = CalcularIMC(altura, peso);
        lblImcAluno.setText(valorIMC);
    }//GEN-LAST:event_txtAlturaAlunoFocusLost

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (this.alunoAlteracao != null) {
                this.alunoAlteracao.setDscNome(txtNomeAluno.getText());
                this.alunoAlteracao.setDscCEP(txtCepAluno.getText());
                this.alunoAlteracao.setDscBairro(txtBairroAluno.getText());
                this.alunoAlteracao.setDscComplemento(txtComplementoAluno.getText());
                this.alunoAlteracao.setDscEmail(txtEmailAluno.getText());
                this.alunoAlteracao.setDscEndereco(txtEnderecoAluno.getText());
                this.alunoAlteracao.setDscObservacao(txAreaObs.getText());
                this.alunoAlteracao.setDscCPF(txtCPFAluno.getText());
                if (!txtNumAluno.getText().equals("")) {
                    this.alunoAlteracao.setNunNumero(Integer.parseInt(txtNumAluno.getText()));
                }
                this.alunoAlteracao.setStatus(1); //Ativo
                this.alunoAlteracao.setSexo(0);
                if (rbSexoFemAluno.isSelected()) {
                    this.alunoAlteracao.setSexo(1);
                }
                if (!txtAlturaAluno.getText().replace(".", "").equals("")) {
                    this.alunoAlteracao.setAltura(Double.parseDouble(txtAlturaAluno.getText()));
                }
                if (!txtPesoAluno.getText().replace(".", "").equals("")) {
                    this.alunoAlteracao.setPeso(Double.parseDouble(txtPesoAluno.getText()));
                }
                this.alunoAlteracao.setDtDataNasc(jDateNasc.getDate());

                AlunoController.obterInstancia().alterar(this.alunoAlteracao);
                JOptionPane.showMessageDialog(this, "Aluno alterado com sucesso");
                this.dispose();
            } else {
                Aluno aluno = new Aluno();
                aluno.setDscNome(txtNomeAluno.getText());
                aluno.setDscCEP(txtCepAluno.getText());
                aluno.setDscBairro(txtBairroAluno.getText());
                aluno.setDscComplemento(txtComplementoAluno.getText());
                aluno.setDscEmail(txtEmailAluno.getText());
                aluno.setDscEndereco(txtEnderecoAluno.getText());
                aluno.setDscObservacao(txAreaObs.getText());
                aluno.setDscCPF(txtCPFAluno.getText());
                aluno.setTelefone(txtTelefoneAluno.getText());
                if (!txtNumAluno.getText().equals("")) {
                    aluno.setNunNumero(Integer.parseInt(txtNumAluno.getText()));
                }
                aluno.setStatus(1); //Ativo
                aluno.setSexo(1);
                if (rbSexoFemAluno.isSelected()) {
                    aluno.setSexo(2);
                }
                if (!txtAlturaAluno.getText().replace(".", "").equalsIgnoreCase("   ")) {
                    System.out.println(txtAlturaAluno.getText().replace(".", ""));
                    aluno.setAltura(Double.parseDouble(txtAlturaAluno.getText()));
                }
                if (!txtPesoAluno.getText().replace(".", "").equals("    ")) {
                    aluno.setPeso(Double.parseDouble(txtPesoAluno.getText()));
                }
                aluno.setDtDataNasc(jDateNasc.getDate());

                AlunoController.obterInstancia().inserir(aluno);
                JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                this.limpaCamposTelas();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCPFAlunoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFAlunoFocusLost
        try {
            Icon i = null;
            //CPF:
            String cpf = txtCPFAluno.getText().replace("-", "").replace(".", "").replace("_", "").toString();
            //Valida se CPF informado é Valido e verifica se realmente foi informado algum CPF.
            if (Utils.validarCPF(cpf)) {
                i = new ImageIcon("src/imagens/Check_16x16.png");
                lbValidado.setIcon(i);
                txtCPFAluno.setBackground(Color.WHITE);

                //Entra no else caso CPF invalido.
            } else {
                i = new ImageIcon("src/imagens/Delete_16x16.png");
                lbValidado.setIcon(i);
                //   txtCPFCNPJ.setBackground(Color.red);
                txtCPFAluno.selectAll();
                txtCPFAluno.setBackground(Color.LIGHT_GRAY);
            }

        } catch (StringIndexOutOfBoundsException e) {
            lbValidado.setIcon(new ImageIcon("src/imagens/Delete_16x16.png"));
            txtCPFAluno.setBackground(Color.LIGHT_GRAY);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            lbValidado.setIcon(new ImageIcon("src/imagens/Delete_16x16.png"));
            txtCPFAluno.setBackground(Color.LIGHT_GRAY);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtCPFAlunoFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpaCamposTelas();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private String CalcularIMC(Double altura, Double peso) {
        DecimalFormat deci = new DecimalFormat("00.00");
        double imc = (peso / (altura * altura));
        String bla = deci.format(imc);
        if (imc < 16) {
            return "IMC: " + bla + ".Muito abaixo do peso";
        } else if ((imc >= 16) && (imc < 18.49)) {
            return "IMC: " + bla + ".Abaixo do peso.";
        } else if ((imc >= 18.5) && (imc < 24.99)) {
            return "IMC: " + bla + ".Peso normal.";
        } else if ((imc >= 25) && (imc < 29.99)) {
            return "IMC: " + bla + ".Acima do peso.";
        } else if ((imc >= 30) && (imc < 34.99)) {
            return "IMC: " + bla + ".Obesidade I.";
        } else if ((imc >= 35) && (imc < 39.99)) {
            return "IMC: " + bla + ".Obesidade II (severa).";
        } else {
            return "IMC: " + bla + ".Obesidade III (mórbida).";
        }
    }

    private void limpaCamposTelas() {
        txtNomeAluno.setText("");
        txtCPFAluno.setText("");
        rbSexoMascAluno.isSelected();
        checkAtivoAluno.isSelected();
        txtAlturaAluno.setText("");
        txtPesoAluno.setText("");
        txtEnderecoAluno.setText("");
        txtNumAluno.setText("");
        txtComplementoAluno.setText("");
        txtBairroAluno.setText("");
        txtEmailAluno.setText("");
        txtTelefoneAluno.setText("");
        txtCepAluno.setText("");
        txAreaObs.setText("");
        lbValidado.setIcon(null);
        txtCPFAluno.setBackground(Color.WHITE);
        jDateNasc.setDate(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPesquisaAula;
    private javax.swing.JButton btnRemoverAulas;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox checkAtivoAluno;
    private com.toedter.calendar.JDateChooser jDateNasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbValidado;
    private javax.swing.JLabel lblImcAluno;
    private javax.swing.ButtonGroup rbGroupSexAluno;
    private javax.swing.JRadioButton rbSexoFemAluno;
    private javax.swing.JRadioButton rbSexoMascAluno;
    private javax.swing.JTable tableAulasAluno;
    private javax.swing.JTextArea txAreaObs;
    private javax.swing.JTextField txtAlturaAluno;
    private javax.swing.JTextField txtBairroAluno;
    private javax.swing.JTextField txtCPFAluno;
    private javax.swing.JTextField txtCepAluno;
    private javax.swing.JTextField txtComplementoAluno;
    private javax.swing.JTextField txtEmailAluno;
    private javax.swing.JTextField txtEnderecoAluno;
    private javax.swing.JTextField txtNomeAluno;
    private javax.swing.JTextField txtNumAluno;
    private javax.swing.JTextField txtPesoAluno;
    private javax.swing.JTextField txtTelefoneAluno;
    // End of variables declaration//GEN-END:variables

    private void centralizar() {
        Dimension d = FormPrincipal.getPainelPrincipal().getSize();
        this.setLocation((d.height - this.getHeight() / 2), (d.width - this.getWidth() / 2));
    }
}
