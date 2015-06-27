package org.customerMgr.dao;

import java.util.List;

import org.customerMgr.dao.api.PersonDAO;
import org.customerMgr.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {
     @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
      
    }
 
    @Override
    public void updatePerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
       
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for(Person p : personsList){
            System.out.println("Person List::"+p);
        }
        return personsList;
    }
 
    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Person p = (Person) session.load(Person.class, new Integer(id));
        System.out.println("Person loaded successfully, Person details="+p);
        return p;
    }
 
    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        System.out.println("Person deleted successfully, person details="+p);
    }
 
}
