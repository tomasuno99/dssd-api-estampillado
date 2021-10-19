package com.dssd.apiestampillado.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dssd.apiestampillado.models.Escribano;
import com.dssd.apiestampillado.requests.SolicitudEstampilladoRequest;

@RestController
@RequestMapping("/estampillado")
public class EstampilladoController {
	
	@PostMapping("estampillar")
	public ResponseEntity<String> generarEstampillado(@ModelAttribute SolicitudEstampilladoRequest solicitud){
		String hash = org.apache.commons.codec.digest.DigestUtils.sha256Hex(solicitud.getNuExpediente());
		return ResponseEntity.ok(hash);
	}
}
