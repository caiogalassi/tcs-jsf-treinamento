package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.entity.Pessoa;
import br.com.tcs.treinamento.service.PessoaService;
import br.com.tcs.treinamento.service.impl.PessoaServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "consultaPessoaJuridicaBean")
@ViewScoped
public class ConsultaPessoaJuridicaBean implements Serializable {

    private List<Pessoa> pessoasJuridicas;
    private transient PessoaService pessoaService = new PessoaServiceImpl();

    @PostConstruct
    public void init() {
        pessoasJuridicas = pessoaService.buscarPorTipoDocumento("CNPJ");
    }

    public List<Pessoa> getPessoasJuridicas() {
        return pessoasJuridicas;
    }

    public void setPessoasJuridicas(List<Pessoa> pessoasJuridicas) {
        this.pessoasJuridicas = pessoasJuridicas;
    }
}
