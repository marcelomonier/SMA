package com.marcelomonier.iisemanademeioambiente;

import java.io.Serializable;
import java.sql.ResultSet;

public class User extends _Default implements Serializable {


    private static final long serialVersionUID = 1L;
    private int idAluno;
    private String matricula;
    private String senha;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String qrcode;


    public User(int idAluno, String matricula, String senha, String cpf, String nome, String email, String telefone, String qrcode) {
        super();
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.qrcode = qrcode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }


    public ResultSet buscarUser(String cpf, String senha) {


        DB db = new DB();

        try {
            ResultSet resultSet = db.select("SELECT * FROM aluno WHERE cpf ='"
                    + cpf + "' and senha = '" + senha + "'");

            if (resultSet != null) {

                return resultSet;

            } else {
                return null;
            }
        } catch (Exception ex) {
            this._mensagem = ex.getMessage();
            this._status = false;


        }

        return null;
    }

}
