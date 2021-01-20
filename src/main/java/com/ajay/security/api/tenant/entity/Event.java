package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the events database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "events")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String audience;

	@Column(name = "CHARACTER_SET_CLIENT",length = 50)
	private String characterSetClient;

	@Column(name = "COLLATION_CONNECTION",length = 50)
	private String collationConnection;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "DATABASE_COLLATION",length = 50)
	private String databaseCollation;

	@Column(name = "`DEFINER`",length = 50)
	private String definer;

	@Column(length = 50)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "end_time")
	private Time endTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ends;

	@Column(name = "EVENT_BODY",length = 50)
	private String eventBody;

	@Column(name = "EVENT_CATALOG",length = 50)
	private String eventCatalog;

	@Column(name = "EVENT_COMMENT",length = 50)
	private String eventComment;

	@Lob
	@Column(name = "EVENT_DEFINITION",length = 50)
	private String eventDefinition;

	@Column(name = "EVENT_NAME",length = 50)
	private String eventName;

	@Column(name = "EVENT_SCHEMA",length = 50)
	private String eventSchema;

	@Column(name = "EVENT_TYPE",length = 50)
	private String eventType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXECUTE_AT")
	private Date executeAt;

	@Column(name = "INTERVAL_FIELD",length = 50)
	private String intervalField;

	@Column(name = "INTERVAL_VALUE",length = 50)
	private String intervalValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ALTERED")
	private Date lastAltered;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_EXECUTED")
	private Date lastExecuted;

	@Column(name = "ON_COMPLETION",length = 50)
	private String onCompletion;

	@Column(length = 50)
	private String options;

	private BigInteger originator;

	@Column(name = "SQL_MODE",length = 50)
	private String sqlMode;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "start_time")
	private Time startTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date starts;

	@Column(length = 20)
	private String status;

	@Column(name = "TIME_ZONE",length = 50)
	private String timeZone;

	@Column(length = 50)
	private String title;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	@Column(length = 50)
	private String venue;

	// bi-directional many-to-one association to EventBatch
	@OneToMany(mappedBy = "event",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventBatch> eventBatches;

	// bi-directional many-to-one association to EventCourse
	@OneToMany(mappedBy = "event",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventCourse> eventCourses;

	// bi-directional many-to-one association to EventDepartment
	@OneToMany(mappedBy = "event",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventDepartment> eventDepartments;

	// bi-directional many-to-one association to EventEmployeeCategory
	@OneToMany(mappedBy = "event",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventEmployeeCategory> eventEmployeeCategories;

	// bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name = "event_type_id")
	private EventType eventTypeBean;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}