package com.ajay.security.api.tenant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the taggables database table.
 * 
 */
//@DynamicInsert
//@DynamicUpdate

//@Data
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "taggables")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties("hibernateLazyInitializer")
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

	// bi-directional many-to-one association to Tag
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id")
//	@JsonBackReference
	@JsonIgnoreProperties(value = {"taggables", "hibernateLazyInitializer"}) //, allowSetters = true
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Tag tag;

}