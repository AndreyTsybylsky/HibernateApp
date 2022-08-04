package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

            List<Person> people = currentSession.createQuery("FROM Person where name LIKE 'T%'").getResultList();

            for(Person person: people){
                System.out.println(person);
            }

            currentSession.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
