package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.entity.Pessoa;
import br.com.tcs.treinamento.service.PessoaService;
import br.com.tcs.treinamento.service.impl.PessoaServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "consultaPessoaFisicaBean")
@ViewScoped
public class ConsultaPessoaFisicaBean implements Serializable {

    private List<Pessoa> pessoasFisicas;
    private transient PessoaService pessoaService = new PessoaServiceImpl();

    @PostConstruct
    public void init() {
        pessoasFisicas = pessoaService.buscarPorTipoDocumento("CPF");
    }

    public List<Pessoa> getPessoasFisicas() {
        return pessoasFisicas;
    }

    public void setPessoasFisicas(List<Pessoa> pessoasFisicas) {
        this.pessoasFisicas = pessoasFisicas;
    }
}