package br.edu.allan.study.generics;

public class CaixaTest{
	
	
	public static void main(String[] args) {
		
		Caixa caixa = new Caixa();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ester");
		pessoa.setIdade(27);
		
		caixa.setConteudo(pessoa);
		
		System.out.println(caixa);
		
		
		Caixa<String> caixaDeTexto = new Caixa<>();
        caixaDeTexto.setConteudo("Guardando texto na minha caixa!");
        System.out.println(caixaDeTexto);
        
        Caixa<Integer> caixaDeIdade = new Caixa<>();
        caixaDeIdade.setConteudo(30);
        System.out.println(caixaDeIdade);
        
        Caixa<Double> caixaDeValor = new Caixa<>();
        caixaDeValor.setConteudo(150.50);
        System.out.println(caixaDeValor);
	}
	

	
}
