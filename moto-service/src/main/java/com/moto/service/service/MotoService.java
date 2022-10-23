package com.moto.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entity.Moto;
import com.moto.service.repository.MotoRepository;

@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepository;
	
	public List<Moto> getAll() {
		return (List<Moto>) motoRepository.findAll();
	}
	
	public Moto getMotoById(int id) {
		return motoRepository.findById(id).orElse(null);
	}

	public Moto save(Moto moto) {
		Moto nuevaMoto = motoRepository.save(moto);
		return nuevaMoto;
	}
	
	public List<Moto> byUsuarioId(int usuarioId) {
		return motoRepository.findByUsuarioId(usuarioId);
	}


}