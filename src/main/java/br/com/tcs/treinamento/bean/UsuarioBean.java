package br.com.tcs.treinamento.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

import java.io.Serializable;

@ManagedBean(name ="usuarioBean" )
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID= 1L;
    private String nome;
    private boolean exibirPopUp = false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isExibirPopUp() {
        return exibirPopUp;
    }

    public void setExibirPopUp(boolean exibirPopUp) {
        this.exibirPopUp = exibirPopUp;
    }

    public void salvar() {
        this.exibirPopUp = true;
        System.out.println(nome);
    }
}
