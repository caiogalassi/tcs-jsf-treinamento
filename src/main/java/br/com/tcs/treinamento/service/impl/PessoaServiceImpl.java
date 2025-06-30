package br.com.tcs.treinamento.service.impl;

import br.com.tcs.treinamento.dao.PessoaDAO;
import br.com.tcs.treinamento.dto.EstatisticaPessoa;
import br.com.tcs.treinamento.entity.Pessoa;
import br.com.tcs.treinamento.service.PessoaService;

import java.util.List;

public class PessoaServiceImpl implements PessoaService {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    @Override
    public void cadastrar(Pessoa pessoa) {
        pessoaDAO.cadastrar(pessoa);
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaDAO.buscarPorId(id);
    }

    @Override
    public List<Pessoa> listar() {
        return pessoaDAO.listar();
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        pessoaDAO.atualizar(pessoa);
    }

    @Override
    public void excluir(Pessoa pessoa) {
        pessoaDAO.excluir(pessoa);
    }

    @Override
    public List<Pessoa> buscarPorCPF(String cpf) {
        return pessoaDAO.buscarPorCPF(cpf);
    }

    @Override
    public List<Pessoa> buscarPorCNPJ(String cnpj) {
        return pessoaDAO.buscarPorCNPJ(cnpj);
    }

    @Override
    public EstatisticaPessoa obterEstatisticas() {
        EstatisticaPessoa estatistica = new EstatisticaPessoa();

        estatistica.setTotalPessoas(pessoaDAO.contagemTotalPessoas());
        estatistica.setTotalCPF(pessoaDAO.contagemCPF());
        estatistica.setTotalCNPJ(pessoaDAO.contagemCNPJ());

        return estatistica;
    }

    @Override
    public List<Pessoa> buscarPorTipoDocumento(String tipoDocumento) {
        return pessoaDAO.buscarPorTipoDocumento(tipoDocumento);
    }
}