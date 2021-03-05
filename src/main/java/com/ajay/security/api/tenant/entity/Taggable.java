package com.ajay.security.api.tenant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the taggables database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "taggables")
public class Taggable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String options;

	@Column(name = "taggable_id")
	private int taggableId;

	@Column(name = "taggable_type", length = 50)
	private String taggableType;

//	// bi-directional many-to-one association to Tag
//	@ManyToOne
//	@JoinColumn(name = "tag_id")
//	@JsonIgnoreProperties(value = { "taggables" })
//	private Tag tag;

}