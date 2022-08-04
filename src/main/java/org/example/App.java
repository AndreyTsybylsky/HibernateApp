package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try{
        currentSession.beginTransaction();

            Person person = currentSession.get(Person.class, 2);
            person.setName("New name");
            currentSession.getTransaction().getStatus();


            currentSession.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
