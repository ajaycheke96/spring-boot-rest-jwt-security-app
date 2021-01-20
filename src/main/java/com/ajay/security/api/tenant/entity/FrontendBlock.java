package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the frontend_blocks database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "frontend_blocks")
public class FrontendBlock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Lob
	private String body;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "featured_icon",length = 100)
	private String featuredIcon;

	@Column(name = "featured_image",length = 100)
	private String featuredImage;

	@Column(name = "is_draft")
	private byte isDraft;

	@Column(length = 50)
	private String options;

	@Column(length = 20)
	private int position;

	@Column(length = 50)
	private String title;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 100)
	private String url;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to FrontendMenus
	@ManyToOne
	@JoinColumn(name = "frontend_menu_id")
	private FrontendMenus frontendMenus;

}