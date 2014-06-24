package br.senai.view;

import br.senai.DAO.ProfessorDAO;
import br.senai.controller.AulaController;
import br.senai.controller.ProfessorController;
import br.senai.model.Aula;
import br.senai.model.Professor;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class CadastroAulaUI extends javax.swing.JInternalFrame {

    Aula aulaAlteracao;
    ProfessorDAO profDAO;
    Professor prof;

    /**
     * Creates new form Aula
     *
     * @param aula
     */
    public CadastroAulaUI(Aula aula) {
        initComponents();
        ajustQntAlunos();
        checkAtivoAula.setSelected(true);
        checkAtivoAula.setEnabled(false);
        if (aula != null) {
            this.aulaAlteracao = aula;
            checkAtivoAula.setEnabled(true);
            preencherAula(aula);
        }
    }

    private void ajustQntAlunos() {
        Integer value = new Integer(0);
        Integer min = new Integer(0);
        Integer max = new Integer(100);
        Integer step = new Integer(1);
        SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
        jQntAlunos.setModel(model);
    }

    private void preencherAula(Aula aula) {
        cbxDiaSemanaAula.setSelectedIndex(aula.getDiaSemana());
        txtHrInicioAula.setText(aula.gethInicio().toString());
        txtHrFinalAula.setText(aula.gethFim().toString());
        this.prof = aula.getProfessor();
        txtProfessorAula.setText(this.prof.getDscNome());
        jQntAlunos.setValue(aula.getNumeroAlunos());
        if (aula.getStatus() == 1) {
            checkAtivoAula.setSelected(true);
        } else {
            checkAtivoAula.setSelected(false);
        }
    }

    public void recebeProfessor(Professor professor) {
        this.show();
        txtProfessorAula.setText(professor.getDscNome());
        this.prof = professor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProfessorAula = new javax.swing.JTextField();
        btnBuscarProfessor = new javax.swing.JButton();
        cbxDiaSemanaAula = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskHrInicio = null;
        try{
            maskHrInicio= new javax.swing.text.MaskFormatter("##:##");
            maskHrInicio.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtHrInicioAula = new javax.swing.JFormattedTextField(maskHrInicio);
        javax.swing.text.MaskFormatter maskHrFinal = null;
        try{
            maskHrFinal= new javax.swing.text.MaskFormatter("##:##");
            maskHrFinal.setPlaceholderCharacter('_');

        }
        catch (java.text.ParseException exc) {}
        txtHrFinalAula = new javax.swing.JFormattedTextField(maskHrFinal);
        jLabel6 = new javax.swing.JLabel();
        checkAtivoAula = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jQntAlunos = new javax.swing.JSpinner();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Aulas");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Dia:");

        jLabel3.setText("Professor:");

        txtProfessorAula.setEnabled(false);

        btnBuscarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        btnBuscarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProfessorActionPerformed(evt);
            }
        });

        cbxDiaSemanaAula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um dia da semana", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado", "Domingo" }));

        jLabel2.setText("Hora inicial:");

        jLabel5.setText("Hora Término:");

        jLabel6.setText("Ativo: ");

        jLabel7.setText("Max. Alunos: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxDiaSemanaAula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProfessorAula, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkAtivoAula)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQntAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHrFinalAula))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtHrInicioAula, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbxDiaSemanaAula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHrInicioAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHrFinalAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProfessorAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jQntAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkAtivoAula, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (this.aulaAlteracao != null) {
                this.aulaAlteracao.setDiaSemana(cbxDiaSemanaAula.getSelectedIndex());
                this.aulaAlteracao.sethInicio(getHora(txtHrInicioAula.getText().toString()));
                this.aulaAlteracao.sethFim(getHora(txtHrFinalAula.getText().toString()));
                this.aulaAlteracao.setNumeroAlunos(getQntAlunos());
                if (checkAtivoAula.isSelected()) {
                    this.aulaAlteracao.setStatus(1);
                } else {
                    this.aulaAlteracao.setStatus(0);
                }
                this.aulaAlteracao.setProfessor(this.prof);

                AulaController.obterInstancia().alterar(this.aulaAlteracao);
                JOptionPane.showMessageDialog(rootPane, "Aula alterada com Sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                ConsultaAulaUI consAula = new ConsultaAulaUI(false);
                consAula.show();
                FormPrincipal.getPainelPrincipal().add(consAula);

            } else {
                Aula novaAula = new Aula();
                novaAula.setDiaSemana(cbxDiaSemanaAula.getSelectedIndex());
                novaAula.sethInicio(getHora(txtHrInicioAula.getText().toString()));
                novaAula.sethFim(getHora(txtHrFinalAula.getText().toString()));
                novaAula.setNumeroAlunos(getQntAlunos());
                novaAula.setStatus(1);
                novaAula.setProfessor(this.prof);

                AulaController.obterInstancia().inserir(novaAula);
                JOptionPane.showMessageDialog(rootPane, "Aula cadastrada com Sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProfessorActionPerformed
        this.hide();
        ProfessorController.obterInstancia().buscaProfessor(this);
    }//GEN-LAST:event_btnBuscarProfessorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProfessor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxDiaSemanaAula;
    private javax.swing.JCheckBox checkAtivoAula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jQntAlunos;
    private javax.swing.JTextField txtHrFinalAula;
    private javax.swing.JTextField txtHrInicioAula;
    private javax.swing.JTextField txtProfessorAula;
    // End of variables declaration//GEN-END:variables

    public int getDiaSemana() {
        return cbxDiaSemanaAula.getSelectedIndex();
    }

    public Time getHora(String hora) {
        String hr = hora;
        try {
            int horas = Integer.parseInt(hora.substring(0, 2));
            int minutos = Integer.parseInt(hora.substring(3, 5));
            if (horas > 24 || minutos > 59) {
                return null;
            }
            SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
            Date data = null;
            data = formatador.parse(hr);
            Time time = new Time(data.getTime());
            return time;
        } catch (Exception e) {
            return null;
        }
    }

    public int getQntAlunos() throws Exception {
        try {
            return (Integer) jQntAlunos.getValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public int getIsActive() {
        if (checkAtivoAula.isSelected()) {
            return 1;
        } else {
            return 0;
        }

    }

    private void limparCampos() {
        cbxDiaSemanaAula.setSelectedIndex(0);
        txtHrInicioAula.setText("");
        txtHrFinalAula.setText("");
        txtProfessorAula.setText("");
        jQntAlunos.setValue(0);
        checkAtivoAula.setSelected(true);
    }
}
