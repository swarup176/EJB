package com.cts.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="EVENT_PARTICIPANT")
@IdClass(value=EventParticipantPK.class)
public class EventParticipant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6884211116673310377L;
    @Id
	@Column(name="EVENT_ID")
	private Integer eventId;
	
    @Id
	@Column(name="PARTICIPANT_ID")
	private Integer participantId;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	
	@Column(name="DATE_OF_REGISTRATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 @JoinColumn(name="EVENT_ID")
	private Event event;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PARTICIPANT_ID")
	private Participant participant;
	

	

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	
	
}
