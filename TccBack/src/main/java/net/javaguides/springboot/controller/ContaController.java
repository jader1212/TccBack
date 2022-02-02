package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Conta;
import net.javaguides.springboot.repository.ContaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
// @RequestMapping("/api/v1/")
public class ContaController {
	@Autowired
	private ContaRepository contaRepository;
	
	// get all contas
	@GetMapping("/contas")
	public List<Conta> getAllContas() {
		return contaRepository.findAll();
	}

	// create conta rest api
	@PostMapping("/contas-add")
	public Conta createConta(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}
	
	// get conta by id rest api
	@GetMapping("/contas-get/{id}")
	public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
		Conta conta = contaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Conta inexistente com o id :" + id));
		return ResponseEntity.ok(conta);
	}
	
	// update conta rest api
	@PutMapping("/contas-upd/{id}")
	public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta contaDetails) {
		Conta conta = contaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Conta inexistente com o id :" + id));
		
		// descricao, categoria, valor, data, tipo		
		conta.setDescricao(contaDetails.getDescricao());
		conta.setCategoria(contaDetails.getCategoria());
		conta.setValor(contaDetails.getValor());
		conta.setData(contaDetails.getData());
		conta.setTipo(contaDetails.getTipo());
		
		Conta updatedConta = contaRepository.save(conta);
		return ResponseEntity.ok(updatedConta);
	}
	
	// delete conta rest api
	@DeleteMapping("/contas-del/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteConta(@PathVariable Long id) {
		Conta conta = contaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Conta inexistente com o id :" + id));
		
		contaRepository.delete(conta);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// get sum all contas
	@GetMapping("/contas-soma")
	public Map<String, String> getSumContas() {
		HashMap<String, String> map = new HashMap<>();

		// soma receitas	
		String receita = contaRepository.sumReceita();

		// soma despesas
		String despesa = contaRepository.sumDespesa();

		map.put("receita", receita);
		map.put("despesa", despesa);
		return map;
	}

	// get by type all contas
	@GetMapping("/contas-tipo/{tipo}")
	public List<Conta> getContaByType(@PathVariable Long tipo) {
		return contaRepository.findByTipo(tipo);
	}

	// get relatorio
	@GetMapping("/contas-rel")
	public ArrayList<Object[]> getRelContas() {
		return (ArrayList<Object[]>) contaRepository.getRelContas(); //findAll();
	}

}
