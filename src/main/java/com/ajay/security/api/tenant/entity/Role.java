package com.ajay.security.api.tenant.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "roles_2")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(name = "guard_name")
	private String guardName;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to ModelHasRole
//	@OneToMany(mappedBy="role")
//	private List<ModelHasRole> modelHasRoles;

	// bi-directional many-to-many association to Permission
//	@ManyToMany
//	@JoinTable(
//		name="role_has_permissions"
//		, joinColumns={
//			@JoinColumn(name="role_id")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="permission_id")
//			}
//		)
//	private List<Permission> permissions;

}
