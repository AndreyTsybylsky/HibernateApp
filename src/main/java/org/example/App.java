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

            Person person1 = new Person("Test1", 30);
            Person person2 = new Person("Test2", 30);
            Person person3 = new Person("Test3", 30);

            currentSession.save(person1);
            currentSession.save(person2);
            currentSession.save(person3);


            currentSession.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
