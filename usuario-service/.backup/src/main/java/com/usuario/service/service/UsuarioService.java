package com.usuario.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entity.Usuario;
import com.usuario.service.model.Carro;
import com.usuario.service.model.Moto;
import com.usuario.service.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Carro> getCarros(int usuarioId) {
		List<Carro> carros = restTemplate.getForObject(
				"http://localhost:8002/carros/usuarios/" + usuarioId, List.class);
		return carros;
	}
	
	public List<Moto> getMotos(int usuarioId) {
		List<Moto> motos = restTemplate.getForObject(
				"http://localhost:8003/motos/usuarios/" + usuarioId, List.class);
		return motos;
	}
	
	public List<Usuario> getAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario save(Usuario usuario) {
		Usuario nuevoUsuario = usuarioRepository.save(usuario);
		return nuevoUsuario;
	}
	
}
