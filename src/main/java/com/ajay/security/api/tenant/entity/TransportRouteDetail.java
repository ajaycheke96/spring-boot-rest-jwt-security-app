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
 * The persistent class for the transport_route_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transport_route_details")
public class TransportRouteDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int position;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to TransportRoute
	@ManyToOne
	@JoinColumn(name = "transport_route_id")
	private TransportRoute transportRoute;

	// bi-directional many-to-one association to TransportStoppage
	@ManyToOne
	@JoinColumn(name = "transport_stoppage_id")
	private TransportStoppage transportStoppage;

	// bi-directional many-to-one association to TransportRouteStudent
	@OneToMany(mappedBy = "transportRouteDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TransportRouteStudent> transportRouteStudents;

}