package com.cts.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.IdClass;




public class EventParticipantPK implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4607718528680659481L;


	
	private Integer eventId;
	

	
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

	@Override
	public boolean equals(Object obj) {
		EventParticipantPK participantPK = (EventParticipantPK)obj;
		return participantPK.getEventId() == eventId && participantPK.getParticipantId() == participantId;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int h = 0;
		if(eventId != null){
			h = h+eventId.hashCode();
		}
		if(participantId != null){
			h += participantId.hashCode();
		}
		return  h;
	}

	
	
	
	
}
