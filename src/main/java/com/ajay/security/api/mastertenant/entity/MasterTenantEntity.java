package com.ajay.security.api.mastertenant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "master_tenant_tab")
public class MasterTenantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "database_name")
	private String tenantId;
	@Column(name = "driver_class_name")
	private String driverClassName;
	@Column(name = "jdbc_url")
	private String jdbcUrl;
	private String username;
	private String password;
	private String status;

}
