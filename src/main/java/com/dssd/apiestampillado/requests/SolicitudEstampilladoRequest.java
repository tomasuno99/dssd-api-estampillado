package com.dssd.apiestampillado.requests;

import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

public class SolicitudEstampilladoRequest {
	
	@NotNull
	private MultipartFile estatuto;
	
	@NotNull
	private String nuExpediente;
	
	public MultipartFile getEstatuto() {
		return estatuto;
	}

	public void setEstatuto(MultipartFile estatuto) {
		this.estatuto = estatuto;
	}

	public String getNuExpediente() {
		return nuExpediente;
	}

	public void setNuExpediente(String nu_expediente) {
		this.nuExpediente = nu_expediente;
	}
	
}
