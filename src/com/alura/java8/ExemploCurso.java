package com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ExemploCurso {
  public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<>();
    cursos.add(new Curso("Python", 45));
    cursos.add(new Curso("JavaScript", 150));
    cursos.add(new Curso("Java 8", 118));
    cursos.add(new Curso("C", 55));

    cursos.sort(Comparator.comparing(Curso::getNome));

    System.out.println("### Cursos ordenado por nome ###");
    cursos.forEach(curso -> System.out.println(curso.getNome()));
    System.out.println(" ============================= ");

    System.out.println("### Filtro para mais de 50 alunos ###");
    cursos.stream()
        .filter(curso -> curso.getAlunos() >= 50)
        .forEach(curso -> System.out.println(curso.getNome()));
    System.out.println(" ============================= ");

    int sum = cursos.stream()
        .filter(curso -> curso.getAlunos() >= 100)
        .mapToInt(Curso::getAlunos)
        .sum();

    System.out.println("### Soma das turmas que possuem mais de 100 alunos ###");
    System.out.println(sum);
    System.out.println(" ============================= ");

    System.out.println("### pega qualquer curso com mais de 100 alunos ###");
    cursos.stream()
        .filter(curso -> curso.getAlunos() >= 100)
        .findAny()
        .ifPresent(curso -> System.out.println(curso.getNome()));
    System.out.println(" ============================= ");


    System.out.println("### Utilizacao do Collect ###");
    cursos.parallelStream()
        .filter(curso -> curso.getAlunos() >= 100)
        .collect(Collectors.toMap(
            Curso::getNome,
            Curso::getAlunos
        ))
        .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
    System.out.println(" ============================= ");

    System.out.println("### Media das turmas ###");
    cursos.stream()
        .mapToInt(Curso::getAlunos)
        .average()
        .ifPresent(media -> System.out.println("Media das turmas: " + media));
    System.out.println(" ============================= ");
  }
}
