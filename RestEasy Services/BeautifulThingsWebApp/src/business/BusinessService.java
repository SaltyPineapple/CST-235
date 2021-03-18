package business;

import java.util.ArrayList;
import java.util.Queue;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Thing;
import database.DatabaseInterface;


@Local
@Stateless
@Alternative

public class BusinessService implements BusinessServiceInterface{

	@Inject
	DatabaseInterface db;

	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="java:/jms/queue/Thing")
	private Queue queue;
	
	@Override
	public int insertOne(Thing t) {
		return db.insertOne(t);
	}

	@Override
	public ArrayList<Thing> readAll() {
		return db.readAll();
	}

	@Override
	public void sendThing(Thing t) {
		// Send a Message for an Order
		try 
		{
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer((Destination) queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}

		
	}
	
	
	

}
