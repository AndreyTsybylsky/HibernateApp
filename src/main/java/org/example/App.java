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

            Person some_name = new Person("Some name", 60);
            currentSession.save(some_name);

            currentSession.getTransaction().commit();
            System.out.println(some_name.getId());


            currentSession.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
