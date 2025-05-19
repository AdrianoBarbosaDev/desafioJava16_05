package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa{
    BigDecimal Salario;
    String funcao;

    public BigDecimal getSalario() {
        return Salario;
    }
    public void setSalario(BigDecimal salario) {
        Salario = salario;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setPessoa(Pessoa pessoa){
        this.nome = pessoa.nome;
        this.dataNascimento = pessoa.dataNascimento;
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        Salario = salario;
        this.funcao = funcao;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataNascimento.format(formatter) ;

        return "Funcionario [nome=" + nome + ", dataNascimento=" + dataFormatada + ", Salario=" + Salario + ", funcao="
                + funcao + "]";
    }

    
    

}
