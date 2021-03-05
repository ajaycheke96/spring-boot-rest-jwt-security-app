package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the frontend_menus database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "frontend_menus")
public class FrontendMenus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 30)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int position;

	@Column(length = 50)
	private String slug;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to FrontendBlock
//	@OneToMany(mappedBy = "frontendMenus", cascade = CascadeType.ALL)
	@OneToMany(targetEntity = FrontendBlock.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "frontend_menu_id")
//	@JsonIgnoreProperties("frontendMenus")
	private List<FrontendBlock> frontendBlocks;

//	// bi-directional many-to-one association to FrontendPage
//	@ManyToOne
//	@JoinColumn(name = "frontend_page_id")
//	@JsonIgnoreProperties("frontendMenuses")
//	private FrontendPage frontendPage;

//	// bi-directional many-to-one association to FrontendMenus
//	@ManyToOne
//	@JoinColumn(name = "parent_id")
//	@JsonIgnoreProperties("frontendMenuses")
//	private FrontendMenus frontendMenus;

	// bi-directional many-to-one association to FrontendMenus
//	@OneToMany(mappedBy = "frontendMenus", cascade = CascadeType.ALL)
	@OneToMany(targetEntity = FrontendMenus.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")
//	@JsonIgnoreProperties("frontendMenus")
	private List<FrontendMenus> frontendMenuses;

}