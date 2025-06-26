package br.com.tcs.treinamento.dao;

import br.com.tcs.treinamento.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class PessoaDAO {

    // Remova a anotação @Stateless e a injeção via @PersistenceContext
    private EntityManager em;
    private static EntityManagerFactory emf;

    // Construtor que cria manualmente o EntityManager
    public PessoaDAO() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("myPU");
        }
        em = emf.createEntityManager();
    }

    // Método para cadastrar (inserir) uma nova Pessoa
    public void cadastrar(Pessoa pessoa) {
        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    // Método para buscar uma Pessoa pelo seu ID
    public Pessoa buscarPorId(Long id) {
        return em.find(Pessoa.class, id);
    }

    // Método para listar todas as Pessoas
    public List<Pessoa> listar() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    // Método para atualizar os dados de uma Pessoa
    public Pessoa atualizar(Pessoa pessoa) {
        try {
            em.getTransaction().begin();
            Pessoa p = em.merge(pessoa);
            em.getTransaction().commit();
            return p;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    // Método para excluir (remover) uma Pessoa
    public void excluir(Pessoa pessoa) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(pessoa) ? pessoa : em.merge(pessoa));
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    public List<Pessoa> buscarPorCPF(String cpf) {
        try {
            return em.createQuery("SELECT p FROM Pessoa p WHERE p.numeroCPF = :cpf", Pessoa.class)
                    .setParameter("cpf", cpf)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Pessoa> buscarPorCNPJ(String cnpj) {
        try {
            return em.createQuery("SELECT p FROM Pessoa p WHERE p.numeroCNPJ = :cnpj", Pessoa.class)
                    .setParameter("cnpj", cnpj)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Long contagemTotalPessoas() {
        return em.createQuery("SELECT COUNT(p) FROM Pessoa p", Long.class)
                .getSingleResult();
    }

    // Conta pessoas com tipo de documento CPF
    public Long contagemCPF() {
        return em.createQuery("SELECT COUNT(p) FROM Pessoa p WHERE p.tipoDocumento = :tipo", Long.class)
                .setParameter("tipo", "CPF")
                .getSingleResult();
    }

    // Conta pessoas com tipo de documento CNPJ
    public Long contagemCNPJ() {
        return em.createQuery("SELECT COUNT(p) FROM Pessoa p WHERE p.tipoDocumento = :tipo", Long.class)
                .setParameter("tipo", "CNPJ")
                .getSingleResult();
    }
}