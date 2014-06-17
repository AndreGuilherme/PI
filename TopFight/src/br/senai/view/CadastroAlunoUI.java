package br.senai.view;

import br.senai.controller.AlunoController;
import br.senai.model.Aluno;
import javax.swing.JOptionPane;

public class CadastroAlunoUI extends javax.swing.JInternalFrame {

    private Aluno alunoAlteracao;

    /**
     *
     * @param aluno
     */
    public CadastroAlunoUI(Aluno aluno) {
        initComponents();
        if (aluno != null) {
            this.alunoAlteracao = aluno;
        }
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
            maskCPFAluno= new javax.swing.text.MaskFormatter("###.###.###.-##");
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
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Aluno");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Nome:");

        jLabel3.setText("Data de Nasc.:");

        jLabel4.setText("CPF:");

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

        lblImcAluno.setText("IMC");

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
                                .addComponent(rbSexoFemAluno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(txtPesoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAlturaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblImcAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkAtivoAluno)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPFAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jDateNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAlturaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblImcAluno))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPesoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkAtivoAluno)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

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
                .addContainerGap(16, Short.MAX_VALUE))
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
                this.alunoAlteracao.setNunNumero(Integer.parseInt(txtNumAluno.getText()));
                this.alunoAlteracao.setStatus(1); //Ativo
                this.alunoAlteracao.setSexo(1);
                //if(rbSexoFemAluno)){ Verificar se ta marcado o feminino
                // this.aluno.setSexo(2);   
                // }
                this.alunoAlteracao.setAltura(Double.parseDouble(txtAlturaAluno.getText()));
                this.alunoAlteracao.setPeso(Double.parseDouble(txtPesoAluno.getText()));
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
                aluno.setNunNumero(Integer.parseInt(txtNumAluno.getText()));
                aluno.setStatus(1); //Ativo
                aluno.setSexo(1);
                //if(rbSexoFemAluno)){ Verificar se ta marcado o feminino
                // this.aluno.setSexo(2);   
                // }
                aluno.setAltura(Double.parseDouble(txtAlturaAluno.getText()));
                aluno.setPeso(Double.parseDouble(txtPesoAluno.getText()));
                aluno.setDtDataNasc(jDateNasc.getDate());
                
                AlunoController.obterInstancia().inserir(aluno);
                JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso");
                this.dispose();
            }
        } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private String CalcularIMC(Double altura, Double peso) {
        double imc = (peso / (altura * altura));
        if (imc < 16) {
            return "Muito abaixo do peso";
        } else if ((imc >= 17) && (imc < 18.49)) {
            return "Abaixo do peso.";
        } else if ((imc >= 18.5) && (imc < 24.99)) {
            return "Peso normal.";
        } else if ((imc >= 25) && (imc < 29.99)) {
            return "Acima do peso.";
        } else if ((imc >= 30) && (imc < 34.99)) {
            return "Obesidade I.";
        } else if ((imc >= 35) && (imc < 39.99)) {
            return "Obesidade II (severa).";
        } else {
            return "Obesidade III (mórbida).";
        }
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
}
