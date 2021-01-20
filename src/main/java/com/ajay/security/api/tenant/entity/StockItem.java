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
 * The persistent class for the stock_items database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock_items")
public class StockItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 20)
	private String code;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(length = 20)
	private String name;

	@Column(name = "opening_quantity", length = 10)
	private int openingQuantity;

	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int quantity;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to BillItem
	@OneToMany(mappedBy = "stockItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BillItem> billItems;

	// bi-directional many-to-one association to StockCategory
	@ManyToOne
	@JoinColumn(name = "stock_category_id")
	private StockCategory stockCategory;

	// bi-directional many-to-one association to StockPurchaseDetail
	@OneToMany(mappedBy = "stockItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StockPurchaseDetail> stockPurchaseDetails;

	// bi-directional many-to-one association to StockTransferDetail
	@OneToMany(mappedBy = "stockItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StockTransferDetail> stockTransferDetails;

	// bi-directional many-to-one association to StockTransferReturn
	@OneToMany(mappedBy = "stockItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StockTransferReturn> stockTransferReturns;

}