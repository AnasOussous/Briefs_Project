package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.*;


public class ProfImp implements DAO<Prof> {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void Add(Prof prof) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(prof);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Delete(Prof prof) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Prof user = (Prof) session.get(Prof.class, prof.getIdprof());
        session.delete(user);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Update(Prof prof) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(prof);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectAll(Prof prof) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        prof = (Prof) session.get(Prof.class, prof.getIdprof());
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectById(Prof prof) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        prof = (Prof) session.get(Prof.class, prof.getIdprof());
        session.getTransaction().commit();
		session.close();
	}

}
