package br.unicesumar.pessoa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.pessoa.papel.Aluno;
import br.unicesumar.pessoa.papel.Empresa;
import br.unicesumar.pessoa.papel.Professor;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	@Autowired
	private PessoaRepository repo;
	
	
	@GetMapping
	public List<Pessoa> get() {
		return repo.findAll();
	}
	
	@PostMapping("/fisicas")
	public String post(@RequestBody Fisica nova) {
		repo.save(nova);
		return nova.getId();
	}
	
	@PostMapping("/juridicas")
	public String post(@RequestBody Juridica nova) {
		repo.save(nova);
		return nova.getId();
	}
	
	@PostMapping("/{id}/professor")
	public void post(@PathVariable UUID id, @RequestBody Professor papel) {
		Pessoa pessoa = repo.findById(id).get();
		pessoa.addPapel(papel);
		repo.save(pessoa);
	}
	@PostMapping("/{id}/aluno")
	public void post(@PathVariable UUID id, @RequestBody Aluno papel) {
		Pessoa pessoa = repo.findById(id).get();
		pessoa.addPapel(papel);
		repo.save(pessoa);
	}
	@PostMapping("/{id}/empresa")
	public void post(@PathVariable UUID id, @RequestBody Empresa papel) {
		Pessoa pessoa = repo.findById(id).get();
		if (pessoa instanceof Fisica) {
			throw new RuntimeException("Pessoas físicas não podem ser empresas!");
		}
		pessoa.addPapel(papel);
		repo.save(pessoa);
	}

}
