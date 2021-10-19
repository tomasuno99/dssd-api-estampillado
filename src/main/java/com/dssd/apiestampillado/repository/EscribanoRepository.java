package com.dssd.apiestampillado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dssd.apiestampillado.models.Escribano;

public interface EscribanoRepository extends JpaRepository<Escribano, Long>{

	public Escribano findByUsernameAndPassword(String username, String password);
	public Escribano findByEmail(String email);
	public Escribano findByUsername(String username);
	
	public Boolean existsByUsernameAndPassword(String username, String password);
	public Boolean existsByEmail(String email);
	public Boolean existsByUsername(String username);
	
}
