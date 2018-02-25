package com.cts.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EVENT")
@SequenceGenerator(name = "ProductSeq", sequenceName = "PERSON_SEQ")
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5282633500376620726L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSeq")
	@Column(name="EVENT_ID")
	private Integer eventId;
	
	@Column
	private String name;
	
	@Column(name="EVENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventDate;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy="event")
	private Set<EventParticipant> eventParticipantList = new HashSet<EventParticipant>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getEventId() {
		return eventId;
	}
	
	public Set<EventParticipant> getEventParticipantList() {
		return eventParticipantList;
	}

	public void setEventParticipantList(Set<EventParticipant> eventParticipantList) {
		this.eventParticipantList = eventParticipantList;
	}
	
	public void addEvenetParticipant(final EventParticipant eventParticipant){
		eventParticipantList.add(eventParticipant);
	}
	
}
