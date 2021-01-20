package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the stock_purchase_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock_purchase_details")
public class StockPurchaseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String options;

	private BigDecimal quantity;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to StockItem
	@ManyToOne
	@JoinColumn(name = "stock_item_id")
	private StockItem stockItem;

	// bi-directional many-to-one association to StockPurchas
	@ManyToOne
	@JoinColumn(name = "stock_purchase_id")
	private StockPurchase stockPurchas;

}