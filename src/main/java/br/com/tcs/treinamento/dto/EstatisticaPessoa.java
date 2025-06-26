package br.com.tcs.treinamento.dto;

public class EstatisticaPessoa {
    private Long totalPessoas;
    private Long totalCPF;
    private Long totalCNPJ;

    public Long getTotalPessoas() {
        return totalPessoas;
    }

    public void setTotalPessoas(Long totalPessoas) {
        this.totalPessoas = totalPessoas;
    }

    public Long getTotalCPF() {
        return totalCPF;
    }

    public void setTotalCPF(Long totalCPF) {
        this.totalCPF = totalCPF;
    }

    public Long getTotalCNPJ() {
        return totalCNPJ;
    }

    public void setTotalCNPJ(Long totalCNPJ) {
        this.totalCNPJ = totalCNPJ;
    }

}
