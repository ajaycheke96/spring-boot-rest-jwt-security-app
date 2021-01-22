package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the user_preferences database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user_preferences")
public class UserPreference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "color_theme", length = 50)
	private String colorTheme;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String direction;

	@Column(length = 20)
	private String locale;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String sidebar;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}