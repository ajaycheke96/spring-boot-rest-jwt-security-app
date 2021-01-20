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
 * The persistent class for the stock_transfer_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock_transfer_details")
public class StockTransferDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "custom_item_name", length = 50)
	private String customItemName;

	@Column(length = 50)
	private String description;

	@Column(name = "is_consumable")
	private byte isConsumable;

	@Column(length = 50)
	private String options;

	private BigDecimal quantity;

	@Column(name = "return_quantity")
	private BigDecimal returnQuantity;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to StockItem
	@ManyToOne
	@JoinColumn(name = "stock_item_id")
	private StockItem stockItem;

	// bi-directional many-to-one association to StockTransfer
	@ManyToOne
	@JoinColumn(name = "stock_transfer_id")
	private StockTransfer stockTransfer;

}