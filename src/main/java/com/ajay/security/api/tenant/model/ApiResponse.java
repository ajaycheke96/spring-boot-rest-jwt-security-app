package com.ajay.security.api.tenant.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class ApiResponse implements Serializable {

	@AllArgsConstructor
	public static class Error implements Serializable {
		int code;
		String message;
	}

	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	LocalDateTime timestamp;
	int status;
	Error error;
	String message;
	Object data;
}
