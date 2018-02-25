package com.cts.ejb.training.facade;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless(name="MessageSenderImpl",mappedName="MessageSenderImpl")
@LocalBean

public class MessageSenderImpl {
	@Resource(mappedName = "queueConFactory")
	ConnectionFactory connectionFactory;
	
	@Resource(mappedName = "queueJNDI")
	Queue queue;
	
	
	public  void sendData(String name){
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
		
		Session session= connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer=session.createProducer(queue);
		TextMessage textMessage=session.createTextMessage();
		textMessage.setJMSCorrelationID("swarup");
		textMessage.setStringProperty("name",name);
		messageProducer.send(textMessage);
		session.close();
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
}
