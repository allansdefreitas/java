package br.edu.allan.study.streams.peek;

import java.util.Arrays;
import java.util.List;

public class StreamsPeek {
	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

		int soma = numeros.stream().peek(n -> System.out.println("Elemento: " + n)).map(n -> n * 2)
				.peek(n -> System.out.println("Conteúdo depois do map: " + n))
				.reduce(0, (total, numero) -> total + numero);
		
		/* .reduce:
		 * O método reduce percorre os elementos do stream e acumula um resultado 
		 * baseado na operação definida, que no caso é a soma.
		 */

		System.out.println("A soma dos números é: " + soma);
	}
}
