
package br.senai.model;

import java.util.Date;

public class Pessoa {
    private Integer numIdPessoa;
    private String dscCPF;
    private String dscNome;
    private Date dtDataNasc;
    private String dscEndereco;
    private Integer nunNumero;
    private String dscBairro;
    private String dscCEP;
    private String dscComplemento;
    private Integer sexo;
    private String dscEmail;
    private String dscObservacao;
    private Integer status;

    public Integer getNumIdPessoa() {
        return numIdPessoa;
    }

    public void setNumIdPessoa(int numIdPessoa) {
        this.numIdPessoa = numIdPessoa;
    }
    
    public String getDscCPF() {
        return dscCPF;
    }

    public void setDscCPF(String dscCPF) {
        this.dscCPF = dscCPF;
    }

    public String getDscNome() {
        return dscNome;
    }

    public void setDscNome(String dscNome) {
        this.dscNome = dscNome;
    }

    public Date getDtDataNasc() {
        return dtDataNasc;
    }

    public void setDtDataNasc(Date dtDataNasc) {
        this.dtDataNasc = dtDataNasc;
    }

    public String getDscEndereco() {
        return dscEndereco;
    }

    public void setDscEndereco(String dscEndereco) {
        this.dscEndereco = dscEndereco;
    }

    public Integer getNunNumero() {
        return nunNumero;
    }

    public void setNunNumero(Integer nunNumero) {
        this.nunNumero = nunNumero;
    }

    public String getDscBairro() {
        return dscBairro;
    }

    public void setDscBairro(String dscBairro) {
        this.dscBairro = dscBairro;
    }

    public String getDscCEP() {
        return dscCEP;
    }

    public void setDscCEP(String dscCEP) {
        this.dscCEP = dscCEP;
    }

    public String getDscComplemento() {
        return dscComplemento;
    }

    public void setDscComplemento(String dscComplemento) {
        this.dscComplemento = dscComplemento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getDscEmail() {
        return dscEmail;
    }

    public void setDscEmail(String dscEmail) {
        this.dscEmail = dscEmail;
    }

    public String getDscObservacao() {
        return dscObservacao;
    }

    public void setDscObservacao(String dscObservacao) {
        this.dscObservacao = dscObservacao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
}
