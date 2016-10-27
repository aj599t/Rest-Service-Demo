package edu.usc.rest.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import edu.usc.rest.messenger.database.DatabaseClass;
import edu.usc.rest.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello", "Ankita"));
		messages.put(2L, new Message(2, "Hi", "Jersey"));
	}
	
	public List<Message> getAllMessages(){		
		return new ArrayList(messages.values());	
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public List<Message> getAllMessagesForYear(int year){
		
		List messageForYear = new ArrayList();
		Calendar cal = Calendar.getInstance();
		for(Message m : messages.values()){
			
			cal.setTime(m.getCreated());
			if(cal.get(Calendar.YEAR) == year)
				messageForYear.add(m);
		}
		
		return messageForYear;	
	}
	
	public List<Message>getAllMessagesForPagination(int start, int size){
		ArrayList list = new ArrayList(messages.values());
		return list.subList(start, start + size);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0)
			return null;
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);		
	}
}
