package com.cwcdev.dio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwcdev.dio.model.Cliente;
import com.cwcdev.dio.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("clientes")
@Tag(name = "Clientes", description = "Gerenciamento de clientes")
public class ClienteRestController {
	@Autowired
	private ClientService clientService;

	@Operation(summary = "Lista todos os clientes")
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clientService.buscarTodos());
	}

	@Operation(summary = "Busca um cliente pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.buscarPorId(id));
	}

	@Operation(summary = "Adiciona um novo cliente")
	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
		clientService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}

	@Operation(summary = "Atualiza um cliente pelo ID")
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		clientService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@Operation(summary = "Deleta um cliente pelo ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clientService.deletar(id);
		return ResponseEntity.ok().build();

	}

}
