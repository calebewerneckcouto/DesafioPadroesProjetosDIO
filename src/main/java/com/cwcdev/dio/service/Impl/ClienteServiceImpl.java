package com.cwcdev.dio.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwcdev.dio.model.Cliente;
import com.cwcdev.dio.model.Endereco;
import com.cwcdev.dio.repository.ClienteRepository;
import com.cwcdev.dio.repository.EnderecoRepository;
import com.cwcdev.dio.service.ClientService;
import com.cwcdev.dio.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClientService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {

		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClientecomCep(cliente);

	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()) {
			salvarClientecomCep(cliente);
		}
		

	}
	
	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);

	}

	private void salvarClientecomCep(Cliente cliente) {
	    String cep = cliente.getEndereco().getCep();
	    
	    // Verifica se o endereço já existe no banco
	    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
	        Endereco novoEndereco = viaCepService.consultarCep(cep);
	        return enderecoRepository.save(novoEndereco); // Salva o novo endereço antes de associá-lo ao cliente
	    });
	    
	    cliente.setEndereco(endereco);
	    
	    clienteRepository.save(cliente);
	}

	

}
