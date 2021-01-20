package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the uploads database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "uploads")
public class Upload implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	private String filename;

	@Column(name = "is_temp_delete")
	private byte isTempDelete;

	private String module;

	@Column(name = "module_id")
	private int moduleId;

	@Lob
	private String options;

	private byte status;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(name = "user_filename")
	private String userFilename;

	private String uuid;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}