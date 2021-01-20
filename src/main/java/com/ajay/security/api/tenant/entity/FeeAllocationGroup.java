package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the fee_allocation_groups database table.
 * 
 */
@Data
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
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to FeeAllocation
	@ManyToOne
	@JoinColumn(name = "fee_allocation_id")
	private FeeAllocation feeAllocation;

	// bi-directional many-to-one association to FeeGroup
	@ManyToOne
	@JoinColumn(name = "fee_group_id")
	private FeeGroup feeGroup;

	// bi-directional many-to-one association to FeeInstallment
	@OneToMany(mappedBy = "feeAllocationGroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FeeInstallment> feeInstallments;

}