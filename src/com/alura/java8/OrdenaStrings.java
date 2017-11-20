package com.alura.java8;

import java.util.ArrayList;
import java.util.List;

public class OrdenaStrings {

  public static void main(String[] args) {

    List<String> palavras = new ArrayList<>();
    palavras.add("Alura online");
    palavras.add("editora Casa do codigo");
    palavras.add("caelum");

    palavras.sort(String.CASE_INSENSITIVE_ORDER);

    System.out.println(palavras);

    palavras.forEach(System.out::println);

    new Thread(() -> System.out.println("Executando um Runnable")).start();
  }
}
