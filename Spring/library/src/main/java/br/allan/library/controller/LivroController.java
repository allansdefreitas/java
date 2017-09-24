package br.allan.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.allan.library.entity.Livro;
import br.allan.library.repository.LivroRepository;

@Controller
@RequestMapping("/")
public class LivroController {
      
      private LivroRepository livroRepository;
 
      @Autowired
      public LivroController( LivroRepository livroRepository) {
            this.livroRepository = livroRepository;
      }
      
      
      /* recebe o autor e retorna os livros desse autor, via GET */
      @RequestMapping(value = "/{autor}", method = RequestMethod.GET)
      public String listaLivros(@PathVariable("autor") String autor, Model model) {
    	  
            List<Livro> listaLivros = livroRepository.findByAutor(autor); /* a lista receb
            todos os livros do autor recebido pelo parÂmetro */
            if (listaLivros != null) { /* Se tiver retornado livros, adiciona ao model */
                  model.addAttribute("livros", listaLivros);
            }
            return "listaLivros"; 
      
      }
 
      /* recebe o autor (por parâmetro) e adiciona um livro (pelo formulário), via POST*/
      @RequestMapping(value = "/{autor}", method = RequestMethod.POST)
      public String adicionaLivroAutor(@PathVariable("autor") String autor, Livro livro) {
    	  
            livro.setAutor(autor); /* seleciona o autor do livro */
            livroRepository.save(livro); /* Salva o livro no BD */
            
            return "redirect:/{autor}"; /* redireciona para método "listaLivros" para exibir 
            	o livro cadastrado*/
      
      }
}