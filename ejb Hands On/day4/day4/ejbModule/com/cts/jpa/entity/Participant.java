package com.cts.jpa.entity;

import java.io.Serializable;
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

@Entity
@Table(name="Participant")
@SequenceGenerator(name = "ProductSeq", sequenceName = "PERSON_SEQ")
public class Participant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8171007130766311036L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSeq")
	@Column(name="PARTICIPANT_ID")
	private Integer participantId;
	
	@Column
	private String name;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy="participant")
	private Set<EventParticipant> eventParticipantList = new HashSet<EventParticipant>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getParticipantId() {
		return participantId;
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
