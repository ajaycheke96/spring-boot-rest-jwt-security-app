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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the transport_route_students database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transport_route_students")
public class TransportRouteStudent implements Serializable {
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

	// bi-directional many-to-one association to StudentRecord
	@ManyToOne
	@JoinColumn(name = "student_record_id")
	private StudentRecord studentRecord;

	// bi-directional many-to-one association to TransportRouteDetail
	@ManyToOne
	@JoinColumn(name = "transport_route_detail_id")
	private TransportRouteDetail transportRouteDetail;

}