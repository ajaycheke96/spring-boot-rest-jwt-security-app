package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the stock_items database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to BillItem
	@OneToMany(mappedBy = "stockItem")
	@JsonIgnore
	@JsonIgnoreProperties("stockItem")
	private List<BillItem> billItems;

	// bi-directional many-to-one association to StockCategory
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_category_id")
//	@JsonIgnore
	@JsonIgnoreProperties(value = { "stockItems", "hibernateLazyInitializer" })
	private StockCategory stockCategory;

	// bi-directional many-to-one association to StockPurchaseDetail
	@OneToMany(mappedBy = "stockItem")
	@JsonIgnore
	@JsonIgnoreProperties("stockItem")
	private List<StockPurchaseDetail> stockPurchaseDetails;

	// bi-directional many-to-one association to StockTransferDetail
	@OneToMany(mappedBy = "stockItem")
	@JsonIgnore
	@JsonIgnoreProperties("stockItem")
	private List<StockTransferDetail> stockTransferDetails;

	// bi-directional many-to-one association to StockTransferReturn
	@OneToMany(mappedBy = "stockItem")
	@JsonIgnore
	@JsonIgnoreProperties("stockItem")
	private List<StockTransferReturn> stockTransferReturns;

}