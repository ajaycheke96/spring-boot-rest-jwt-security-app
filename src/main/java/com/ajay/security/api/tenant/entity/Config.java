package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the config database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "is_private")
	private byte isPrivate;

	@Column(length = 20)
	private String name;

	@Column(name = "numeric_value")
	private BigInteger numericValue;

	@Column(name = "text_value", length = 50)
	private String textValue;

}