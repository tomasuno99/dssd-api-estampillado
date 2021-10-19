package com.dssd.apiestampillado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssd.apiestampillado.iservices.IEscribanoService;
import com.dssd.apiestampillado.models.Escribano;
import com.dssd.apiestampillado.repository.EscribanoRepository;

@Service
public class EscribanoService implements IEscribanoService {
	
	@Autowired
    private EscribanoRepository escribanoRespository;

	@Override
	public Escribano findByUsernameAndPassword(String username, String password) {
		try {
			return escribanoRespository.findByUsernameAndPassword(username, password);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Escribano findByUsername(String username) {
		try {
			return escribanoRespository.findByUsername(username);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Escribano findByEmail(String email) {
		try {
			return escribanoRespository.findByEmail(email);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean existByUsernameAndPassword(String username, String password) {
		try {
			return escribanoRespository.existsByUsernameAndPassword(username, password);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean existByEmail(String email) {
		try {
			return escribanoRespository.existsByEmail(email);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean existByUsername(String username) {
		try {
			return escribanoRespository.existsByUsername(username);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
	
	public EscribanoRepository getEscribanoRespository() {
		return escribanoRespository;
	}

	public void setEscribanoRespository(EscribanoRepository escribanoRespository) {
		this.escribanoRespository = escribanoRespository;
	}

}
