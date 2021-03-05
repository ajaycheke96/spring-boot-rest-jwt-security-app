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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the transport_route_details database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int position;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to TransportRoute
//	@ManyToOne
//	@JoinColumn(name = "transport_route_id")
//	@JsonIgnoreProperties({ "transportRouteDetails" })
//	private TransportRoute transportRoute;

	// bi-directional many-to-one association to TransportStoppage
	@ManyToOne(targetEntity = TransportStoppage.class)
	@JoinColumn(name = "transport_stoppage_id")
//	@JsonIgnoreProperties({ "transportRouteDetails" })
	private TransportStoppage transportStoppage;

//	// bi-directional many-to-one association to TransportRouteStudent
//	@OneToMany(mappedBy = "transportRouteDetail")
//	private List<TransportRouteStudent> transportRouteStudents;

}