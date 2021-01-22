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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the bill_items database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bill_items")
public class BillItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	private BigDecimal amount;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "custom_item_name")
	private String customItemName;

	@Lob
	private String description;

	private BigDecimal discount;

	@Lob
	private String options;

	private BigDecimal quantity;

	private BigDecimal tax;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	private String uuid;

	// bi-directional many-to-one association to Bill
	@ManyToOne
	private Bill bill;

	// bi-directional many-to-one association to StockItem
	@ManyToOne
	@JoinColumn(name = "stock_item_id")
	private StockItem stockItem;

}