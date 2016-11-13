package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Repository @Transactional
public class ContactDAO {
	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getContacts(int start, int limit) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Contact.class);
		
		List<Contact> list = (List<Contact>) hibernateTemplate.findByCriteria(criteria, start, limit);
		Comparator<Contact> comparator = new Comparator<Contact>() {
		    public int compare(Contact c1, Contact c2) {
		        return c2.getId() - c1.getId(); // use your logic
		    }
		};

		Collections.sort(list, comparator); // use the comparator as much as u want
		//System.out.println(list);
		return list;

		//return hibernateTemplate.findByCriteria(criteria, start, limit);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getContacts() {
		return (List<Contact>) hibernateTemplate.find("from Contact");
	}
	
	public Contact getContact(String email) {
		Object[] paramArr = new Object[1];
        paramArr[0] = new String(email);
        try {
            return (Contact) hibernateTemplate.find("from Contact where email=?", paramArr).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
	}

	
	public void deleteContact(int id){
		Object record = hibernateTemplate.load(Contact.class, id);
		hibernateTemplate.delete(record);
	}
	
	public Contact saveContact(Contact contact){
		hibernateTemplate.saveOrUpdate(contact);
		return contact;
	}
	
	
	public int getTotalContacts(){
		return DataAccessUtils.intResult(hibernateTemplate.find("SELECT COUNT(*) FROM Contact"));
	}

}
