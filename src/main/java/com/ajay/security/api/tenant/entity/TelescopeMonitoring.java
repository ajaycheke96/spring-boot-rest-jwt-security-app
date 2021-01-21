package com.ajay.security.api.tenant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the telescope_monitoring database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "telescope_monitoring")
public class TelescopeMonitoring implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 50)
	private String tag;

}