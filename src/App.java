import model.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {

        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Heloisa", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Caio", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        System.out.println("******************************************************");
        System.out.println("INICIANDO ITEM 3.2- REMOCAO DO JOAO");
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        System.out.println("JOÃO REMOVIDO");
        System.out.println("******************************************************");

        System.out.println("******************************************************");
        System.out.println("INICIANDO ITEM 3.3- IMPRIMINDO DATA COM FORMATO DD/MM/AAAA E SALARIO FORMATADO:");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                funcionarios.forEach(
                    f -> 
                    System.out.println(
                        "Nome: " + f.getNome() +
                        ", Data de Nascimento: " + f.getDataNascimento().format(formatter) +
                        ", Salário: " + String.format("%,.2f", f.getSalario()).replace(",", "#")
                                                                              .replace(".", ",")
                                                                              .replace("#", ".")+ 
                        ", Função: " + f.getFuncao()));

        System.out.println("******************************************************");

        System.out.println("******************************************************");
        System.out.println("INICIANDO ITEM 3.4- AUMENTANDO SALÁRIO EM 10%:");
        funcionarios.forEach(
            f ->  f.setSalario(
                new BigDecimal(f.getSalario().intValue() + (f.getSalario().intValue() * 0.1)).setScale(2,RoundingMode.HALF_EVEN)
                )
            );

        funcionarios.forEach(
            f -> System.out.println(f)
            );

        System.out.println("******************************************************");

        System.out.println("******************************************************");
        System.out.println("INICIANDO ITEM 3.5- AGRUPANDO COM MAP:");

        Map<String, List<Funcionario>> mapaFuncionarios = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        mapaFuncionarios.forEach((funcao, listaFuncionarios) -> {
            System.out.println("Função: " + funcao);
            listaFuncionarios.forEach(f -> System.out.println(f));
        });


        System.out.println("******************************************************");

    }
}
