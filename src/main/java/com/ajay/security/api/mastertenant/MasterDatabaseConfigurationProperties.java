package com.ajay.security.api.mastertenant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data

@Configuration
@ConfigurationProperties("multitenancy.master.datasource")
public class MasterDatabaseConfigurationProperties {

	private String driverClassName;
	private String jdbcUrl;
	private String password;
	private String username;
	
	
	
}
