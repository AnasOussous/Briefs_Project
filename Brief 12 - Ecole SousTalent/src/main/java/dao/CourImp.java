package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.*;

public class CourImp implements DAO <Cour>{

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void Add(Cour cour) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(cour);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Delete(Cour cour) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Cour user = (Cour) session.get(Cour.class, cour.getIdcour());
        session.delete(user);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Update(Cour cour) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(cour);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectAll(Cour cour) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        cour = (Cour) session.get(Cour.class, cour.getIdcour());
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectById(Cour cour) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        cour = (Cour) session.get(Cour.class, cour.getIdcour());
        session.getTransaction().commit();
		session.close();
	}

}
