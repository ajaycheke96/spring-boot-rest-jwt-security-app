package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	private String id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String options;

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
	@OneToMany(mappedBy = "transportRouteDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<TransportRouteStudent> transportRouteStudents;

}