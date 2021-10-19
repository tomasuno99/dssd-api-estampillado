package com.dssd.apiestampillado.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dssd.apiestampillado.models.Escribano;
import com.dssd.apiestampillado.repository.EscribanoRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
    private EscribanoRepository escribanoRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Escribano escribano = escribanoRepository.findByUsername(username);
        if (escribano == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(escribano.getUsername(), escribano.getPassword(), new ArrayList<>());
    }

	public EscribanoRepository getEscribanoRepository() {
		return escribanoRepository;
	}

	public void setEscribanoRepository(EscribanoRepository escribanoRepository) {
		this.escribanoRepository = escribanoRepository;
	}

	public PasswordEncoder getBcryptEncoder() {
		return bcryptEncoder;
	}

	public void setBcryptEncoder(PasswordEncoder bcryptEncoder) {
		this.bcryptEncoder = bcryptEncoder;
	}
	
}
