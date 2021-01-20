package com.ajay.security.api.tenant.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "roles_2")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="guard_name")
	private String guardName;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to ModelHasRole
//	@OneToMany(mappedBy="role")
//	private List<ModelHasRole> modelHasRoles;

	//bi-directional many-to-many association to Permission
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
