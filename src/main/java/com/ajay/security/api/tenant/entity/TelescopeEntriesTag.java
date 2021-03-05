package com.ajay.security.api.tenant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the telescope_entries_tags database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "telescope_entries_tags")
public class TelescopeEntriesTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 50)
	private String tag;

//	// bi-directional many-to-one association to TelescopeEntry
	@ManyToOne
	@JoinColumn(name = "entry_uuid")
	@JsonIgnoreProperties("telescopeEntriesTags")
	private TelescopeEntry telescopeEntry;

}