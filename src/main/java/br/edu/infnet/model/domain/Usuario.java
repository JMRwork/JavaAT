package br.edu.infnet.model.domain;

import java.util.Collection;

public class Usuario extends Pessoa{
    private int id;
    private String email;
    private String senha;
    private Collection<Item> inventario;
    private boolean admin;
    private Endereco endereco;

    public Usuario(String email, String senha, boolean admin) {
        super();
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", " + email  +
                ", " + super.toString() +
                ", inventario: " + inventario +
                ", " + endereco +
                ", admin: " + admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id > 0) {
            this.id = id;
        } else {
            throw new Exception("O id deve ser único e maior que zero.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.]+$")) {
            this.email = email;
        } else {
            throw new Exception("Email inválido.");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        if(senha.matches("^.{8,20}$")) {
            this.senha = senha;
        } else {
            throw new Exception("A senha deve possuir entre 8 e 20 caracteres");
        }
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String tipoAcesso () {
        if(this.isAdmin()) {
            return "Esse usuário possui acesso total";
        } else {
            return "Esse usuário possui acesso restrito";
        }
    }

    public Collection<Item> getInventario() {
        return inventario;
    }

    public void setInventario(Collection<Item> inventario) {
        this.inventario = inventario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
