package br.com.tcs.treinamento.bean;
import br.com.tcs.treinamento.dto.EstatisticaPessoa;
import br.com.tcs.treinamento.service.PessoaService;
import br.com.tcs.treinamento.service.impl.PessoaServiceImpl;



import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "dashboardPessoaBean")
@ViewScoped
public class DashboardPessoaBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private EstatisticaPessoa estatisticaPessoa;

    private transient PessoaService pessoaService = new PessoaServiceImpl();

    @PostConstruct
    public void init() {
        estatisticaPessoa = pessoaService.obterEstatisticas();
    }

    public EstatisticaPessoa getEstatisticaPessoa() {
        return estatisticaPessoa;
    }

    public void setEstatisticaPessoa(EstatisticaPessoa estatisticaPessoa) {
        this.estatisticaPessoa = estatisticaPessoa;
    }

}

