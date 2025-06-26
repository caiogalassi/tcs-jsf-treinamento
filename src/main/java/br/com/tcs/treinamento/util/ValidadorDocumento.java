package br.com.tcs.treinamento.util;

public class ValidadorDocumento {

    // Valida se o CPF tem 11 dígitos numéricos
    public static boolean isCpfValido(String cpf) {
        if (cpf == null) return false;

        // Remove tudo que não for dígito
        String apenasDigitos = cpf.replaceAll("\\D", "");
        return apenasDigitos.length() == 11;
    }

    // Valida se o CNPJ tem 14 dígitos numéricos
    public static boolean isCnpjValido(String cnpj) {
        if (cnpj == null) return false;

        // Remove tudo que não for dígito
        String apenasDigitos = cnpj.replaceAll("\\D", "");
        return apenasDigitos.length() == 14;
    }
}