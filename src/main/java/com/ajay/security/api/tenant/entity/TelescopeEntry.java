package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the telescope_entries database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "telescope_entries")
public class TelescopeEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer sequence;

	@Column(name = "batch_id", length = 50)
	private String batchId;

	@Column(length = 100)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "family_hash", length = 50)
	private String familyHash;

	@Column(name = "should_display_on_index")
	private byte shouldDisplayOnIndex;

	@Column(length = 50)
	private String type;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to TelescopeEntriesTag
	@OneToMany(mappedBy = "telescopeEntry", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TelescopeEntriesTag> telescopeEntriesTags;

}