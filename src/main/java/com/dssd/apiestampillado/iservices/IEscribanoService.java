package com.dssd.apiestampillado.iservices;

import com.dssd.apiestampillado.models.Escribano;

public interface IEscribanoService {
	
	public Escribano findByUsernameAndPassword(String username, String password);
	public Escribano findByEmail(String email);
	public Escribano findByUsername(String username);
	
	public Boolean existByUsernameAndPassword(String username, String password);
	public Boolean existByEmail(String email);
	public Boolean existByUsername(String username);

}
