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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the fee_allocation_groups database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fee_allocation_groups")
public class FeeAllocationGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to FeeAllocation
	@ManyToOne(targetEntity = FeeAllocation.class)
	@JoinColumn(name = "fee_allocation_id")
	private FeeAllocation feeAllocation;

	// bi-directional many-to-one association to FeeGroup
	@ManyToOne(targetEntity = FeeGroup.class)
	@JoinColumn(name = "fee_group_id")
	private FeeGroup feeGroup;

//	// bi-directional many-to-one association to FeeInstallment
//	@OneToMany(mappedBy = "feeAllocationGroup")
//	private List<FeeInstallment> feeInstallments;

}