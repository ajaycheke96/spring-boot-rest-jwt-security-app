package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the stock_transfer_returns database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock_transfer_returns")
public class StockTransferReturn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String options;

	private BigDecimal quantity;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to StockItem
	@ManyToOne(targetEntity = StockItem.class)
	@JoinColumn(name = "stock_item_id")
	private StockItem stockItem;

	// bi-directional many-to-one association to StockTransfer
	@ManyToOne(targetEntity = StockTransfer.class)
	@JoinColumn(name = "stock_transfer_id")
	private StockTransfer stockTransfer;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value = { "backups", "userPushTokens", "userPreferences", "uploads", "todos", "password",
			"postalRecords", "activationToken" })
	private User user;

}