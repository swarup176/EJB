package com.cts.ejb.training.facade;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;



/**
 * Message-Driven Bean implementation class for: TestMDB
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) },mappedName = "queueJNDI")
public class TestMDB implements MessageListener {
	
	
	@Resource
	private MessageDrivenContext mdc;
	@EJB
	StudentDao studentDao;	
	@PostConstruct
	public void test()
	{
		System.out.println("Hi i am a mdb instance");
	}
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	TextMessage objectMessage = (TextMessage) message;
		try {
			System.out.println("Received : "
					+ objectMessage.getClass().getName());
			System.out.println("Received : "
					+ objectMessage.getJMSCorrelationID());
			if ("swarup".equals(objectMessage
					.getJMSCorrelationID())) {
				String name=objectMessage.getStringProperty("name");
				System.out.println("message received "+name);
				studentDao.insert(name);
				
			}
		} catch (JMSException e) {
			e.printStackTrace();
			mdc.setRollbackOnly();
		}
        
    }

}
