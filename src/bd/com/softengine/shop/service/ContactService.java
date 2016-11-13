package bd.com.softengine.shop.service;


import bd.com.softengine.shop.dao.ContactDAO;
import bd.com.softengine.shop.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class ContactService {
	
	private ContactDAO contactDAO;

	@Transactional(readOnly=true)
	public List<Contact> getContactList(int start, int limit){
		
		return contactDAO.getContacts(start, limit);
	}
	
	@Transactional(readOnly=true)
	public List<Contact> getContactList(){
		
		return contactDAO.getContacts();
	}
	

	@Transactional(readOnly=true)
	public Contact getContact(String email){
		
		return contactDAO.getContact(email);
	}

	@Transactional
	public List<Contact> create(Contact contact){
		
        List<Contact> newContacts = new ArrayList<Contact>();
		
		newContacts.add(contactDAO.saveContact(contact));
		
		return newContacts;
	}
	

	@Transactional
	public List<Contact> update(Contact contact){
		
		List<Contact> returnContacts = new ArrayList<Contact>();
		
		returnContacts.add(contactDAO.saveContact(contact));
		
		return returnContacts;
	}
	

	@Transactional
	public void delete(Contact contact){
		
		contactDAO.deleteContact(contact.getId());
	}
	

	public int getTotalContacts(){

		return contactDAO.getTotalContacts();
	}


	@Autowired
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
}
