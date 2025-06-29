package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.entity.Pessoa;
import br.com.tcs.treinamento.service.PessoaService;
import br.com.tcs.treinamento.service.impl.PessoaServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext; // Importar do javax.faces
import javax.faces.application.FacesMessage; // Importar do javax.faces
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "aniversarianteBean")
@ViewScoped
public class AniversarianteBean implements Serializable {

    private List<Pessoa> listaAniversariantes;
    // Mantenha como você já tem
    private transient PessoaService pessoaService = new PessoaServiceImpl();

    // *** ADIÇÃO: NOVA PROPRIEDADE para armazenar a pessoa selecionada para remoção ***
    private Pessoa pessoaSelecionada;

    @PostConstruct
    public void init() {
        carregarAniversariantesDoMes();
    }

    public void carregarAniversariantesDoMes() {
        List<Pessoa> todas = pessoaService.listar(); // Usa o método listar() do seu PessoaService

        int mesAtual = Calendar.getInstance().get(Calendar.MONTH); // Calendar.MONTH é baseado em 0 (Janeiro = 0)

        this.listaAniversariantes = todas.stream()
                .filter(p -> p.getData() != null)
                .filter(p -> Boolean.TRUE.equals(p.getAtivo())) // Garante que a pessoa esteja ativa
                .filter(p -> {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(p.getData()); // Converte java.util.Date para Calendar
                    return cal.get(Calendar.MONTH) == mesAtual;
                })
                .collect(Collectors.toList());
    }

    // *** ADIÇÃO: Método para pré-selecionar a pessoa e abrir o diálogo de confirmação ***
    public void confirmarRemocao(Pessoa pessoa) {
        this.pessoaSelecionada = pessoa;
        // Nenhuma mensagem de FacesContext aqui, pois o p:confirmDialog já lida com a mensagem
    }

    // *** ADIÇÃO: Método para realmente remover a pessoa do banco de dados ***
    public void removerAniversariante() {
        if (pessoaSelecionada != null) {
            try {
                pessoaService.excluir(pessoaSelecionada); // Chama o método excluir do seu PessoaService

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa removida com sucesso!"));

                // Recarrega a lista para atualizar a tabela na tela
                carregarAniversariantesDoMes();
                this.pessoaSelecionada = null; // Limpa a seleção
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao remover pessoa: " + e.getMessage()));
                e.printStackTrace();
            }
        }
    }

    // *** Getters e Setters EXISTENTES ***
    public List<Pessoa> getListaAniversariantes() {
        return listaAniversariantes;
    }

    public void setListaAniversariantes(List<Pessoa> listaAniversariantes) {
        this.listaAniversariantes = listaAniversariantes;
    }

    // *** ADIÇÃO: Getter e Setter para pessoaSelecionada ***
    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }
}